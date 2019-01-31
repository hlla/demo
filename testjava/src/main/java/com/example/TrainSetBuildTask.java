package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by chengjian on 18-10-8.
 */

public class TrainSetBuildTask implements Runnable {
    public static void main(String[] args) {
        String pathname = "test.arff";
        TrainSetBuildTask task1 = new TrainSetBuildTask(pathname);
        Thread t1 = new Thread(task1);
        TrainSetBuildTask task2 = new TrainSetBuildTask(pathname);
        Thread t2 = new Thread(task2);
        t1.start();
//        try {
//            t1.join();
//        } catch (Exception e) {
//
//        }
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    private String pathname;

    public TrainSetBuildTask(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public void run() {
        try {
            String content = "content\n";
            //write to encodeImpl file
            FileOutputStream os = new FileOutputStream(new File(pathname), true);
            FileChannel channel = os.getChannel();
            System.out.println("before tid=" + Thread.currentThread().getId() + " time=" + System
                    .currentTimeMillis());
            FileLock lock = channel.lock();
            lock.release();
            System.out.println("mid111 tid=" + Thread.currentThread().getId() + " time=" + System
                    .currentTimeMillis());
//            if (lock != null) {
//                ByteBuffer bytes = ByteBuffer.wrap(content.getBytes());
//                channel.write(bytes);
//                lock.release();
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.release();
//            channel.close();
//            os.close();
            System.out.println("after tid=" + Thread.currentThread().getId());
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("e=" + e);
        }
    }
}