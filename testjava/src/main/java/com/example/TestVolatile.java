package com.example;

import java.util.concurrent.TimeUnit;

public class TestVolatile {
    private static /* volatile */ boolean stop = false;

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                int a = 0;
                String sa = null;
                while (!stop) {
                    a = i * i * i * i;
                    i++;
                    sa = new String(i + "");
                    // System.out.println("hello");
                    // try {
                    // Thread.currentThread().sleep(1);
                    // } catch (InterruptedException e) {
                    // // TODO Auto-generated catch block
                    // e.printStackTrace();
                    // }
                }
                // System.out.println(sa);
            }
        });
        t.start();

        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Stop Thread");
        stop = true;
    }
}
