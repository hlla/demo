package com.example;

/**
 * Created by chengjian on 17-10-19.
 */

public class TestVolatile {
    private static /*volatile*/ boolean stop = false;

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        System.out.println("test Thread time=" + System.currentTimeMillis() / 1000);
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                    System.out.println("hello");
                }
                System.out.println("end");
            }
        });
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("Stop Thread time=" + System.currentTimeMillis() / 1000);
        stop = true;
    }
}
