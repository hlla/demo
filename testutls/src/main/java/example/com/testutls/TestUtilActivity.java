package example.com.testutls;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.testutls.ui.TestTextView;
import example.com.testutls.utils.AsyncTaskEx;
import example.com.testutls.utils.TimerManager;
import example.com.testutls.utils.TimerTaskEx;

//import android.os.SystemProperties;

public class TestUtilActivity extends Activity /*implements View.OnClickListener */ {
    //    private static final String TAG = new String("TestUtilActivity");
    private static final String TAG = "TestUtilActivity";
    //    private static final String TAG1 = "TestUtilActivity";
//    private static final int SKIPPED_FRAME_WARNING_LIMIT = SystemProperties.getInt(
//            "debug.choreographer.skipwarning", 30);
    private static final boolean isTest = isTestAA();
    private static /*volatile*/ boolean stop = false;

    public static boolean isTestAA() {
        TestUtilActivity testVolatile = new TestUtilActivity();
        return testVolatile == null;
    }

    static {
        Log.d(TAG, "static initializer: sssss");
    }

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
    TextView cancelUiTimer;
    @BindView(R.id.stub_import)
    ViewStub stubImport;
    @BindView(R.id.test_barrier)
    Button testBarrier;
    @BindView(R.id.remove_barrier)
    Button removeBarrier;
    @BindView(R.id.test_textview)
    TestTextView testTextView;
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
    private int mBarrierToken = -1;
    Uri uri = Uri.parse("content://com.sec.android.app.launcher" +
            ".settings/favorites?notify=true");
    Uri uri1 = Uri.parse("content://com.sec.android.app.launcher.providers" +
            ".LauncherProvider/favorites?notify=true");

    @OnClick(R.id.test_asynctask)
    public void onTestAsynctaskClicked() {
//        for (int i = 0; i < 50; i++) {
//            MyAsyncTaskEx asyncTaskEx = new MyAsyncTaskEx();
//            asyncTaskEx.executeOnExecutor(AsyncTaskEx.THREAD_POOL_EXECUTOR, "" + i);
//        }
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
        changeWarningLimit();
//        mTestRelativeLayout.setVisibility(View.GONE);
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

    private void test() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (this) {
            try {
                wait(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d("ffff", "test11: " + WebSettings.getDefaultUserAgent(this));
    }


    @OnClick(R.id.cancel_ui_timer)
    public void onCancelUiTimerClicked() {
        Log.d(TAG, "onCancelUiTimerClicked: click");
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(TestDBHelper.ID, 1);
//        contentValues.put(TestDBHelper.FIELD_SOUCE_ID, 4);
//        contentValues.put(TestDBHelper.FIELD_THUMBURL, "http:sss");
//        ContentValues contentValues1 = new ContentValues();
//        contentValues1.put(TestDBHelper.ID, 2);
//        contentValues1.put(TestDBHelper.FIELD_SOUCE_ID, 7);
//        contentValues1.put(TestDBHelper.FIELD_THUMBURL, "http:aaaa");
//        ContentValues contentValues2 = new ContentValues();
//        contentValues2.put(TestDBHelper.ID, 3);
//        contentValues2.put(TestDBHelper.FIELD_SOUCE_ID, 7);
//        contentValues2.put(TestDBHelper.FIELD_THUMBURL, "http:aaaa");
//        Uri uri = getContentResolver().insert(TestContentProvider
//                .CONTENT_URI_AUTHORITY_LOCAL, contentValues);
//        Uri uri1 = getContentResolver().insert(TestContentProvider
//                .CONTENT_URI_AUTHORITY_LOCAL, contentValues1);
//        Uri uri2 = getContentResolver().insert(TestContentProvider
//                .CONTENT_URI_AUTHORITY_LOCAL, contentValues2);
//        Log.d(TAG, "onCancelUiTimerClicked: uri=" + uri);
//        String value = "1";
//        String selection = TestDBHelper.ID + " in (1,2,3) group by " +
//                TestDBHelper.FIELD_SOUCE_ID;
//        String[] selectionArgs = new String[]{String.valueOf(1)};
////        final Cursor sc = contentResolver.query(screensUri, new String[]{LauncherSettings
////                .Favorites.SCREEN}, selection, selectionArgs, null);
//        Cursor cursor = getContentResolver().query(TestContentProvider
//                .CONTENT_URI_AUTHORITY_LOCAL, null, selection, null, null);
//        Log.d(TAG, "onCancelUiTimerClicked: cursor11=" + cursor.getCount());
//        cursor.moveToFirst();
//        Log.d(TAG, "onCancelUiTimerClicked: cursor11=" + cursor.getString(0));
//        Log.d(TAG, "onCancelUiTimerClicked: cursor11=" + cursor.getString(1));
//        Log.d(TAG, "onCancelUiTimerClicked: cursor11=" + cursor.getString(2));
//        Log.d(TAG, "onCancelUiTimerClicked: uri=" + uri);
//        String value = "1";
//        try {
//            Context context = createPackageContext("com.sec.android.app.launcher",
//                    Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
//            SharedPreferences preferences = context.getSharedPreferences("com.sec.android.app" +
//                    ".launcher.prefs", 0);
//            PackageInfo info = getPackageManager().getPackageInfo("com.sec.android.app.launcher",
//                    0);
////            Log.d(TAG, " info.applicationInfo.sourceDir=" + info.applicationInfo.sourceDir +
/// " " +
////                    "preferences.getAll()=" + preferences.));
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        Uri uri = Uri.parse("content://com.sec.android.app.launcher/prefs?notify=true");
//        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//        Log.d(TAG, "onCancelUiTimerClicked: cursor=" + cursor);
//        if (null != cursor) {
//            Log.d(TAG, "onCancelUiTimerClicked: cursor=" + cursor.getCount());
//            for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.d(TAG, "onCancelUiTimerClicked: cursor.field=" + cursor.getColumnName(i));
//            }
//            while (cursor.moveToNext()) {
//                Log.d(TAG, "onCancelUiTimerClicked: 11111111111111");
////                for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.d(TAG, "onCancelUiTimerClicked: cursor.screen=" + cursor.getString(cursor
//                        .getColumnIndex("screen")));
//                Log.d(TAG, "onCancelUiTimerClicked: cursor.title=" + cursor.getString(cursor
//                        .getColumnIndex("title")));
////                }
//            }
//        }
//        Cursor cursor1 = getContentResolver().query(uri1, null, null, null, null);
//        if (null != cursor1) {
//            Log.d(TAG, "onCancelUiTimerClicked: cursor11=" + cursor1.getCount());
//            for (int i = 0; i < cursor1.getColumnCount(); i++) {
//                Log.d(TAG, "onCancelUiTimerClicked: cursor11.field=" + cursor1.getColumnName(i));
//            }
//            while (cursor1.moveToNext()) {
//                for (int i = 0; i < cursor1.getColumnCount(); i++) {
//                    Log.d(TAG, "onCancelUiTimerClicked: cursor.value=" + cursor1.getString(i));
//                }
//            }
//        }
//        Log.d(TAG, "onCancelUiTimerClicked: cursor1111=" + cursor1);
//        ApplicationInfo appInfo = null;
//        try {
//            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(),
//                    PackageManager.GET_META_DATA);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        String msg = appInfo.metaData.getString("abc");
//        Log.d(TAG, " msg == " + msg);
//        boolean test = false;
//        Log.d(TAG, "onCancelUiTimerClicked: start ");
//        assert test;
//        String ua = WebSettings.getDefaultUserAgent(this);
//        Log.d(TAG, "onCancelUiTimerClicked: end ua=" + ua);
//        for (int i = 0; i < 6; i++) {
//            test();
//        }
//        Log.d(TAG, "onTestAsynctaskClicked SKIPPED_FRAME_WARNING_LIMIT=" +
//                SKIPPED_FRAME_WARNING_LIMIT);
//        m = new int[1000000];
//        for (int i = 0; i < 1000000; i++) {
//            m[i] = i;
////            HandlerThread handlerThread = new HandlerThread("ffff");
////            handlerThread.start();
//        }
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
//        mHandler.sendEmptyMessage(0);
//        mTestRelativeLayout.setVisibility(View.VISIBLE);
//        View testLayout = findViewById(R.id.test_r_layout);

        //        test1();
//        int test = SystemProperties.getInt("debug.test_link", 0);
//        Collection<Integer> strings = null;
//        switch (test) {
//            case 1: {
//                strings = new LinkedList<>();
//                break;
//            }
//            case 2: {
//                strings = new HashSet<>();
//                break;
//            }
//            case 3: {
//                strings = new ArrayList<>();
//                break;
//            }
//            default: {
//                strings = new LinkedList<>();
//            }
//        }
//        HashSet<TestVolatile> strings = new HashSet<>();
//        ArrayList<TestVolatile> strings = new ArrayList<>();
//        long time = System.currentTimeMillis();
//        int num = SystemProperties.getInt("debug.test_num", 10000);
//        for (int i = 0; i <= num; i++) {
//            strings.add(i);
//        }
//        Log.d(TAG, "onCancelUiTimerClicked: time=" + (System.currentTimeMillis() - time) + " " +
//                "strings=" + strings.getClass());
//        time = System.currentTimeMillis();
////        Iterator<TestVolatile> iter = strings.iterator();
////        while (iter.hasNext()) {
////            iter.next();
////        }
//        int num1 = SystemProperties.getInt("debug.test_num1", 100);
//        for (int i = 0; i < num1; i++) {
//            Random random = new Random();
////            strings.add(0, new TestVolatile());
//            strings.remove(Integer.valueOf(random.nextInt(num)));
//        }
//        Log.d(TAG, "onCancelUiTimerClicked: num=" + num + " num1=" + num1 + " strings=" + strings
//                .size());
////        System.out.println(ss);
////        HashSet<TestVolatile> stringHashSet = new HashSet<>();
////        for (int i = 0; i < 1500000; i++) {
////            stringHashSet.add(new TestVolatile());
////        }
//        Exception exception = new Exception("click");
//        Log.d(TAG, "onCancelUiTimerClicked: start sleep ", exception);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "onCancelUiTimerClicked: time1=" + (System.currentTimeMillis() - time));
        mUIHandler.sendEmptyMessageDelayed(0, 5000);
    }

    @OnClick(R.id.test_barrier)
    public void onTestBarrierClicked() {
        Message msg1 = Message.obtain();
        msg1.what = 1;
        mHandler.sendMessage(msg1);
        Message msg2 = Message.obtain();
        msg2.what = 2;
        msg2.setAsynchronous(true);
        mHandler.sendMessage(msg2);
        mBarrierToken = postSyncBarrier(mHandler.getLooper().getQueue());
        Message msg3 = Message.obtain();
        msg3.what = 3;
        mHandler.sendMessage(msg3);
        Message msg4 = Message.obtain();
        msg4.what = 4;
        mHandler.sendMessage(msg4);
        Message msg5 = Message.obtain();
        msg5.what = 5;
        msg5.setAsynchronous(false);
        mHandler.sendMessageDelayed(msg5, 3000);
        Message msg6 = Message.obtain();
        msg6.what = 6;
        msg6.setAsynchronous(true);
        mHandler.sendMessageDelayed(msg6, 5000);
        Log.d(TAG, "onTestBarrierClicked: mBarrierToken=" + mBarrierToken);
    }

    @OnClick(R.id.remove_barrier)
    public void onRemoveBarrierClicked() {
        Log.d(TAG, "onRemoveBarrierClicked: mBarrierToken=" + mBarrierToken);
        removeSyncBarrier(mHandler.getLooper().getQueue(), mBarrierToken);
    }

    private int postSyncBarrier(MessageQueue queue) {
        int token = -1;
        try {
            Method method = MessageQueue.class.getDeclaredMethod("postSyncBarrier");
            method.setAccessible(true);
            token = (int) method.invoke(queue);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "postSyncBarrier: e=" + e);
        }
        return token;
    }

    private void removeSyncBarrier(MessageQueue queue, int token) {
        try {
            Method method = MessageQueue.class.getDeclaredMethod("removeSyncBarrier", int.class);
            method.setAccessible(true);
            method.invoke(queue, token);
        } catch (Exception e) {
            Log.d(TAG, "removeSyncBarrier: e=" + e);
            e.printStackTrace();
        }
    }

    public static void changeWarningLimit() {
        try {
            Class<?> testClass = Class.forName("android.view.Choreographer");
            Field field = testClass.getDeclaredField("SKIPPED_FRAME_WARNING_LIMIT");
            field.setAccessible(true);
            field.setInt(null, 1);
        } catch (Exception e) {
            Log.d(TAG, "changeWarningLimit: e=" + e);
        }
        try {
            Class<?> testClass = Class.forName("android.view.Choreographer");
            Field field = testClass.getDeclaredField("LOG_EXCEPTION");
            field.setAccessible(true);
            field.setBoolean(null, true);
        } catch (Exception e) {
            Log.d(TAG, "changeWarningLimit: e=" + e);
        }
        try {
            Class<?> testClass = Class.forName("android.view.Choreographer");
            Field field = testClass.getDeclaredField("DEBUG_FRAMES");
            field.setAccessible(true);
            field.setBoolean(null, true);
        } catch (Exception e) {
            Log.d(TAG, "changeWarningLimit: e=" + e);
        }
        try {
            Class<?> testClass = Class.forName("android.view.Choreographer");
            Field field = testClass.getDeclaredField("DEBUG_FRAMES");
            field.setAccessible(true);
            field.setBoolean(null, true);
        } catch (Exception e) {
            Log.d(TAG, "changeWarningLimit: e=" + e);
        }
//        try {
//            Class<?> testClass = Class.forName("android.view.Choreographer");
//            Field field = testClass.getDeclaredField("USE_VSYNC");
//            field.setAccessible(true);
//            field.setBoolean(null, false);
//        } catch (Exception e) {
//            Log.d(TAG, "changeWarningLimit: e=" + e);
//        }
//        try {
//            Class<?> testClass = Class.forName("example.com.testutls.TestUtilActivity");
//            Field field = testClass.getDeclaredField("TAG");
//            field.setAccessible(true);
//            field.set(null, "hhhhhhhh");
//            Log.d(TAG, "changeWarningLimit: ssss=" + field.get(null));
//        } catch (Exception e) {
//            Log.d(TAG, "changeWarningLimit: e=" + e);
//        }
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
    private Handler mUIHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: start");
            new Thread() {
                @Override
                public void run() {
                    Log.d(TAG, "post1111");
                    Looper.prepare();
                    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback
                            () {
                        @Override
                        public void doFrame(long frameTimeNanos) {
                            Log.d(TAG, "doFrame: frameTimeNanos=" + frameTimeNanos);
                        }
                    });
                    Looper.loop();
                }
            }.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Log.d(TAG, "handleMessage: start what=" + msg.what);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            testTextView.setText("testTextView 11 what" + msg.what);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            removeBarrier.setText("testTextView 11 what" + msg.what);
//            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
//                @Override
//                public void doFrame(long frameTimeNanos) {
//                    Log.d(TAG, "doFrame: frameTimeNanos=" + frameTimeNanos);
//                }
//            });
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Log.d(TAG, "handleMessage: end");
        }
    };
    private final ThreadFactory mThreadFactory = new ThreadFactory() {
//        private final AtomicInteger mWTScheduleCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "TimerThread service #" + mCount1.getAndIncrement());
        }
    };
    int p = 0;

    @Override
    protected void onResume() {
        super.onResume();
        Exception exception = new Exception("onResume");
        Log.d(TAG, "onResume: start", exception);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onResume: end");
    }

    private static void swap(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp1 = num1.intValue();
            int temp2 = num2.intValue();
            field.set(num1, temp2);
            field.set(num2, temp1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: sssssssss");
        super.onCreate(savedInstanceState);
        TestUtilActivity.changeWarningLimit();
        Exception exception = new Exception("onCreate");
        Log.d(TAG, "onCreate: setContentView before", exception);
//        if (isTest) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        }
        setContentView(R.layout.activity_test_util);
        Button testBtn = (Button) findViewById(R.id.remove_barrier);
        ImageView imageView = (ImageView) findViewById(R.id.test_img);
        imageView.getDrawable().setColorFilter(0x4CFFFFFF, PorterDuff.Mode.SRC_IN);
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                testBtn.setText("11111111");
//            }
//        }.start();
//        testBtn.invalidate();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onCreate: setContentView after");
        View testLayout = findViewById(R.id.test_r_layout);
//        Button testBtn = (Button) findViewById(R.id.test_button);
//        Integer ss = null;
//        int a = (int)ss;
        Log.d(TAG, "onCreate: testLayout=" + testLayout + " testBtn=" + testBtn);
        ButterKnife.bind(this);
        mScheduledExecutorService = (ScheduledThreadPoolExecutor) Executors
                .newScheduledThreadPool(4, mThreadFactory);
//        mScheduledExecutorService.allowCoreThreadTimeOut(true);
//        mScheduledExecutorService.setKeepAliveTime(50, TimeUnit.SECONDS);
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
        handlerThread.getLooper().getQueue().addIdleHandler(() -> {
            Log.d(TAG, "queueIdle()");
            return true;
        });
        mHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Log.d(TAG, "handleMessage: start what=" + msg.what);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
                Log.d(TAG, "handleMessage: end");
//                mHandler.removeMessages(0);
//                p++;
//                Log.d(TAG, "handleMessage() 11");
////                try {
////                    Thread.sleep(3000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                Log.d(TAG, "handleMessage() 22");
//                if (p < 4) {
//                    mHandler.sendEmptyMessage(0);
//                }
            }
        };
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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
