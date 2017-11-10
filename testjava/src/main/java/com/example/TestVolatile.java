package com.example;

import java.util.LinkedList;

/**
 * Created by chengjian on 17-10-19.
 */

public class TestVolatile {
    private static /*volatile*/ boolean stop = false;

    public static void main(String[] args) {
//        test1();
        LinkedList<TestVolatile> strings = new LinkedList<>();
//        HashSet<TestVolatile> strings = new HashSet<>();
//        ArrayList<TestVolatile> strings = new ArrayList<>();
        long time = System.currentTimeMillis();
        TestVolatile testVolatile = null;
        for (int i = 0; i <= 9500000; i++) {
            if (i == 0) {
                testVolatile = new TestVolatile();
                strings.add(testVolatile);
            } else {
                strings.add(new TestVolatile());
            }
        }

        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
//        Iterator<TestVolatile> iter = strings.iterator();
//        while (iter.hasNext()) {
//            iter.next();
//        }
//
        for (int i = 0; i < 100; i++) {
//            strings.add(0, new TestVolatile());
            boolean ss = strings.remove(testVolatile);
        }
//        System.out.println(ss);
//        HashSet<TestVolatile> stringHashSet = new HashSet<>();
//        for (int i = 0; i < 1500000; i++) {
//            stringHashSet.add(new TestVolatile());
//        }
        System.out.println(System.currentTimeMillis() - time);
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
