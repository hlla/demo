package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by chengjian on 18-5-21.
 */

public class TestReadFileLockA {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("start read file lock");
                    File file = new File("a.lock");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileChannel channel = fileInputStream.getChannel();
                    FileLock fileLock = channel.lock(0, Long.MAX_VALUE, true);
                    System.out.println("get read file lock");
                    sleep(5000);
                    fileLock.release();
                    System.out.println("end read file lock");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("e=" + e);
                }
            }
        }.start();
    }
}
