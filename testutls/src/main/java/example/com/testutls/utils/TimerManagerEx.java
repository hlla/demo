//package example.com.testutls.utils;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * Created by chengjian on 17-10-11.
// */
//
//public class TimerManagerEx {
//    private static final int CORE_POOL_SIZE = 4;
//    private final ThreadFactory mThreadFactory = new ThreadFactory() {
//        private final AtomicInteger mCount = new AtomicInteger(1);
//
//        public Thread newThread(Runnable r) {
//            return new Thread(r, "TimerThread #" + mCount.getAndIncrement());
//        }
//    };
//    private ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor;
//
//    private static class SingletonHolder {
//        private static final TimerManagerEx INSTANCE = new TimerManagerEx();
//    }
//
//    private TimerManagerEx() {
//        mScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors
//                .newScheduledThreadPool(CORE_POOL_SIZE,
//                        mThreadFactory);
//        mScheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
//    }
//
//    public static final TimerManagerEx getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    public void schedule(Runnable command, long initialDelay, long period, TimeUnit unit) {
//        mScheduledThreadPoolExecutor.scheduleAtFixedRate(command, initialDelay, period, unit);
//    }
//
//    public void cancel(Runnable command) {
//        mScheduledThreadPoolExecutor.remove(command);
//    }
////    public void purge(Runnable command) {
////        mScheduledThreadPoolExecutor.purge();
////    }
//}
