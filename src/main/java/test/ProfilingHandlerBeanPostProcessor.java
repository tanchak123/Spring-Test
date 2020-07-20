package test;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller,
                new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean.getClass().isAnnotationPresent(Profiling.class)) {
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (map.get(beanName) != null) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, java.lang.reflect.Method method,
                                             Object[] args) throws Throwable {
                            if (controller.isEnable()) {
                                System.out.println("PROFILIRUU....");
                                long before = System.nanoTime();
                                Object retVal = method.invoke(bean, args);
                                long after = System.nanoTime();
                                System.out.println(after - before);
                                System.out.println("VSE!");
                                return retVal;
                            } else {
                                return method.invoke(bean, args);
                            }
                        }
                    });
        }
        return bean;
    }
}
