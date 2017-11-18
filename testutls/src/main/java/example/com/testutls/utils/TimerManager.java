package example.com.testutls.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by chengjian on 17-10-11.
 */

/**
 * 倒计时管理类,将全局的倒计时任务统一管理起来
 * 优点如下
 * 1. 使用线程池原理,当空闲线程时timeout,自动结束线程
 * 2.使用Handle实现倒计时的计算,避免使用wait(long millis),导致线程无用的等待
 */
public class TimerManager {
    private static final String TAG = "TimerManager";
    //    private static final int COUNT_BITS = Integer.SIZE - 3;
//    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
//    //当线程池中没有空闲线程时,尽可能开启线程执行任务,而不是放在任务队列里面,避免阻塞,50个核心线程应该足够啦
//    private static final int CORE_POOL_SIZE = 50;
//    private static final int THREAD_SIZE = 50;
//    private static final int MAXIMUM_POOL_SIZE = CAPACITY;
//    private static final int KEEP_ALIVE = 10;
    private static final int MAX_THREAD_NUM = 100;
    private static final int MSG_TIMING = 1;
    private static final int MSG_IDLE_THREAD_TIME_OUT = 2;
    private static final int MSG_EXECUTE_TASK = 3;
    private static final long IDLE_THREAD_KEEP_ALIVE_TIME = 60 * 1000;
    private final Object mlock = new Object();
    //任务线程,可能以后会限制线程的个数
    private List<Handler> mTasKHandlers = new LinkedList<>();
    //空置的任务线程
    private LinkedList<Handler> mIdleHandlers = new LinkedList<>();
    private volatile WTTimerHandler mTimerHandler;
    private volatile UITimerHandler mUIHandler;
    private final AtomicInteger mCount = new AtomicInteger(1);

    /**
     * 主线程定时器
     */
    private class UITimerHandler extends Handler {
        UITimerHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case MSG_TIMING: {
                    TimerTaskEx timerTask = (TimerTaskEx) msg.obj;
                    if (null != timerTask) {
                        synchronized (mlock) {
                            if (timerTask.cancelled) {
                                mUIHandler.removeMessages(MSG_TIMING, timerTask);
                                return;
                            }
                        }
                        Message message = Message.obtain();
                        if (timerTask.period > 0) {
                            timerTask.when = SystemClock.uptimeMillis() + timerTask.period;
                            message.obj = timerTask;
                            message.what = MSG_TIMING;
                            Log.d(TAG, "UITimerHandler : what=" + what + " tid=" + Thread
                                    .currentThread().getId() + " this=" + this + " timerTask=" +
                                    timerTask + " when=" + timerTask.when + " now=" + SystemClock
                                    .uptimeMillis());
                            mUIHandler.sendMessageAtTime(message, timerTask.when);
                        }
                        //因为是UI线程,不需要catch,如果有异常,直接crash
                        timerTask.run();
                    }
                    break;
                }
                default: {
                    break;
                }
            }

        }
    }

    /**
     * 工作线程程定时器
     */
    private class WTTimerHandler extends Handler {
        WTTimerHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;

            Log.d(TAG, "WTTimerHandler : what=" + what + " tid=" + Thread.currentThread()
                    .getId
                            ());
            switch (what) {
                case MSG_TIMING: {
                    TimerTaskEx timerTask = (TimerTaskEx) msg.obj;
//                    timerTask.isInQueue = true;
                    if (null != timerTask) {
                        synchronized (mlock) {
                            if (timerTask.cancelled) {
                                return;
                            }
                            Handler taskHandler = timerTask.runner;
                            Log.d(TAG, "WTTimerHandler : taskHandler=" + taskHandler + " " +
                                    " " +
                                    "timerTask" +
                                    ".period=" + timerTask.period + " timerTask=" + timerTask);
                            if (null == taskHandler) {
                                taskHandler = getIdleHandler();
                            }
                            timerTask.runner = taskHandler;
                            Message taskMsg = Message.obtain();
                            taskMsg.obj = timerTask;
                            taskMsg.what = MSG_EXECUTE_TASK;
                            //将任务分发到空置线程或者正在执行该任务的线程
                            taskHandler.sendMessage(taskMsg);
                        }
                    }
                    break;
                }
                case MSG_IDLE_THREAD_TIME_OUT: {
                    TaskHandler taskHandler = (TaskHandler) msg.obj;
                    Log.d(TAG, "WTTimerHandler timeout: taskHandler=" + taskHandler);
                    synchronized (mlock) {
                        Looper looper = taskHandler.getLooper();
                        if (null != looper) {
                            looper.quit();
                        }

                        mIdleHandlers.remove(taskHandler);
                        mTasKHandlers.remove(taskHandler);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private class TaskHandler extends Handler {
        TaskHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            TimerTaskEx timerTask = null;
            if (msg.obj instanceof TimerTaskEx) {
                timerTask = (TimerTaskEx) msg.obj;
            }
            Log.d(TAG, "TaskHandler : what=" + what + " tid=" + Thread.currentThread()
                    .getId() +
                    " this=" + this + " timerTask=" + timerTask);
            switch (what) {
                case MSG_EXECUTE_TASK: {
                    synchronized (mlock) {
                        if (null != timerTask) {
                            if (timerTask.cancelled) {
                                timerTask.runner = null;
                                return;
                            }
                        }
                        //从空置的线程list删除当前正在执行任务的线程
                        mIdleHandlers.remove(TaskHandler.this);
                        //当前线程正在执行任务,所以取消当前线程空置超时
                        mTimerHandler.removeMessages(MSG_IDLE_THREAD_TIME_OUT, TaskHandler
                                .this);
                    }
                    if (null != timerTask) {
                        Message message = Message.obtain();
                        if (timerTask.period > 0) {
                            if (timerTask.fixedRate) {
                                //固定速率固定时间点执行
                                timerTask.when += timerTask.period;
                            } else {
                                //非固定速率的下一个任务的开始时间是从当前任务开始执行的时间点+period
                                timerTask.when = SystemClock.uptimeMillis() + timerTask.period;
                            }
                            message.obj = timerTask;
                            message.what = MSG_TIMING;
                            Log.d(TAG, "TaskHandler : what=" + what + " tid=" + Thread
                                    .currentThread().getId() + " this=" + this + " timerTask=" +
                                    timerTask + " when=" + timerTask.when + " now=" +
                                    SystemClock
                                            .uptimeMillis());
                            mTimerHandler.sendMessageAtTime(message, timerTask.when);
                        }
                        try {
                            timerTask.run();
                        } catch (Throwable ex) {
                            //加异常处理,不会因为一个任务的异常导致整个timer终止
                            synchronized (mlock) {
                                mTimerHandler.removeMessages(MSG_TIMING, timerTask);
                                Looper looper = TaskHandler.this.getLooper();
                                if (null != looper) {
                                    looper.quit();
                                }
                            }
                        }
                        synchronized (mlock) {
                            boolean isTimeTaskInQueue = TaskHandler.this.hasMessages
                                    (MSG_EXECUTE_TASK, timerTask);
                            Log.d(TAG, "TaskHandler :timerTask.isTaskInQueue=" +
                                    isTimeTaskInQueue +
                                    " fixedRate=" + timerTask.fixedRate + "  timerTask" +
                                    ".period=" +
                                    timerTask.period + " timerTask=" + timerTask + " " +
                                    "iscancel=" +
                                    timerTask.cancelled);
                            //不重复执行的任务,执行完毕终止线程
                            if (timerTask.period <= 0) {
                                Looper looper = TaskHandler.this.getLooper();
                                if (null != looper) {
                                    looper.quit();
                                }
                                mIdleHandlers.remove(TaskHandler.this);
                                mTasKHandlers.remove(TaskHandler.this);
                                timerTask.runner = null;
                                return;
                            }
                            if (!isTimeTaskInQueue) {
                                timerTask.runner = null;
                                //如果任务没有被取消,那么将该线程设置为idle以便重用,如果任务被取消,直接终止该线程,不得重用
                                if (!timerTask.cancelled) {
                                    queueIdle(TaskHandler.this);
                                }
                            }
                        }
                    }
                    break;
                }
                default: {
                    break;
                }
            }


        }
    }

    private void queueIdle(TaskHandler handler) {
        Log.d(TAG, "queueIdle: tid=" + Thread.currentThread().getId());
        mIdleHandlers.add(0, handler);
        Message message = Message.obtain();
        message.obj = handler;
        message.what = MSG_IDLE_THREAD_TIME_OUT;
        Log.d(TAG, "queueIdle: handler=" + handler);
        mTimerHandler.sendMessageDelayed(message, IDLE_THREAD_KEEP_ALIVE_TIME);
    }

    private static class SingletonHolder {
        private static final TimerManager INSTANCE = new TimerManager();
    }

    private TimerManager() {
        HandlerThread handlerThread = new HandlerThread("Launcher_Timer_Dispatch_Thread");
        handlerThread.start();
        mTimerHandler = new WTTimerHandler(handlerThread.getLooper());
        mUIHandler = new UITimerHandler(Looper.getMainLooper());
    }

    public static final TimerManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取空置的Handler
     *
     * @return
     */
    public Handler getIdleHandler() {
        synchronized (mlock) {
            if (mIdleHandlers.size() > 0) {
                return mIdleHandlers.remove(0);
            }
        }
        //线程名字序号不要超过MAX_THREAD_NUM
        if (mCount.get() >= MAX_THREAD_NUM) {
            mCount.set(1);
        }
        StringBuffer buffer = new StringBuffer("Launcher_TimerTask_Thread #");
        buffer.append(mCount.getAndIncrement());
        HandlerThread thread = new HandlerThread(buffer.toString());
        thread.start();
        final TaskHandler handler = new TaskHandler(thread.getLooper());
        synchronized (mlock) {
            if (mTasKHandlers.size() >= MAX_THREAD_NUM) {
                throw new RuntimeException("timer thread has exceed max num:" + MAX_THREAD_NUM);
            } else {
                mTasKHandlers.add(handler);
            }
        }
        return handler;
    }

    /**
     * Schedule a task for single execution after a specified delay.
     *
     * @param task
     * @param delay
     */
    public void schedule(TimerTaskEx task, long delay) {
        if (delay < 0) {
            throw new IllegalArgumentException("delay < 0: " + delay);
        }
        schedule(task, delay, false);
    }

    /**
     * Schedule a task for single execution after a specified delay.
     *
     * @param task
     * @param delay
     * @param isTaskInMainThread 是否task需要运行在主线程
     */
    public void schedule(TimerTaskEx task, long delay, boolean
            isTaskInMainThread) {
        if (delay < 0) {
            throw new IllegalArgumentException("delay < 0: " + delay);
        }
        scheduleImpl(task, delay, -1, false, isTaskInMainThread);
    }

    /**
     * Schedule a task for repeated fixed-delay execution after a specific time
     * has been reached.
     *
     * @param task
     * @param delay
     * @param period
     */
    public void schedule(TimerTaskEx task, long delay, long period) {
        if (delay < 0 || period <= 0) {
            throw new IllegalArgumentException();
        }
        schedule(task, delay, period, false);
    }

    /**
     * Schedule a task for repeated fixed-delay execution after a specific time
     * has been reached.
     *
     * @param task
     * @param delay
     * @param period
     * @param isTaskInMainThread 是否task需要运行在主线程
     */
    public void schedule(TimerTaskEx task, long delay, long period, boolean
            isTaskInMainThread) {
        if (delay < 0 || period <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(task, delay, period, false, isTaskInMainThread);
    }

    /**
     * Schedule a task for repeated fixed-rate execution after a specific delay
     * has passed.
     *
     * @param task
     * @param delay
     * @param period
     */
    public void scheduleAtFixedRate(TimerTaskEx task, long delay, long period) {
        if (delay < 0 || period <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(task, delay, period, true, false);
    }

    /*
      * Schedule a task.
      */
    private boolean scheduleImpl(TimerTaskEx task, long delay, long period, boolean fixed, boolean
            isTaskInMainThread) {

        long when = delay + SystemClock.uptimeMillis();

        if (when < 0) {
            throw new IllegalArgumentException("Illegal delay to start the TimerTaskEx: " +
                    when);
        }

        synchronized (mlock) {
            if (task.isScheduled()) {
                if (true) {
                    throw new IllegalStateException("TimerTaskEx is scheduled already");
                } else {
                    Log.e(TAG, "scheduleImpl: TimerTaskEx is scheduled already");
                    return false;
                }
            }

            if (task.cancelled) {
                if (true) {
                    throw new IllegalStateException("TimerTaskEx is canceled");
                } else {
                    Log.e(TAG, "scheduleImpl: TimerTaskEx is canceled");
                    return false;
                }
            }
            task.when = when;
            task.delay = delay;
            task.period = period;
            task.fixedRate = fixed;
            task.startSchedule();
            if (isTaskInMainThread) {
                task.isRunningInMainThread = true;
            }
        }
        Message message = Message.obtain();
        message.obj = task;
        message.what = MSG_TIMING;
        if (isTaskInMainThread) {
            mUIHandler.sendMessageDelayed(message, delay);
        } else {
            mTimerHandler.sendMessageDelayed(message, delay);
        }
        return true;
    }

    public void cancel(TimerTaskEx timerTask) {
        if (null != timerTask) {
            synchronized (mlock) {
                boolean cancel = timerTask.cancel();
                if (cancel) {
                    //如果是主线程执行task,那么直接remove消息即可
                    if (timerTask.isRunningInMainThread) {
                        mUIHandler.removeMessages(MSG_TIMING, timerTask);
                        return;
                    }
                    //如果是工作线程执行task,那么就要终止该线程,避免无用占坑
                    //获取正在执行timerTask的线程
                    Handler willTerminateHandler = timerTask.runner;
                    //终止跟这个任务相关的线程
                    if (null != willTerminateHandler) {
                        Looper looper = willTerminateHandler.getLooper();
                        if (null != looper) {
                            looper.quit();
                        }
                        mIdleHandlers.remove(willTerminateHandler);
                        mTasKHandlers.remove(willTerminateHandler);
                    }
                }
            }
        }
    }
}
