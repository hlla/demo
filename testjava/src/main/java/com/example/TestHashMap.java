package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class TestHashMap {
    /**
     * Magic number for current version of cache file format.
     */
    private static final int CACHE_MAGIC = 0x20150306;
    private static final int CACHE_MAGIC2 = 0x20160615;

    static class MyTest {
        TestHashMap testHashMap = new TestHashMap();
        String name;
        int code;
        boolean isDock;

        String getName() {
            return name;
        }

        MyTest(String name, int code, boolean isDock) {
            this.name = name;
            this.code = code;
            this.isDock = isDock;
        }

//        @Override
//        public int hashCode() {
//            return code;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            String other = ((MyTest) o).name;
//            return name.substring(0, 1).equals(other.substring(0, 1));
//        }

        //        @Override
//        public String toString() {
//            return name;
//        }
        @Override
        public String toString() {
            return "MyTest name=" + getName() + " testHashMap=" + testHashMap;
        }

//        @Override
//        public String toString() {
//
//            return "name=" + name + " code=" + code;
//        }

//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            System.out.println("clone()");
//            return new MyTest(name, code);
//        }
    }

    class MyTestSub extends MyTest {
        String name = "aaaaaaa";
        TestHashMap testHashMap = null;

        public MyTestSub() {
            super("a", 1, true);
            name = "cccc";
        }

        String getName() {
            return name;
        }
//        @Override
//        public String toString() {
//            return "MyTestSubMyTestSubMyTestSub";
//        }
    }

    public static byte[] writeInt(int n) {
        final byte[] tmp = new byte[8];
        int offset = 0;
        tmp[offset++] = (byte) ((n) & 0xff);
        tmp[offset++] = (byte) ((n >> 8) & 0xff);
        tmp[offset++] = (byte) ((n >> 16) & 0xff);
        tmp[offset] = (byte) ((n >> 24) & 0xff);
        return tmp;
    }

    public static int readInt(byte[] tmp) {
        int offset = 0;
        return ((tmp[offset++] & 0xff)) |
                ((tmp[offset++] & 0xff) << 8) |
                ((tmp[offset++] & 0xff) << 16) |
                ((tmp[offset] & 0xff) << 24);
    }

    public static String getStackTraceInfo(final Throwable throwable) {
        String trace = "";
        try {
            Writer writer = new StringWriter();
            PrintWriter pw = new PrintWriter(writer);
            throwable.printStackTrace(pw);
            trace = writer.toString();
            pw.close();
        } catch (Exception e) {
            return "";
        }
        return trace;
    }

    private static void testCrash() {
//        RuntimeException exception1 = new RuntimeException("ssssss");
//        throw exception1;
        try {
            RuntimeException exception1 = new RuntimeException("ssssss");
            throw exception1;
//            testCrash();
        } catch (Exception exception1) {
//            StackTraceElement[] stackTraceElements = null;
//            for (StackTraceElement stackTraceElement : stackTraceElements) {
//                System.out.println("stackTraceElement=" + stackTraceElement);
//            }

            System.out.println("exception1=" + getStackTraceInfo(exception1));
//            exception1.fillInStackTrace();
//            exception1.printStackTrace();
//            System.out.println(exception1);
        }
    }

    public static void main(String[] args) {
        MyTestSub myTest1 = new TestHashMap().new MyTestSub();
        System.out.println("myTest1=" + myTest1);
        testCrash();
        MyTest myTest11 = new MyTest("a", 1, false);
        MyTest myTest2 = new MyTest("b", 2, false);
        MyTest myTest3 = new MyTest("c", 3, true);
        MyTest myTest4 = new MyTest("d", 4, false);
        MyTest myTest5 = new MyTest("e", 5, true);
        MyTest myTest6 = new MyTest("e", 1, true);
        MyTest myTest7 = new MyTest("e", 7, true);
        ArrayList<MyTest> testArrayList = new ArrayList<>();
        testArrayList.add(myTest11);
        testArrayList.add(myTest2);
        testArrayList.add(myTest3);
        testArrayList.add(myTest4);
        testArrayList.add(myTest5);
        testArrayList.add(myTest6);
        testArrayList.add(myTest7);
        Collections.sort(testArrayList, new Comparator<MyTest>() {
            @Override
            public int compare(MyTest o1, MyTest o2) {
                System.out.println("timer o1=" + o1 + " o2=" + o2);
                if (o1.isDock == o2.isDock && o2.isDock) {
                    if (o2.code >= o1.code) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }
        });
        System.out.println("timer testArrayList=" + testArrayList);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("0");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("timer o1=" + o1 + " o2=" + o2);
                return -1;
            }
        });
//        byte[] tmp = writeInt(CACHE_MAGIC2);
        System.out.println("timer strings=" + strings);
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.println("main i=" + i);
            inner:
            for (int m = 0; m < 3; m++) {
                System.out.println("main m=" + m);
                if (m == 1) {
                    continue outer;
                }
            }
            System.out.println("main iii=" + i);
        }
        MyTest myTestaaaa = new MyTest("cj", 100, true);
        ArrayList<MyTest> myTestsa = new ArrayList<>();
        myTestsa.add(myTestaaaa);
        ArrayList<MyTest> myTestsb = new ArrayList<>();
        myTestsb.addAll(myTestsa);
        myTestsa.clear();
        myTestaaaa.name = "aaa";
        System.out.println("myTests=" + myTestsa + " myTests1=" + myTestsb);

        ArrayList<String> strings11 = new ArrayList<>();
        strings11.add("1");
        strings11.add("2");
        strings11.add("3");
        Collections.sort(strings11, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("timer o1=" + o1 + " o2=" + o2);
                return o1.compareTo(o2);
            }
        });
//        byte[] tmp = writeInt(CACHE_MAGIC2);
        System.out.println("timer strings=" + strings);
//        Exception exception = new Exception("new Timer");
//        exception.printStackTrace();

        MyTest aa = null;
        MyTestSub diyThemeEffect = (MyTestSub) aa;
//        System.out.println(exception.fillInStackTrace());
        int x = -5 >> 1;
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        Random mRandObj = new Random(1);
        System.out.println(mRandObj.nextDouble());
//        mRandObj = new Random(System.currentTimeMillis());
        System.out.println(mRandObj.nextDouble());
//        mRandObj = new Random(System.currentTimeMillis());
        System.out.println(mRandObj.nextDouble());
//        mRandObj = new Random(System.currentTimeMillis());
        System.out.println(mRandObj.nextDouble());
        String cmdline1 = "sss comtest:ddd";
        int index = cmdline1.indexOf("comtest");
        System.out.println(cmdline1.substring(cmdline1.length()));
        System.out.println(cmdline1.substring(cmdline1.length()).length());
        ArrayList<MyTest> myTests = new ArrayList<>();
//        myTests.add(new MyTest("a", 1));
//        myTests.add(new MyTest("b", 1));
//        myTests.add(new MyTest("c", 1));
//        for (MyTest myTest : myTests) {
//            System.out.println("myTest11=" + myTest);
//        }
        ArrayList<MyTest> myTests11 = (ArrayList) myTests.clone();
        myTests11.remove(myTests.get(0));
        for (MyTest myTest : myTests11) {
            System.out.println("myTest22=" + myTest);
        }
        final List<String> mHostThemeCallbackList = Collections.synchronizedList(new
                ArrayList<String>());
        mHostThemeCallbackList.add("a");
//        mHostThemeCallbackList.add("b");
//        mHostThemeCallbackList.add("c");
        String dd = null;
//        for (String name : mHostThemeCallbackList) {
//            mHostThemeCallbackList.remove("c");
//            System.out.println("name=" + name);
//        }
        int offset = "ancde:".indexOf(':');
//        if (offset == -1)
//            return false;
        System.out.println("offset=" + offset);
        String cmdline = "ancde:".substring(offset + 1);
        System.out.println("cmdline=" + cmdline);
//        final List<String> mHostThemeCallbackList = Collections.synchronizedList(new
//                ArrayList<String>());
        final ReentrantLock mSurfaceLock = new ReentrantLock();
        new Thread() {
            @Override
            public void run() {
                if (mHostThemeCallbackList.size() > 0) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHostThemeCallbackList.remove(0);
                }
//                mSurfaceLock.lock();
//                mSurfaceLock.lock();
//                mSurfaceLock.lock();
//                System.out.println("111111");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                mSurfaceLock.unlock();
//                System.out.println("111111  =" + mSurfaceLock.getHoldCount());
//                mSurfaceLock.unlock();
//                System.out.println("111111  =" + mSurfaceLock.getHoldCount());
//                mSurfaceLock.unlock();
//                System.out.println("111111  =" + mSurfaceLock.getHoldCount());
//                mHostThemeCallbackList.add("a");
//                mHostThemeCallbackList.add("b");
//                mHostThemeCallbackList.add("c");
//                String dd = null;
//                for (int i = 0; i < mHostThemeCallbackList.size(); i++) {
//                    String name = mHostThemeCallbackList.get(i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                mHostThemeCallbackList.remove(0);
//                mSurfaceLock.lock();
//                System.out.println("22222");
//                mHostThemeCallbackList.add("c");
//                mHostThemeCallbackList.add("e");
//                mHostThemeCallbackList.add("f");
            }
        }.start();
//        String a = new String("abcd");
//        String b = new String("abcd");
//
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(a.equals(b));
//        HashMap<MyTest, String> hashMap = new HashMap<>();
//        hashMap.put(new MyTest("ab", 1), "fff");
//        hashMap.put(new MyTest("ad", 1), "hhh");
//        hashMap.put(new MyTest("cd", 1), "vv");
//        hashMap.put(new MyTest("fe", 1), "eee");
//        System.out.println("hashMap =" + hashMap);
//        for (MyTest myTest : hashMap.keySet()) {
//            System.out.println("myTest=" + myTest);
//        }
//        int[] intArray = {1, 2, 3, 4};
//        System.out.println(hashMap.size());
//        String content1 = readString("1.txt");
//        String content2 = readString("2.txt");
//        String[] content1Array = content1.split("\n");
//        String[] contentA2rray = content2.split("\n");
//        ArrayList<String> content1List = new ArrayList<>();
//        ArrayList<String> content2List = new ArrayList<>();
//        for (String name : content1Array) {
//            content1List.add(name.trim());
//        }
//        for (String name : contentA2rray) {
//            content2List.add(name.trim());
//        }
//        System.out.println("content2List="+content2List.size());
//        for (String name : content1List) {
//            System.out.println("content1List name="+name);
//            content2List.remove(name);
//        }
//        System.out.println(content2List.size());
//        int i=0;
//        for (String name : content1List) {
//            if(content2List.contains(name)){
//                i++;
//                System.out.println("delete=" + name);
//            }
//        }
//        System.out.println("all total=" + i);
        RuntimeException exception1 = new RuntimeException("ssssss");
        throw exception1;
    }

    private static String readString(String filePath) {
        String str = "";
        File file = new File(filePath);
        try {
            FileInputStream in = new FileInputStream(file);
            // size  为字串的长度 ，这里一次性读完
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            str = new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Auto-generated catch block
            return null;
        }
        return str;
    }
}
