package com.example.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chengjian on 17-12-7.
 */

public class TestBB {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("HH:mm");
//        Calendar.getInstance().setTime(new Date());
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        try {
            Date nowDate = new Date();
            Date date = df.parse("20:00");
            Calendar.getInstance().set(Calendar.HOUR,date.getHours());
//            nowDate.setMinutes();
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        new MemoryTest().test();
    }

}
