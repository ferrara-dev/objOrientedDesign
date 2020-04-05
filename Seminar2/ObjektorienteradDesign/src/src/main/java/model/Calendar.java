package model;

import model.customermodel.CustomerId;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Calendar {
    static private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static private LocalDateTime now;

    public static String getTimeAndDate(){
        now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static int getAge(String id){
        StringBuilder sb = new StringBuilder(id);

        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);  //Birth date
        Period p = Period.between(birthday, today);

        return p.getYears();
    }

    public static DayOfWeek getDayOfTheWeek(){
        now = LocalDateTime.now();

        return DayOfWeek.from(now);
    }
}
