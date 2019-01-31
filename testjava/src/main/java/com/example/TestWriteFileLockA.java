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
                    File file = new File("a.lock");
                    FileOutputStream fos = new FileOutputStream(file);
                    FileChannel channel = fos.getChannel();
                    FileLock fileLock = channel.lock();
                    System.out.println("get write file lock");
                    sleep(5000);
                    fileLock.release();
                    System.out.println("end write file lock");
                } catch (Exception e) {
                    System.out.println("e=" + e);
                }
            }
        }.start();
    }
}
