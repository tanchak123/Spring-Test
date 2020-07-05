package entity.weekdays;

import interfaces.WeekDay;

public class Saturday implements WeekDay {
    @Override
    public String getWeeksDayName() {
        return "Saturday";
    }
}
