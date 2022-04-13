package model;

import java.util.Calendar;

public class DataConvert {

    public static String toString(Calendar calendar){
        String day = "" + calendar.get(Calendar.DAY_OF_MONTH);
        String month = "" + calendar.get(Calendar.MONTH);
        String year = "" + calendar.get(Calendar.YEAR);

        if (day.length() < 2)
            day = "0" + day;
        if (month.length() < 2)
            month = "0" + month;

        while (year.length() < 4)
            year = "0" + year;

        return day + "-" + month + "-" + year;
    }

    public static Calendar toCalendar(String str){
        String[] splitted = str.split("-");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(splitted[0]);
        int month = Integer.parseInt(splitted[1]);
        int day = Integer.parseInt(splitted[2]);
        calendar.set(year, month, day);
        return calendar;
    }
    
}
