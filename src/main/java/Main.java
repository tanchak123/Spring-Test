import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.config.AppConfig;
import test.model.User;
import test.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        User user = new User();
        user.setLogin("sanya");
        user.setPassword("123");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.add(user);
        userService.add(new User("sanya2", "1231313"));
        System.out.println(userService.listUsers());
    }
}
