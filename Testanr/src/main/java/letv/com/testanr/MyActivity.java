package letv.com.testanr;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import letv.com.testanr.reflect.FieldUtils;
import letv.com.testanr.reflect.MethodUtils;
import letv.com.testanr.util.ANRMonitorManager;

import static android.content.pm.PackageManager.GET_META_DATA;
import static android.content.pm.PackageManager.GET_SHARED_LIBRARY_FILES;


public class MyActivity extends Activity {
    private static final String TAG = "Testanr_MyActivity";
    public static final String ACTION = "android.intent.action.mystaticreceiver";
    public static final String ACTION_DYNAMIC = "android.intent.action.mydynamicreceiver";
    @BindView(R.id.start_fg_service)
    Button startFgService;
    @BindView(R.id.start_bg_service)
    Button startBgService;
    @BindView(R.id.start_fg_broadcast)
    Button startFgBroadcast;
    @BindView(R.id.start_bg_broadcast)
    Button startBgBroadcast;
    @BindView(R.id.start_static_broadcast)
    Button startStaticBroadcast;
    @BindView(R.id.test_anr)
    Button testAnr;
    @BindView(R.id.bind_service)
    Button bindService;
    @BindView(R.id.unbind_service)
    Button unbindService;
    @BindView(R.id.register_callback)
    Button registerCallback;
    @BindView(R.id.test_school)
    Button testSchool;
    @BindView(R.id.test_call)
    Button testCall;
    @BindView(R.id.launch_loading)
    Button launchLoading;
    @BindView(R.id.get_adId)
    Button getAdId;
    @BindView(R.id.test_messager)
    Button testMessager;
    @BindView(R.id.job_Service)
    Button jobService;
    @BindView(R.id.register_messager)
    Button registerMessager;
    private final Object mLockObject = new Object();
    private final Object mWaitObject = new Object();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case 1: {
                    PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
                    wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager
                                    .ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE,
                            "WakeAndLock");
//                    wakeLock = ((PowerManager) getSystemService(Context.POWER_SERVICE))
// .newWakeLock(PARTIAL_WAKE_LOCK, "cpu_lck");
//                    wakeLock = pm.newWakeLock(PARTIAL_WAKE_LOCK, "WakeAndLock");
                    Log.d(TAG, "handleMessage what-" + msg.what + " wakeLock=" + wakeLock.isHeld());
                    wakeLock.acquire();
//                    wakeLock.acquire();
//                    wakeLock.acquire();
                    break;
                }
                case 2: {
                    if (null != wakeLock) {
                        Log.d(TAG, "handleMessage what-" + msg.what + " wakeLock=" + wakeLock
                                .isHeld());
                        if (wakeLock.isHeld()) {
                            wakeLock.release();
                        }
                    }
                    break;
                }
            }

//            wakeLock.release();
//            try {
//                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT,
//                        30000);
//            } catch (SecurityException e) {
//
//            } catch (Exception e) {
//                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT,
//                        30000);
//            }
//            pm.goToSleep(SystemClock.uptimeMillis());
//            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//            PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP
// | PowerManager.SCREEN_DIM_WAKE_LOCK, "TAG");
//            wakeLock.acquire();
////然后定时
//            mTimeHandler.postDelayed(new Runnable(){
//                public void run(){
//                    wakeLock.release();//
//                }
//            }, 10*1000);//延时10秒灭屏
        }
    };
    private ITestbinder iTestbinder;
    private Messenger mServiceMessenger;
    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger mMessenger = new Messenger(mHandler);
    private TestServiceConnection connection = new TestServiceConnection();
    private MessengerConnection messengerConnection = new MessengerConnection();
    private ICallback.Stub iCallback = new ICallback.Stub() {
        @Override
        public void showResult(String result) throws RemoteException {
            Log.d(MyActivity.TAG, "showResult result=" + result + " CallingPid=" + Binder
                    .getCallingPid() + " CallingUid=" + Binder.getCallingUid());
        }

        @Override
        public void showTestResult(String result) throws RemoteException {
            Log.d(MyActivity.TAG, "showTestResult result=" + result + " CallingPid=" + Binder
                    .getCallingPid() + " CallingUid=" + Binder.getCallingUid());
        }
    };

    class MessengerConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "MessengerConnection onServiceDisconnected =" + name);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Exception exception = new Exception("onServiceConnected");
            Log.d(TAG, "MessengerConnection onServiceConnected =" + name + " service=" + service,
                    exception);
            mServiceMessenger = new Messenger(service);
            Log.d(TAG, "MessengerConnection onServiceConnected =" + name + " service=" + service
                    + " mServiceMessenger=" +
                    mServiceMessenger);
            try {
                mServiceMessenger.getBinder().linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        Log.d(TAG, "Messenger binderDied tNanme=" + Thread.currentThread()
                                .getName());
                    }
                }, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.d(TAG, "Messenger RemoteException e=" + e);
            }
        }
    }

    class TestServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Exception exception = new Exception("onServiceConnected");

            Log.d(TAG, "onServiceConnected =" + name + " service=" + service, exception);
            iTestbinder = ITestbinder.Stub.asInterface(service);
            Log.d(TAG, "onServiceConnected =" + name + " service=" + service + " iTestbinder=" +
                    iTestbinder);
            try {
//                Trace.beginSection();
                iTestbinder.asBinder().linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        Log.d(TAG, "binderDied tNanme=" + Thread.currentThread().getName());
                    }
                }, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
//            try {
//                Log.d(TAG, "onServiceConnected 1 ");
//                iTestbinder.registerCallback(iCallback);
//                Log.d(TAG, "onServiceConnected 2 ");
//                iTestbinder.getAdId("dd");
//                Log.d(TAG, "onServiceConnected 3 ");
//                iTestbinder.testSchool(new School());
//                Log.d(TAG, "onServiceConnected 4");
//                iTestbinder.testCall(null);
//                Log.d(TAG, "onServiceConnected 5");
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected =" + name);
        }
    }

    static class MyTest {
        String str;
        int code;

        MyTest(String name, int code) {
            str = name;
            this.code = code;
        }

        @Override
        public int hashCode() {
            return code;
        }

        @Override
        public boolean equals(Object o) {
            String other = ((MyTest) o).str;
            return str.substring(0, 1).equals(other.substring(0, 1));
        }

        @Override
        public String toString() {
            return str;
        }
    }

    ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager
                .LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(ACTION);
        Log.d(TAG, "Testanr_MySR onCreate: ");
//        intent.putExtra("abc", "ddddddd55666");
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        alarm.cancel(pendingIntent);
//        alarm.setRepeating(AlarmManager.RTC_WAKEUP,
//                System.currentTimeMillis() + 16 * 1000,
//                5000,
//                pendingIntent);
//        Intent intent1 = new Intent(ACTION);
//        intent1.putExtra("abc", "fff");
//        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        alarm.cancel(pendingIntent1);
//        alarm.setRepeating(AlarmManager.RTC_WAKEUP,
//                System.currentTimeMillis() + 20 * 1000,
//                8000,
//                pendingIntent1);
//        alarm.setWindow(AlarmManager.RTC_WAKEUP,
//                System.currentTimeMillis() + 3 * 1000,
//                1000,
//                pendingIntent);
        Process.setThreadPriority(Process.THREAD_PRIORITY_AUDIO);
        List<String> mHostThemeCallbackList = Collections.synchronizedList(new
                ArrayList<String>());
        mHostThemeCallbackList.add("a");
        mHostThemeCallbackList.add("b");
        mHostThemeCallbackList.add("c");
        String dd = null;
//        for (String str : mHostThemeCallbackList) {
//            mHostThemeCallbackList.remove("c");
//        }
        String a = new String("abcd");
        String b = new String("abcd");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        HashMap<MyTest, String> hashMap = new HashMap<>();
        hashMap.put(new MyTest("ab", 1), "fff");
        hashMap.put(new MyTest("ad", 1), "hhh");
        hashMap.put(new MyTest("cd", 1), "vv");
        hashMap.put(new MyTest("fe", 1), "eee");
        hashMap.put(new MyTest("ww", 1), "eee");
        hashMap.put(new MyTest("bb", 1), "eee");
        hashMap.put(new MyTest("vd", 3), "eee");
        System.out.println("hashMap =" + hashMap);
        for (MyTest myTest : hashMap.keySet()) {
            System.out.println("myTest=" + myTest);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inTargetDensity = 480;
//        options.inSampleSize
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.t, options);
//        Log.d(TAG, "onCreate: byteCount=" + bmp.getByteCount() + " allocate=" + bmp
//                .getAllocationByteCount() + " height=" + bmp.getHeight() + " options=" + options
//                .outHeight + " onfig=" + options.inPreferredConfig + " dd=" + bmp.getConfig());
        ButterKnife.bind(this);
        IntentFilter intentFilter = new IntentFilter(ACTION_DYNAMIC);
        MyDynamicReceiverA myDynamicReceiverA = new MyDynamicReceiverA();
        registerReceiver(myDynamicReceiverA, intentFilter);
        int tagerSdkVersion = getApplicationInfo().targetSdkVersion;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parentClassLoader = classLoader.getParent();
        Log.d(TAG, "onCreate: startBgBroadcast=" + startBgBroadcast + " tagerSdkVersion=" +
                tagerSdkVersion + "  classLoader=" + classLoader + " parentClassLoader=" +
                parentClassLoader);
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName
                    (), GET_META_DATA | GET_SHARED_LIBRARY_FILES);
//            Log.d(TAG, "onCreate: applicationInfo.sourceDir=" + applicationInfo.sourceDir + " " +
//                    "sharedLibraryFiles=" + applicationInfo.sharedLibraryFiles + " " +
//                    "splitSourceDirs=" + applicationInfo.splitSourceDirs + " " +
//                    "mDataDir=" + applicationInfo.dataDir + " nativeLibraryDir=" +
//                    applicationInfo.nativeLibraryDir);
            Class ApplicationLoaders = Class.forName("android.app.ApplicationLoaders");
            Object applicationLoaders = MethodUtils.invokeStaticMethod(ApplicationLoaders,
                    "getDefault");
            Object mLoaders = FieldUtils.readField(applicationLoaders, "mLoaders", true);
            Log.d(TAG, "onCreate: mLoaders=" + mLoaders);
//            if (mLoaders instanceof HashMap) {
//                HashMap oldValue = ((HashMap) mLoaders);
//                if ("com.lbe.security.client.ClientContainer$MonitoredLoaderMap".equals(mLoaders
//                        .getClass().getName())) {
//                    HashMap value = new HashMap();
//                    value.putAll(oldValue);
//                    FieldUtils.writeField(applicationLoaders, "mLoaders", value, true);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            Thread.currentThread().sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//        Process.setThreadPriority(Process.THREAD_PRIORITY_LOWEST);
//        Log.d(TAG, "onCreate: mLoaders=" + Process.getThreadPriority(Process.myTid()));
//        Log.d(TAG, "onCreate: mLoaders=" + Thread.currentThread().getPriority());
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        test();
//        while (true) {
//            i++;
//            new Thread() {
//                @Override
//                public void run() {
//                    setName("test_thread_i=" + i);
//                    long time = System.currentTimeMillis();
//                    while (true/*(System.currentTimeMillis() - time) < 25000*/) {
//
//                    }
//
//                }
//            }.start();
//            if (i > 150) {
//                break;
//            }
//        }
//        new TestRetrace().test("fff");
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread workThread = new Thread() {
//            @Override
//            public void run() {
//                new WebView(MyActivity.this);
////                synchronized (mLockObject) {
////                    Log.d(TAG, "test work thread");
////                    try {
////                        Thread.sleep(25000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
//            }
//        };
//        workThread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (mLockObject) {
//            try {
//                mLockObject.wait(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Log.d(TAG, "test main thread");
//        }
        activityManager = (ActivityManager) getSystemService(Context
                .ACTIVITY_SERVICE);
        List<ProcessErrorStateInfo> processErrorStateInfos = activityManager
                .getProcessesInErrorState();
        Log.d(TAG, "onCreate: processErrorStateInfos=" + processErrorStateInfos);
//        for (ProcessErrorStateInfo processErrorStateInfo : processErrorStateInfos) {
//            Log.d(TAG, "onCreate: processName=" + processErrorStateInfo.processName + " msg=" +
//                    processErrorStateInfo.longMsg + "  shortMsg=" + processErrorStateInfo
//                    .shortMsg + " stackTrace" + processErrorStateInfo.stackTrace + "
// condition=" +
//                    processErrorStateInfo.condition);
//        }
        ANRMonitorManager.getInstance(this).startMonitor();
    }

    int i = 0;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
//        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
//        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,
//                "DPA");
//
//        wakeLock.acquire();
//        mHandler.sendEmptyMessageDelayed(0, 5000);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
//        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
//        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager
//                .ACQUIRE_CAUSES_WAKEUP, "WakeAndLock");
        if (wakeLock != null) {
//            wakeLock.release();
            Log.d(TAG, "onPause: wakeLock=" + wakeLock.isHeld());
        }
//        mHandler.sendEmptyMessageDelayed(2, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        Intent intent = new Intent(ACTION);
        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent);
//        Process.killProcess(android.os.Process.myPid());
//        try {
//            Method method = Process.class.getDeclaredMethod("killProcessGroup", Integer.class,
//                    Integer.class);
//            method.invoke(null, Process.myUid(), Process.myPid());
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "onDestroy: e=" + e);
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
        finish();
    }

    private void readlog(final String param) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                java.lang.Process logcatProcess = null;
                BufferedReader bufferedReader = null;
                try {
                    /** 获取系统logcat日志信息 */

                    //相当于在命令行运行  logcat -s dalvikm ,  -s表示过滤，
                    // 第三个参数表示过滤的条件。如果没有第三个参数，数组长度2，肯定也是可以的。下面有logcat的使      用方法
//                    String[] running=new String[]{ "logcat","-s","dalvikvm" };
                    logcatProcess = Runtime.getRuntime().exec("logcat " + param);

                    bufferedReader = new BufferedReader(new InputStreamReader(
                            logcatProcess.getInputStream()));

                    String line;
                    //筛选需要的字串
                    String strFilter = "Could not find method";
                    int n = 0;
                    while ((line = bufferedReader.readLine()) != null) {
                        n++;
                        Log.d(TAG, "run: sssss=" + line + " n=" + n);
                        //读出每行log信息
//                        System.out.println(line);
//                        if (line.indexOf(strFilter) >= 0) {
//                            /** 检测到strFilter的log日志语句，进行你需要的处理 */
//                            break;
//                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick(R.id.start_fg_service)
    public void onStartFgServiceClicked() {
        new Thread() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                Log.d(TAG, "fffffffff time=" + time);
                while (true) {
                    if ((System.currentTimeMillis() - time) > 30000) {
//                        readlog("");
                        List<ProcessErrorStateInfo> processErrorStateInfos = activityManager
                                .getProcessesInErrorState();
                        Log.d(TAG, "run: processErrorStateInfo=" + processErrorStateInfos);
                        if (null == processErrorStateInfos) {
                            return;
                        }
                        for (ProcessErrorStateInfo processErrorStateInfo : processErrorStateInfos) {
                            Log.d(TAG, "onCreate: processName=" + processErrorStateInfo
                                    .processName +
                                    " " +
                                    "msg=" +
                                    processErrorStateInfo.longMsg + "  shortMsg=" +
                                    processErrorStateInfo
                                            .shortMsg + " stackTrace" + processErrorStateInfo
                                    .stackTrace + " " +
                                    " " +
                                    "condition=" +
                                    processErrorStateInfo.condition);
                        }
                        break;
                    }

                }
            }
        }.start();
        Log.d(TAG, "onStartFgServiceClicked: ");
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        mHandler.sendEmptyMessageDelayed(1, 3000);
//        Intent intent = new Intent(this, MyService
// .class);
//        intent.putExtra("abc", "cj");
//        startService(intent);
    }


    @OnClick(R.id.job_Service)
    public void onJobServiceClicked() {
        Log.d(TAG, "onJobServiceClicked");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            pollServer();
//        }
//        mCpuLock = ((PowerManager) context.getSystemService(Context.POWER_SERVICE)).newWakeLock
// (PowerManager.PARTIAL_WAKE_LOCK, "cpu_lck");
//        mHandler.sendEmptyMessageDelayed(2, 8000);
//        if (wakeLock != null) {
////            wakeLock.release();
//            Log.d(TAG, "onJobServiceClicked: wakeLock=" + wakeLock.isHeld());
//        }
    }

    @OnClick(R.id.start_bg_service)
    public void onStartBgServiceClicked() {
        Log.d(TAG, "onStartFgServiceClicked: ");
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("abc", "cj");
        startService(intent);
    }

    public void pollServer() {
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        for (int i = 0; i < 40; i++) {
            JobInfo jobInfo = new JobInfo.Builder(i, new ComponentName(getPackageName(),
                    MyJobService.class.getName()))
                    .setMinimumLatency(1000) // 5 seconds
//                    .setOverrideDeadline(10000) // 60 seconds (for brevity in the sample)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) // WiFi or data connections
                    .build();
            scheduler.schedule(jobInfo);
        }
    }

    @OnClick(R.id.bind_service)
    public void onBindServiceClicked() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("abc", "cj");
        boolean result = bindService(intent, connection, BIND_AUTO_CREATE);
        Log.d(TAG, "onBindServiceClicked: end result=" + result);
//        Intent intent1 = new Intent(this, MessengerService.class);
//        intent1.putExtra("abc", "cj");
//        bindService(intent1, messengerConnection, BIND_AUTO_CREATE);
    }

    @OnClick(R.id.unbind_service)
    public void onUnBindServiceClicked() {
        unbindService(connection);
    }

    @OnClick(R.id.start_fg_broadcast)
    public void onStartFgBroadcastClicked() {
        Intent intent = new Intent(ACTION);
        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent);
    }

    @OnClick(R.id.start_bg_broadcast)
    public void onStartBgBroadcastClicked() {
        Intent intent = new Intent(ACTION_DYNAMIC);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendOrderedBroadcast(intent, null);
    }

    @OnClick(R.id.start_static_broadcast)
    public void onStartStaticBroadcast() {
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
    }

    @OnClick(R.id.get_adId)
    public void onGetAdidClicked() {
        if (null != iTestbinder) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onGetAdidClicked: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        iTestbinder.getAdId("aaa");
                        Log.d(TAG, "onGetAdidClicked: end");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.register_callback)
    public void onRegisterCallbackClicked() {
        if (null != iTestbinder) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onRegisterCallbackClicked: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        iTestbinder.registerCallback(iCallback);
                        Log.d(TAG, "onRegisterCallbackClicked: end");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.test_school)
    public void onTestSchoolClicked() {
        if (null != iTestbinder) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onTestSchoolClicked: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        iTestbinder.testSchool(null);
                        Log.d(TAG, "onTestSchoolClicked: end");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.test_call)
    public void onTestCallClicked() {
        if (null != iTestbinder) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onTestCallClicked: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        iTestbinder.testCall(null);
                        Log.d(TAG, "onTestCallClicked: end");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.test_messager)
    public void onSendMessageClicked() {
        if (null != mServiceMessenger) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onSendMessageClicked hello: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        Message msg = Message.obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0);
                        mServiceMessenger.send(msg);
                        Log.d(TAG, "onSendMessageClicked: hello end ");
                        Log.d(TAG, "onSendMessageClicked client : pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        Message msg1 = Message.obtain(null, MessengerService.MSG_SAY_CLIENT, 0, 0);
                        mServiceMessenger.send(msg1);
                        Log.d(TAG, "onSendMessageClicked: client end ");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.register_messager)
    public void onRegisterMessagerClicked() {
        if (null != mServiceMessenger) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.d(TAG, "onRegisterMessagerClicked hello: pid=" + Process.myPid() + " " +
                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                                Binder
                                        .getCallingPid());
                        Message msg = Message.obtain(null, MessengerService.MSG_SAY_REGISTER, 0, 0);
                        msg.replyTo = mMessenger;
                        mServiceMessenger.send(msg);
                        Log.d(TAG, "onRegisterMessagerClicked: end ");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }


    @OnClick(R.id.launch_loading)
    public void onLaunchLoadingClicked() {
        Intent intent = new Intent(this, LoadingActivity.class);
        intent.putExtra("abc", "cj");
        startActivity(intent);
    }

    @OnClick(R.id.test_anr)
    public void onTestAnrClicked() {
        mHandler.sendEmptyMessage(0);
        new Thread() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                while (true) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "anr anr anr");
                }
            }
        }.start();
        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        Log.d(TAG, "onWindowAttributesChanged: params=" + params);
        super.onWindowAttributesChanged(params);
    }
}
