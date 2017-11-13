package com.example;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class TestReference {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        count.addAndGet(11);
        System.out.printf("count.addAndGet(2):"+count.addAndGet(2));
        // TODO Auto-generated method stub
        YDateProxy yDateProxy = new YDateProxy();
        yDateProxy = null;
        // YDateProxy.YDate ydata = new YDateProxy().new YDate();
        // WeakReference wr = new WeakReference(ydata);
        // YDateProxy ob = new YDateProxy();
        // ob.testObj();
        // print(ydata);
        // ydata = null;
        // TestAA a = new TestAA();
        // a= null;
        System.gc();
        // ob.testObj();
        // if (wr.get() == null)
        // System.out.println("obj 已经被清除了 ");
        // else
        // System.out.println("obj 尚未被清除，其信息是 " + wr.get().toString());

    }

    static void print(YDateProxy.YDate ydata) {
        System.out.println(ydata.toString());
    }
}

class TestAA {
    public void finalize() {
        try {
            System.out.println("TestA finalize");
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

class YDateProxy {
    WeakReference wr;
    static TestAA testAAaaaa;
    YDateAA yDateAA;
    YDate aa = this.new YDate();
    YDate11 yDate11 = new YDate11();

    public void finalize() {
        try {
            System.out.println("YDateProxy finalize");
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public YDateProxy() {
        // wr = new WeakReference(new YDate());
        yDateAA = new YDateAA();
        testAAaaaa = new TestAA();
        aa = new YDate();
    }

    public void testObj() {
        if (wr.get() == null)
            System.out.println("obj 已经被清除了 ");
        else
            System.out.println("obj 尚未被清除，其信息是 " + wr.get().toString());
    }

    class YDate extends Date {
        public void finalize() {
            try {
                System.out.println("YDate finalize");
                super.finalize();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    static class YDate11 extends Date {
        public YDate11() {

        }

        public void finalize() {
            try {
                System.out.println("YDate11 finalize");
                super.finalize();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

class YDateAA extends Date {
    public void finalize() {
        try {
            System.out.println("YDateAA finalize");
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
