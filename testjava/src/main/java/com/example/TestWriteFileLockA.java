package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;

/**
 * Created by chengjian on 18-5-21.
 */

public class TestWriteFileLockA {
    private void doDeleteShortcut(final List<String> deleteShortcutList) {
        if (deleteShortcutList.size() == 0) {
            return;
        }
        new Thread() {
            @Override
            public void run() {
                for (String folderInfo : deleteShortcutList) {
                    System.out.println("folderInfo=" + folderInfo);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("start write file lock");
                    File file = new File("bdd.lock");
                    FileOutputStream fos = new FileOutputStream(file);
                    System.out.println("get write file lock 0 =" + file.exists());
                    FileChannel channel = fos.getChannel();
                    System.out.println("get write file lock 1 =" + file.exists());
                    FileLock fileLock = channel.lock();
                    System.out.println("get write file lock 2 =" + file.exists());
                    sleep(5000);
                    fileLock.release();
                    sleep(1000);
//                    System.out.println("end write file lock");
                    System.out.println("get write file lock 3 =" + file.exists());
                } catch (Exception e) {
                    System.out.println("e=" + e);
                }
            }
        }.start();
    }
}
