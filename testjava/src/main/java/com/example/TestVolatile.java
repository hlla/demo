package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by chengjian on 17-10-19.
 */

public class TestVolatile {
    private static final boolean isTest = isTestAA();
    static /*volatile*/ boolean stop = false;

    static {
        Exception exception = new Exception("static()");
        exception.printStackTrace();
        System.out.println("isTestAAbbbbb() exception=" + exception);
    }

    public static boolean isTestAA() {
        TestVolatile testVolatile = new TestVolatile();
        Exception exception = new Exception("isTestAA()");
        exception.printStackTrace();
        System.out.println("isTestAA() e=" + exception);
        return testVolatile == null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> longs=new ArrayList<>();
        longs.add(1);
        longs.add(2);
        longs.add(3);
        Iterator<Integer> iterator = longs.listIterator();
        while (iterator.hasNext()) {
            int id = iterator.next();
            if (id < 2) {
                iterator.remove();
            }
        }
        for(int id:longs){
            if (id < 2) {
                longs.remove(id);
            }
        }
        System.out.println(longs);
        System.out.println(TimeUnit.SECONDS.toMillis(30));
        int a = 0;
        int b = 5;
        a += 1;
        a += 1;
//        b = +1;
//        b = +1;
//        b = +1;
        b = +a;

        System.out.println("aaaa=" + a);
        System.out.println("bbb=" + b);
        TestVolatile testVolatile1 = null;
        boolean isTest = true;
        try {
            if (true) {
                try {
                    testVolatile1.clone();
                } catch (Throwable e) {
                    if (true) {
                        throw e;
                    }
                    System.out.println("111111");
                } finally {
                    System.out.println("dddddd");
                }
                System.out.println("hhh");
            }
        } catch (Throwable e) {

        }

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
