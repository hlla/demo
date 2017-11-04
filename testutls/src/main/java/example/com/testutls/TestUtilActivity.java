package example.com.testutls;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.testutls.utils.AsyncTaskEx;
import example.com.testutls.utils.TimerManager;
import example.com.testutls.utils.TimerTaskEx;

public class TestUtilActivity extends Activity /*implements View.OnClickListener */ {
    private static final String TAG = "TestUtilsActivity";
    @BindView(R.id.test_asynctask)
    Button testAsynctask;
    @BindView(R.id.test_wt_schedule_timer)
    Button testWtScheduleTimer;
    @BindView(R.id.test_ui_timer)
    Button testUiTimer;
    @BindView(R.id.test_schedule_fix_timer)
    Button testScheduleFixTimer;
    @BindView(R.id.cancel_wt_schedule_fix_timer)
    Button cancelWtScheduleFixTimer;
    @BindView(R.id.cancel_wt_schedule_timer)
    Button cancelWtScheduleTimer;
    @BindView(R.id.cancel_ui_timer)
    Button cancelUiTimer;
    private ArrayList<MyRunnable> myRunnables = new ArrayList<>();
    private ArrayList<TimerTaskEx> wtScheduletimerTaskices = new ArrayList<>();
    private List<TimerTaskEx> uiScheduletimerTaskices = Collections.synchronizedList(new
            ArrayList<TimerTaskEx>());
    private List<TimerTaskEx> wtScheduleFixtimerTaskices = Collections.synchronizedList(new
            ArrayList<TimerTaskEx>());
    private List<ScheduledFuture> scheduledFutures = Collections.synchronizedList(new
            ArrayList<ScheduledFuture>());
    private int i = 0;
    private final AtomicInteger mWTScheduleCount = new AtomicInteger(0);
    private final AtomicInteger mUIScheduleCount = new AtomicInteger(0);
    private final AtomicInteger mWTScheduleFixCount = new AtomicInteger(0);
    private final AtomicInteger mCount1 = new AtomicInteger(1);
    private ScheduledThreadPoolExecutor mScheduledExecutorService;
    private RelativeLayout mTestRelativeLayout;

    @OnClick(R.id.test_asynctask)
    public void onTestAsynctaskClicked() {
        Log.d(TAG, "onTestAsynctaskClicked");
        for (int i = 0; i < 50; i++) {
            MyAsyncTaskEx asyncTaskEx = new MyAsyncTaskEx();
            asyncTaskEx.executeOnExecutor(AsyncTaskEx.THREAD_POOL_EXECUTOR, "" + i);
        }
    }

    @OnClick(R.id.test_wt_schedule_timer)
    public void onTestWtScheduleTimerClicked() {
//        Log.d(TAG, "onTestWtScheduleTimerClicked");
//        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd
// HH:mm:ss");
//                Date startDate = new Date(System.currentTimeMillis() - 5000);
        Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        i++;
//                        Log.d(TAG, "schedule tid=" + Thread.currentThread().getId());
//                        try {
//                            if (i == 4) {
//                                Thread.sleep(5000);
//                            } else {
//                                Thread.sleep(1000);
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, startDate, 3000);
        final TimerTaskEx timerTaskEx = new TimerTaskEx(mWTScheduleCount.getAndIncrement() + "") {
            @Override
            public void run() {
                i++;
                int time = 0;
                Random rd = new Random();
                time = rd.nextInt(8) * 1000 + 1000;
                Log.d(TAG, "run work thread  ScheduleTimer tid =" + Thread.currentThread().getId
                        () +
                        " size=" + wtScheduletimerTaskices.size() + "  this.name=" + this.name +
                        " " +
                        "time=" + time + " this=" + this);
                try {
                    Thread.sleep(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Random rd = new Random();
//        final int period = rd.nextInt(30) * 1000 + 15000;
        final int period = 30 * 1000;
        Random rdnum = new Random();
        final int num = rdnum.nextInt(10);
        wtScheduletimerTaskices.add(timerTaskEx);
        if (num % 2 == 0) {
            Log.d(TAG, "main thread onlick ScheduleTimer period=" + period + " name=" +
                    timerTaskEx.name);
            TimerManager.getInstance().schedule(timerTaskEx, 1000, period);
        } else {
            new Thread() {
                @Override
                public void run() {
                    Log.d(TAG, "workThread onlick ScheduleTimer period=" + period + " name=" +
                            timerTaskEx.name);
                    TimerManager.getInstance().schedule(timerTaskEx, 1000, period);
                }
            }.start();
        }
//        TimerTaskEx timerTaskEx = new TimerTaskEx(mWTScheduleCount.getAndIncrement() + "") {
//            @Override
//            public void run() {
//                long taskCount = mScheduledExecutorService.getTaskCount();
//                int queueSize = mScheduledExecutorService.getQueue().size();
//                Log.d(TAG, "scheduleWithFixedDelay tid =" + Thread.currentThread().getId()
//                        + " size=" + timerTaskices.size() + "  this.name=" + this.name +
//                        " " +
//                        "i=" + i + " taskCount=" + taskCount + "  queueSize=" + queueSize);
//                int time = 1000;
////                        this.isScheduled = true;
//                try {
//                    Thread.sleep(time);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        ScheduledFuture scheduledFuture = mScheduledExecutorService
//                .scheduleWithFixedDelay(timerTaskEx, 1, 7, TimeUnit.SECONDS);
//        scheduledFutures.add(scheduledFuture);
    }


    @OnClick(R.id.test_schedule_fix_timer)
    public void onTestScheduleFixTimerClicked() {
        final TimerTaskEx timerTaskEx = new TimerTaskEx(mWTScheduleFixCount.getAndIncrement() +
                "") {
            @Override
            public void run() {
                i++;
                int time = 0;
                Random rd = new Random();
                time = rd.nextInt(8) * 1000 + 1000;
                Log.d(TAG, "run work thread ScheduleFixTimer tid =" + Thread.currentThread().getId()
                        + "  this.name=" + this.name + " time=" + time + " size=" +
                        wtScheduleFixtimerTaskices.size() + " this=" + this
                        + " when=" + this.when);
                try {
                    Thread.sleep(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Random rd = new Random();
//        final int period = rd.nextInt(30) * 1000 + 1000;
        final int period = 30 * 1000;
        wtScheduleFixtimerTaskices.add(timerTaskEx);
        Random rdnum = new Random();
        final int num = rdnum.nextInt(10);
        //测试主线程和子线程
        if (num % 2 == 0) {
            Log.d(TAG, "mainThread onclick ScheduleFixTimer period=" + period + " name=" +
                    timerTaskEx.name);
            TimerManager.getInstance().scheduleAtFixedRate(timerTaskEx, 1000, period);
        } else {
            new Thread() {
                @Override
                public void run() {
                    Log.d(TAG, "workThread onclick ScheduleFixTimer period=" + period + " " +
                            "name=" +
                            timerTaskEx.name);
                    TimerManager.getInstance().scheduleAtFixedRate(timerTaskEx, 1000, period);
                }
            }.start();
        }
    }

    @OnClick(R.id.test_ui_timer)
    public void onTestUiTimerClicked() {
        final TimerTaskEx timerTaskEx = new TimerTaskEx(mUIScheduleCount.getAndIncrement() + "") {
            @Override
            public void run() {
                Log.d(TAG, "run UiTimer schedule tid =" + Thread.currentThread().getId
                        () + " size=" + uiScheduletimerTaskices.size() + "  this.name=" + this
                        .name);
            }
        };
        uiScheduletimerTaskices.add(timerTaskEx);
        Random rd = new Random();
//        final int period = rd.nextInt(8) * 1000 + 1000;
        final int period = rd.nextInt(8) * 1000 + 1000;
        Random rdnum = new Random();
        final int num = rdnum.nextInt(10);
        if (num % 2 == 0) {
            Log.d(TAG, "mainThread onclick UiTimer period=" + period + " name=" +
                    timerTaskEx.name);
            TimerManager.getInstance().schedule(timerTaskEx, period, true);
        } else {
            new Thread() {
                @Override
                public void run() {
                    Log.d(TAG, "workThread onclick UiTimer period=" + period + " name=" +
                            timerTaskEx.name);
                    TimerManager.getInstance().schedule(timerTaskEx, period, true);
                }
            }.start();
        }
    }

    @OnClick(R.id.cancel_wt_schedule_fix_timer)
    public void onCancelWtScheduleFixTimerClicked() {
        mTestRelativeLayout.setVisibility(View.VISIBLE);
//        synchronized (this) {
//            if (wtScheduleFixtimerTaskices.size() > 0) {
//                Random rd = new Random();
//                final int index = rd.nextInt(wtScheduleFixtimerTaskices.size());
//                final TimerTaskEx timerTaskEx = wtScheduleFixtimerTaskices.remove(index);
//                if (index % 2 == 0) {
//                    Log.d(TAG, "mainThread onCancelWtScheduleFixTimerClicked   name=" +
//                            timerTaskEx.name);
//                    TimerManager.getInstance().cancel(timerTaskEx);
//                } else {
//                    new Thread() {
//                        @Override
//                        public void run() {
//                            Log.d(TAG, "workThread onCancelWtScheduleFixTimerClicked name=" +
//                                    timerTaskEx.name);
//                            TimerManager.getInstance().cancel(timerTaskEx);
//                        }
//                    }.start();
//                }
//            }
//        }
    }

    @OnClick(R.id.cancel_wt_schedule_timer)
    public void onCancelWtScheduleTimerClicked() {
        mTestRelativeLayout.setVisibility(View.GONE);
//        synchronized (this) {
//            if (wtScheduletimerTaskices.size() > 0) {
//                Random rd = new Random();
//                final int index = rd.nextInt(wtScheduletimerTaskices.size());
//                final TimerTaskEx timerTaskEx = wtScheduletimerTaskices.remove(index);
//                if (index % 2 == 0) {
//                    Log.d(TAG, "mainThread onCancelWtScheduleTimerClicked name=" +
//                            timerTaskEx.name);
//                    TimerManager.getInstance().cancel(timerTaskEx);
//                } else {
//                    new Thread() {
//                        @Override
//                        public void run() {
//                            Log.d(TAG, "workThread onCancelWtScheduleTimerClicked name=" +
//                                    timerTaskEx.name);
//                            TimerManager.getInstance().cancel(timerTaskEx);
//                        }
//                    }.start();
//                }
//            }
//
//        }
    }

    private int[] m;

    @OnClick(R.id.cancel_ui_timer)
    public void onCancelUiTimerClicked() {
        m = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            m[i] = i;
//            HandlerThread handlerThread = new HandlerThread("ffff");
//            handlerThread.start();
        }
//        new ThreadEx("test") {
//            @Override
//            public void run() {
//                super.run();
//                Log.d(TAG, "runImpl: ");
//            }
//        }.start();
//        new ThreadEx(new Runnable() {
//            @Override
//            public void run() {
//                Log.d(TAG, "runImpl:11111 ");
//            }
//        }, "test") {
//            @Override
//            public void run() {
//                super.run();
//                Log.d(TAG, "runImpl: 22222");
//            }
//        }.start();
//        synchronized (this) {
//        Random rd = new Random();
//        if (uiScheduletimerTaskices.size() > 0) {
//            final int index = rd.nextInt(uiScheduletimerTaskices.size());
//            final TimerTaskEx timerTaskEx = uiScheduletimerTaskices.remove(index);
//            if (index % 2 == 0) {
//                Log.d(TAG, "mainThread onCancelUiTimerClicked name=" +
//                        timerTaskEx.name);
//                TimerManager.getInstance().cancel(timerTaskEx);
//            } else {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "workThread onCancelUiTimerClicked name=" +
//                                timerTaskEx.name);
//                        TimerManager.getInstance().cancel(timerTaskEx);
//                    }
//                }.start();
//            }
//        }
//        }
        mHandler.sendEmptyMessage(0);
        mTestRelativeLayout = (RelativeLayout) ((ViewStub) findViewById(R.id.stub_import))
                .inflate();
        mTestRelativeLayout.setVisibility(View.VISIBLE);
        View testLayout = findViewById(R.id.test_r_layout);
        View testBtn = findViewById(R.id.test_button);
        Log.d(TAG, "onCreate: testLayout=" + testLayout + " testBtn=" + testBtn);
    }

//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            Log.d(TAG, "11 handleMessage: ");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                Log.d(TAG, "handleMessage: idle=" + Looper.getMainLooper().getQueue().isIdle());
////            } else {
////                Looper.getMainLooper().getQueue();
////            }
//        }
//    };

    class MyRunnable implements Runnable {
        int id;

        MyRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            Log.d(TAG, "MyRunnable: id=" + id + "  thread.name=" + Thread.currentThread().getName()
                    + " tid = " + Thread
                    .currentThread().getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyAsyncTaskEx extends AsyncTaskEx<String, Long,
            TestUtilActivity> {
        @Override
        protected TestUtilActivity doInBackground(String... params) {
            Log.d(TAG, "doInBackground: name=" + Thread.currentThread().getName() + " " +
                    "params[0]=" + params[0] + " tid=" + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(TestUtilActivity testUtilActivity) {
            super.onPostExecute(testUtilActivity);
//            Log.d(TAG, "onPostExecute: name=" + Thread.currentThread().getName());
        }

    }

    private Handler mHandler;
    private final ThreadFactory mThreadFactory = new ThreadFactory() {
//        private final AtomicInteger mWTScheduleCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "TimerThread service #" + mCount1.getAndIncrement());
        }
    };
    int p = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_util);
        View testLayout = findViewById(R.id.test_r_layout);
        Button testBtn = (Button) findViewById(R.id.test_button);
//        Integer ss = null;
//        int a = (int)ss;
        Log.d(TAG, "onCreate: testLayout=" + testLayout + " testBtn=" + testBtn);
        ButterKnife.bind(this);
        mScheduledExecutorService = (ScheduledThreadPoolExecutor) Executors
                .newScheduledThreadPool(4, mThreadFactory);
        mScheduledExecutorService.allowCoreThreadTimeOut(true);
        mScheduledExecutorService.setKeepAliveTime(50, TimeUnit.SECONDS);
//        findViewById(R.id.test_async).setOnClickListener(this);
//        findViewById(R.id.test_timer).setOnClickListener(this);
//        findViewById(R.id.test_fix_timer).setOnClickListener(this);
//        findViewById(R.id.cancel_ui_timer).setOnClickListener(this);
//        findViewById(R.id.cancel_wt_timer).setOnClickListener(this);
//        findViewById(R.id.test_ui_timer).setOnClickListener(this);
        HandlerThread handlerThread = new HandlerThread("ggg") {
            @Override
            public void run() {
                super.run();
//                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//                    @Override
//                    public boolean queueIdle() {
//                        Log.d(TAG, "queueIdle()");
//                        return true;
//                    }
//                });
            }
        };
        handlerThread.start();
        handlerThread.getLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.d(TAG, "queueIdle()");
                return true;
            }
        });
        mHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
//                mHandler.removeMessages(0);
                p++;
                Log.d(TAG, "handleMessage() 11");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Log.d(TAG, "handleMessage() 22");
                if (p < 4) {
                    mHandler.sendEmptyMessage(0);
                }
            }
        };
//        mHandler.getLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//                Log.d(TAG, "queueIdle()");
//                return true;
//            }
//        });
//        handler.getLooper().myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//                Exception exception = new Exception("dgg");
//                Log.d(TAG, "queueIdle()");
//                return true;
//            }
//        });
//        for (int i = 0; i < 10; i++) {
//            MyAsyncTaskEx asyncTaskEx = new MyAsyncTaskEx();
//            asyncTaskEx.executeOnExecutor(AsyncTaskEx.THREAD_POOL_EXECUTOR, "" + i);
//        }

    }
}
