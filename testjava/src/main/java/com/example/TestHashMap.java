package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class TestHashMap {
    static class MyTest {
        String str;
        int code;

        MyTest(String name, int code) {
            str = name;
            this.code = code;
        }

//        @Override
//        public int hashCode() {
//            return code;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            String other = ((MyTest) o).str;
//            return str.substring(0, 1).equals(other.substring(0, 1));
//        }

//        @Override
//        public String toString() {
//            return str;
//        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.println("clone()");
            return new MyTest(str, code);
        }
    }

    class MyTestSub extends MyTest {
        public MyTestSub() {
            super("a", 1);
        }
    }

    public static void main(String[] args) {
        Exception exception = new Exception("new Timer");
        exception.printStackTrace();
        System.out.println("timer test=" + exception);
        MyTest aa = null;
        MyTestSub diyThemeEffect = (MyTestSub) aa;
        System.out.println(exception.fillInStackTrace());
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
        myTests.add(new MyTest("a", 1));
        myTests.add(new MyTest("b", 1));
        myTests.add(new MyTest("c", 1));
        for (MyTest myTest : myTests) {
            System.out.println("myTest11=" + myTest);
        }
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
//        for (String str : mHostThemeCallbackList) {
//            mHostThemeCallbackList.remove("c");
//            System.out.println("str=" + str);
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
//                    String str = mHostThemeCallbackList.get(i);
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
//        for (String str : content1Array) {
//            content1List.add(str.trim());
//        }
//        for (String str : contentA2rray) {
//            content2List.add(str.trim());
//        }
//        System.out.println("content2List="+content2List.size());
//        for (String str : content1List) {
//            System.out.println("content1List str="+str);
//            content2List.remove(str);
//        }
//        System.out.println(content2List.size());
//        int i=0;
//        for (String str : content1List) {
//            if(content2List.contains(str)){
//                i++;
//                System.out.println("delete=" + str);
//            }
//        }
//        System.out.println("all total=" + i);
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
