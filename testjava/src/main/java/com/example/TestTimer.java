package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chengjian on 17-10-12.
 */

public class TestTimer {
    static int i = 0;

    public static void main(String[] args) {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date startDate = new Date();
        try {
            startDate = dateFormatter.parse("2010/11/28 01:06:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(" time=" + dateFormatter.format(new Date()));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                i++;
                System.out.println(" time=" + dateFormatter.format(new Date()) + " tid=" +
                        Thread.currentThread().getId());
                try {
//                    if (i == 4) {
//                        Thread.sleep(5000);
//                    } else {
                    Thread.sleep(1000);
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
    }
}
