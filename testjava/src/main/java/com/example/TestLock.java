package com.example;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by chengjian on 2018/5/20.
 */

public class TestLock {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantLock mFairLock = new ReentrantLock(false);

    //    static Object mObject = new Object();
    public void get(Thread thread) {
        lock.readLock().lock();
        try {
            System.out.println("start time:" + System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行读操作……");
            }
            System.out.println(thread.getName() + ":读操作完毕！");
            System.out.println("end time:" + System.currentTimeMillis());
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

        final TestLock lock = new TestLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before name=" + Thread.currentThread().getName());
                mFairLock.lock();
                System.out.println("after name=" + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mFairLock.unlock();
//                lock.get(Thread.currentThread());
            }
        });
        thread.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                lock.get(Thread.currentThread());
//                mFairLock.lock();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                mFairLock.unlock();
//            }
//        }).start();
        for (int i = 0; i < 20; i++) {
            new Thread("i" + i) {
                @Override
                public void run() {
//                lock.get(Thread.currentThread());
                    System.out.println("before name=" + Thread.currentThread().getName());
                    mFairLock.lock();
                    System.out.println("after name=" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mFairLock.unlock();
                }
            }.start();
        }
        for (int m = 0; m < 20; m++) {
            new Thread("m" + m) {
                @Override
                public void run() {
//                lock.get(Thread.currentThread());
                    System.out.println("before name=" + Thread.currentThread().getName());
                    mFairLock.lock();
                    System.out.println("after name=" + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    mFairLock.unlock();
                }
            }.start();
        }
    }
}
