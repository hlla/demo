package example.com.testutls.utils;

import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by chengjian on 17-10-21.
 */

public class ThreadEx extends Thread {
    private static final String TAG = "Utils_ThreadEx";
//    private Thread realThread = null;

//    class ProxyRunnable implements Runnable {
//        private Runnable realSubject = null;
//
//        ProxyRunnable(Runnable realSubject) {
//            this.realSubject = realSubject;
//        }
//
//        @Override
//        public void run() {
//            Log.d(TAG, "run: ProxyRunnable");
//            if (null != realSubject) {
//                realSubject.run();
//            }
//            ThreadEx.this.run();
//        }
//    }

    public ThreadEx(String threadName) {
        this(null, null, threadName, 0);
        if (TextUtils.isEmpty(threadName)) {
            throw new IllegalArgumentException("ThreadEx is empty");
        }
    }

    public ThreadEx(Runnable runnable, String threadName) {
        this(null, runnable, threadName, 0);
        if (TextUtils.isEmpty(threadName)) {
            throw new IllegalArgumentException("threadName is empty");
        }
    }

    public ThreadEx(ThreadGroup group, String threadName) {
        this(group, null, threadName, 0);
        if (TextUtils.isEmpty(threadName)) {
            throw new IllegalArgumentException("threadName is empty");
        }
    }

    public ThreadEx(ThreadGroup group, Runnable runnable, String threadName) {
        this(group, runnable, threadName, 0);
        if (TextUtils.isEmpty(threadName)) {
            throw new IllegalArgumentException("threadName is empty");
        }
    }


    public ThreadEx(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        super(group, runnable, threadName, stackSize);
//        realThread = new Thread(group, runnable, threadName, stackSize)
//        ProxyRunnable target;
//        if (null == runnable) {
//            target = new ProxyRunnable(null);
//        } else {
//            target = new ProxyRunnable(runnable);
//        }
//        setTarget(target);
        if (TextUtils.isEmpty(threadName)) {
            throw new IllegalArgumentException("threadName is empty");
        }
    }

//    private void setTarget(Runnable target) {
//        try {
//            Field field = Thread.class.getDeclaredField("target");
//            boolean isAccessible = field.isAccessible();
//            field.setAccessible(true);
//            field.set(this, target);
//            field.setAccessible(isAccessible);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "setTarget: e=" + e);
//        }
//
//    }

    @Override
    @CallSuper
    public void run() {
        Log.d(TAG, "run: ");
        super.run();
    }
}
