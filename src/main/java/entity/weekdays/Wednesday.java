package entity.weekdays;

import interfaces.WeekDay;
import org.springframework.stereotype.Component;

@Component
public class Wednesday implements WeekDay {

    @Override
    public String getWeeksDayName() {
        return "Wednesday";
    }
}
