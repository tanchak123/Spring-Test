package entity.weekdays;

import interfaces.WeekDay;
import org.springframework.stereotype.Component;

@Component
public class Sunday implements WeekDay {

    @Override
    public String getWeeksDayName() {
        return "Sunday";
    }
}
