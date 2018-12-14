package com.example;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by chengjian on 17-9-26.
 */

public class TestInterrupted {
    /**
     * The cache triage queue.
     */
    private static final PriorityBlockingQueue<String> mCacheQueue =
            new PriorityBlockingQueue<String>();

    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Take encodeImpl request from the queue.
                    System.out.println("hahhhhahh is=" + Thread.currentThread().isInterrupted());
                    Thread.currentThread().sleep(3000);
                    System.out.println("gggg ");
                } catch (InterruptedException e) {
                    // We may have been interrupted because it was time to quit.
                    e.printStackTrace();
                    System.out.println("e=" + e + "  isInterrupted= " + Thread.currentThread()
                            .isInterrupted());
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
