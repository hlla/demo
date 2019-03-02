package com.example;

public class TestSQLiteStatement {
    static int aa = 0;
    static int bb = 0;
    static String[] str = new String[2];

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < 50000000; i++) {
                    synchronized (this) {
                        aa = i;
                        synchronized (this) {
                            bb = i + 1;
                        }
                    }
                }
                System.out.println("time1=" + (System.currentTimeMillis() - time));
                time = System.currentTimeMillis();
                for (int i = 0; i < 50000000; i++) {
                    aa = i;
                    synchronized (this) {
                        bb = i + 1;
                    }
                }
                System.out.println("time2=" + (System.currentTimeMillis() - time));
//                for (int i = 0; i < 10000000; i++) {
//                    synchronized (this) {
//                        aa = i;
//                    }
//                }
//                time = System.currentTimeMillis();
//                String value[] = new String[]{String.valueOf(0), String.valueOf(1)};
//                for (int i = 0; i < 50000000; i++) {
////                    System.arraycopy(value, 0, str, 0, value.length);
//                    str[0] = value[0];
//                    str[1] = value[1];
//                }
//                System.out.println("time3=" + (System.currentTimeMillis() - time));
//                time = System.currentTimeMillis();
//                for (int i = 0; i < 50000000; i++) {
////                    str[0] = value[0];
////                    str[1] = value[1];
//                    System.arraycopy(value, 0, str, 0, value.length);
//                }
//                System.out.println("time4=" + (System.currentTimeMillis() - time));
            }
        }.start();
    }
}
