package programmers;

import java.util.Calendar;

public class DayOfWeek {
    public String solution(int month, int day) {
        //Calendar.MONTH는 1적게 나오는 것 감안해야함.
        String[] date = {"SUN", "MON", "TUE", "WED" ,"THU", "FRI", "SAT"};
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, month - 1, day).build();
        return date[cal.get(Calendar.DAY_OF_WEEK)];
    }
}

