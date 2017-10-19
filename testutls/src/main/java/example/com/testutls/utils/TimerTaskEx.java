package example.com.testutls.utils;

import android.os.Handler;

/**
 * Created by chengjian on 17-10-12.
 */

public abstract class TimerTaskEx implements Runnable {
    public String name;

    public TimerTaskEx(String name) {
        this.name = name;
    }

    //    final Object lock = new Object();
    /* If timer was cancelled */
    boolean cancelled;

    /* Slots used by Timer */
    public long when;
    long delay;

    long period;

    boolean fixedRate;
    //任务是否已经预定
    boolean isScheduled;
    //执行该任务的线程
    Handler runner;
    //是否运行在主线程
    boolean isRunningInMainThread;

    boolean isScheduled() {
        return isScheduled;
    }

    void startSchedule() {
        isScheduled = true;
    }

    boolean cancel() {
        boolean willRun = !cancelled && when > 0;
        cancelled = true;
        return willRun;
    }

    public abstract void run();
}
