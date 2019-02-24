package com.example.test;

public class Singleton {
    public static int a = 10;

    static {
        System.out.println("Singleton static");
    }

    private static class SingletonHolder {
        static {
            System.out.println("SingletonHolder static");
        }

        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
