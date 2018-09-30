package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by chengjian on 2018/5/20.
 */

public class TestLock {
    String name;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantLock mFairLock = new ReentrantLock(false);
    static Object sLock = new Object();

    @Override
    public String toString() {
        return super.toString() + " name=" + name;
    }

    //    static Object mObject = new Object();
    public void read(Thread thread) {
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

    public void write(Thread thread) {
        lock.writeLock().lock();
        try {
            System.out.println("start time:" + System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行写操作……");
            }
            System.out.println(thread.getName() + ":写操作完毕！");
            System.out.println("end time:" + System.currentTimeMillis());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<TestLock> locks = new ArrayList<>();
            synchronized (locks) {
                try {
                    locks.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            TestLock testLock = new TestLock();
            testLock.name = "cj";
            locks.add(testLock);
            System.out.println(locks);
            ArrayList<TestLock> locks1 = new ArrayList<>(locks);
//        locks1.addAll(locks);
            locks.clear();
            locks1.clear();
            testLock.name = "ljsss";
            System.out.println(locks1);
//            if (locks1.size() == 0) {
//                throw new NullPointerException();
//            }
        } finally {
            System.out.println("dgdfgfgfgg");
        }
        Comparator<Integer> comparator = new
                Comparator<Integer>() {
                    @Override
                    public int compare(Integer c1, Integer c2) {
                        return c1 - c2;
                    }
                };

        TreeMap<Integer, String> mTaskTreeMap = new TreeMap<>(comparator);
        mTaskTreeMap.put(1, "11");
        mTaskTreeMap.put(3, "33");
        mTaskTreeMap.put(2, "22");
        System.out.println(mTaskTreeMap);
        testReadWriteLock();
    }

    public static void testReadWriteLock() {
        final TestLock lock = new TestLock();
        new Thread() {
            @Override
            public void run() {
                lock.read(Thread.currentThread());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("end read");
                lock.write(Thread.currentThread());
                System.out.println("end write 2");
            }
        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                lock.read(Thread.currentThread());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
        new Thread() {
            @Override
            public void run() {
                lock.write(Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end write 1");
            }
        }.start();
    }

    public static void testFairLock() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before name=" + Thread.currentThread().getName());
                mFairLock.lock();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mFairLock.unlock();
                System.out.println("after name=" + Thread.currentThread().getName());
            }
        });
        thread.start();
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread("i" + i) {
                @Override
                public void run() {
//                lock.read(Thread.currentThread());
//                    System.out.println("before name=" + Thread.currentThread().getName() + " " +
//                            "hasQueuedThreads=" + mFairLock.hasQueuedThreads() + " count=" +
//                            mFairLock.getQueueLength());
                    System.out.println("before name=" + Thread.currentThread().getName());
                    mFairLock.lock();
                    System.out.println("after name=" + Thread.currentThread().getName());
                    synchronized (sLock) {
                        sLock.notify();
                    }
//                    try {
//                        Thread.sleep(2100);
//                        synchronized (sLock) {
//                            sLock.notify();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    mFairLock.unlock();
                }
            }.start();
        }
        while (true) {
            try {
                synchronized (sLock) {
                    sLock.wait();
                }
                for (int m = 0; m < 20; m++) {
                    new Thread("m" + m) {
                        @Override
                        public void run() {
                            mFairLock.lock();
                            System.out.println("after name=" + Thread.currentThread().getName());
                            mFairLock.unlock();
                        }
                    }.start();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
