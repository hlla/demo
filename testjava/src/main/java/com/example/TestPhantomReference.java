package com.example;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class TestPhantomReference {
    public static boolean isRun = true;

    static class AA {

    }

    private static class MyWeakReference<T> extends WeakReference<T> {
        public MyWeakReference(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
            System.out.println("MyWeakReference（） " + " time=" + System
                    .currentTimeMillis() / 1000);
        }

        @Override
        public T get() {
            System.out.println("MyWeakReference get（） " + " time=" + System
                    .currentTimeMillis() / 1000);
            return super.get();
        }

        @Override
        public boolean enqueue() {
            System.out.println("MyWeakReference enqueue " + " time=" + System
                    .currentTimeMillis() / 1000);
            return super.enqueue();
        }

        @Override
        public void clear() {
            super.clear();
            System.out.println("MyWeakReference clear " + " time=" + System
                    .currentTimeMillis() / 1000);
        }
// @Override
        // protected void finalize() throws Throwable {
        // // TODO Auto-generated method stub
        // // super.finalize();
        // System.out.println("A finalize");
        // }
    }

    static class MyPhantomReference<T> extends PhantomReference<T> {
        public MyPhantomReference(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
        }

        @Override
        public T get() {
            System.out.println("MyPhantomReference get（） " + " time=" + System
                    .currentTimeMillis() / 1000);
            return super.get();
        }

        @Override
        public boolean enqueue() {
            System.out.println("MyPhantomReference enqueue " + " time=" + System
                    .currentTimeMillis() / 1000);
            return super.enqueue();
        }

        @Override
        public void clear() {
            super.clear();
            System.out.println("PhantomReference clear " + " time=" + System
                    .currentTimeMillis() / 1000);
        }
// @Override
        // protected void finalize() throws Throwable {
        // // TODO Auto-generated method stub
        // // super.finalize();
        // System.out.println("A finalize");
        // }
    }

    public static void main(String[] args) {
        // String abc = new String("abc");
        AA abc = new AA();
        System.out.println("abc=" + abc + " time=" + System
                .currentTimeMillis() / 1000);
        final ReferenceQueue<AA> referenceQueue = new ReferenceQueue<AA>();
        final MyPhantomReference<AA> abcWeakRef = new MyPhantomReference<AA>(abc,
                referenceQueue);
//        final MyWeakReference<AA> abcWeakRef = new MyWeakReference<AA>(abc,
//                referenceQueue);
        new Thread() {
            public void run() {
                while (isRun) {
                    Object o = referenceQueue.poll();
                    if (o != null) {
                        System.out.println(o + " time=" + System
                                .currentTimeMillis() / 1000);
                        System.out.println("gc0 will collect:"
                                + abcWeakRef.get());
                        try {
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(o);
                            System.out.println("gc will collect:"
                                    + result + " time=" + System
                                    .currentTimeMillis() / 1000);
                            try {
                                Thread.currentThread().sleep(3000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            result = rereferent.get(o);
                            System.out.println("gc111 will collect:"
                                    + result);
                            Object o1 = referenceQueue.poll();
                            System.out.println("gc11=" + o1 + " time=" + System
                                    .currentTimeMillis() / 1000);
                            if (o1 != null) {
                                Field rereferent1 = Reference.class
                                        .getDeclaredField("referent");
                                rereferent.setAccessible(true);
                                Object result1 = rereferent.get(o1);
                                System.out.println("gc11 will collect:"
                                        + result1 + " time=" + System
                                        .currentTimeMillis() / 1000);
                            }
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        abc = null;
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.gc();
        System.out.println("after gc abcWeakRef=" + abcWeakRef + " time=" + System
                .currentTimeMillis() / 1000);
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        isRun = false;
    }
}
