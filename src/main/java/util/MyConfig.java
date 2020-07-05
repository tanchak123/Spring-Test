package util;

import entity.animals.Cat;
import entity.animals.Dog;
import entity.weekdays.Friday;
import entity.weekdays.Monday;
import entity.weekdays.Saturday;
import entity.weekdays.Sunday;
import entity.weekdays.Thursday;
import entity.weekdays.Tuesday;
import entity.weekdays.Wednesday;
import interfaces.WeekDay;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("entity.animals")
public class MyConfig {

    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY : return new Monday();
            case TUESDAY: return new Tuesday();
            case WEDNESDAY: return new Wednesday();
            case THURSDAY : return new Thursday();
            case FRIDAY : return new Friday();
            case SATURDAY : return new Saturday();
            default: return new Sunday();
        }
    }

    @Bean("cat")
    public Cat getCat() {
        return new Cat();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        WeekDay weekDay = applicationContext.getBean(WeekDay.class);
        System.out.println(weekDay.getWeeksDayName());
        Cat cat = (Cat) applicationContext.getBean("cat");
        System.out.println(cat.getName());
        System.out.println(applicationContext.getBean(Dog.class).getName());
    }
}
