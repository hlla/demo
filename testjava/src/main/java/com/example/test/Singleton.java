package com.example.test;

public class Singleton {
    public static int a = 10;
    public static SingletonHolder b;

    static {
        Exception exception = new Exception("outer class static");
        exception.printStackTrace();
        sun.misc.Launcher dd;
        System.out.println("Singleton static loader=" + Singleton.class.getClassLoader() + " " +
                "String.class=" + String.class.getClassLoader() + " aa=" + Singleton.class
                .getClassLoader().getParent());
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
