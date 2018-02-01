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
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import letv.com.testanr.reflect.FieldUtils;
import letv.com.testanr.reflect.MethodUtils;

import static android.content.pm.PackageManager.GET_META_DATA;
import static android.content.pm.PackageManager.GET_SHARED_LIBRARY_FILES;


public class MyActivity extends Activity {
    private static final String TAG = "Testanr_MyActivity";
    public static final String ACTION = "android.intent.action.mystaticreceiver";
    public static final String ACTION_DYNAMIC = "android.intent.action.mydynamicreceiver";
    public static final String mUrl = "http://10.60.214.2:8080/test_big_file.zip";
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
    @BindView(R.id.test_main_thread_consuming)
    Button testMainThreadConsuming;
    @BindView(R.id.test_mul_work_thread_block)
    Button testMulWorkThreadBlock;
    @BindView(R.id.test_file_io_wait)
    Button testFileIoWait;
    @BindView(R.id.test_network_io_wait)
    Button testNetWorkIoWait;
    @BindView(R.id.test_dump_hprof)
    Button testDumpHprof;
    private ArrayList<byte[]> mLeakyContainer = new ArrayList<>();
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

    @OnClick(R.id.test_main_thread_consuming)
    public void onTestMainThreadConsumingClicked() {
        int m = 0;
        Log.d(TAG, "onTestMainThreadConsumingClicked: m=" + m);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        while (true) {
            m++;
            if (m == -1) {
                break;
            }
        }
        Log.d(TAG, "onTestMainThreadConsumingClicked: m=" + m);
    }

    @OnClick(R.id.test_mul_work_thread_block)
    public void onTestMulWorkThreadBlockClicked() {
        for (int i = 0; i < 15; i++) {
            new Thread("chengjian_" + i) {
                @Override
                public void run() {
                    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                    int m = 0;
                    Log.d(TAG, "onTestMainThreadConsumingClicked: m=" + m);
                    while (true) {
                        m++;
                        if (m == -1) {
                            break;
                        }
                    }
                }
            }.start();
        }
    }

    int count = 0;

    @OnClick(R.id.test_file_io_wait)
    public void onTestFileIoWaitClicked() {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        count++;
                    }
                }
            }.start();
        }
        Log.d(TAG, "onTestFileIoWaitClicked: m=" + count);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i < 1; i++) {
            new Thread() {
                @Override
                public void run() {
//                try {
//                    Log.d(TAG, "dumpHprofData start");
//                    Debug.dumpHprofData(Environment.getExternalStorageDirectory() +
//                            "/dump" + ".dat");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Log.d(TAG, "dumpHprofData end");
                    final File removeFile = new File(Environment.getExternalStorageDirectory() +
                            "/c.test");
                    removeFile.delete();
                    final File file = new File(Environment.getExternalStorageDirectory() +
                            "/1.dat");
                    Log.d(TAG, "onTestIoWaitClicked file.exist=" + file.exists() + " file.path=" +
                            file.getPath());
                    final byte[] content = new byte[4096];
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
                        FileOutputStream fileOutputStream = new FileOutputStream(removeFile);
                        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                        int length = 0;
                        Log.d(TAG, "onTestIoWaitClicked start");
                        while ((length = bis.read(content, 0, content.length)) != -1) {
                            total += length;
                            bos.write(content);
                        }
                        Log.d(TAG, "onTestIoWaitClicked end result total=" + total);
                        bos.flush();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        bos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(TAG, "onTestIoWaitClicked e=" + e);
                    }
                }
            }.start();
        }
    }

    @OnClick(R.id.test_network_io_wait)
    public void onTestNetworkIoWaitClicked() {
        new Thread() {
            public void run() {
//                 String content = "";
//                 Log.d(TAG, "load before");
//                 try {
//                     content = loadAssets(MainActivity.this, "content.json");
//                 } catch (IOException e) {
//                     // TODO Auto-generated catch block
//                     e.printStackTrace();
//                 }
//                 Log.d(TAG, "load after");
//                 String result =
//                         HttpClientFactory.post("http://n.mark.letv.com/m3u8api/", content);
//                 Log.d(TAG, "post result=" + result);
                HttpURLConnection connection = null;
                InputStream is = null;
                try {
                    URL url = new URL(mUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    Log.d(TAG, "onCreate connection=" + connection);
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(2000);
                    connection.setInstanceFollowRedirects(false);
                    connection.setRequestMethod("GET");
                    // connection.setRequestProperty("content-type",
                    // "application/json; charset=utf-8");
//                    connection.setRequestProperty("Accept-Encoding", HTTP.UTF_8);
                    Log.d(TAG, "ResponseCode 11");
                    int ResponseCode = connection.getResponseCode();
                    Log.d(TAG, "ResponseCode=" + ResponseCode);
                    // 将要下载的文件写到保存在保存路径下的文件中
                    is = connection.getInputStream();
                    int fileSize = connection.getContentLength();
                    Log.d(TAG, "fileSize=" + fileSize);
                    byte[] buffer = new byte[1];
                    int length = -1;
                    final File removeFile = new File(Environment.getExternalStorageDirectory() +
                            "/c.test");
                    removeFile.delete();
                    FileOutputStream fo = new FileOutputStream(removeFile);
                    while ((length = is.read(buffer)) != -1) {
//                        Log.d(TAG, "download buffer =" + buffer + "length =" +
//                                length);
                        fo.write(buffer, 0, length);
                    }
                    Log.d(TAG, "msg=" + connection.getResponseMessage());
                    String encoding = System.getProperty("file.encoding",
                            "UTF-8");
//                    Log.d(TAG, "result=" + new String(buffer,"");
                    Log.d(TAG, "result11=" + encoding);
                    Log.d(TAG, "type=" + connection.getContentType());
                    Log.d(TAG, "getContentEncoding=" +
                            connection.getContentEncoding());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "download Exception =" + e);
                } finally {
                    try {
                        is.close();
                        connection.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }.start();
    }

    @OnClick(R.id.test_dump_hprof)
    public void onTestDumpHprof() {
        getAdId.dispatchWindowVisibilityChanged(0);
        Context context = null;
        try {
            context = createPackageContext("com.huawei.android.totemweather", 3);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Class totemweather = null;
        Class view = null;
        Class ViewGroup = null;
        Class remoteView = null;
        try {
            totemweather = context.getClassLoader().loadClass("com.huawei.android" +
                    ".totemweather" +
                    ".widget.WidgetHomeView");
            view = Class.forName("android.view.View");
            ViewGroup = Class.forName("android.view.ViewGroup");
            remoteView = Class.forName("android.view.ViewGroup");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onTestDumpHprof: totemweather=" + totemweather);
        try {
            Class name = Class.forName("android.os.Handler");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.huawei.android.totemweather", "com.huawei.android" +
                ".totemweather" +
                ".service.WeatherService");
        startService(intent);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Log.d(TAG, "dumpHprofData start");
//                    Debug.dumpHprofData(Environment.getExternalStorageDirectory() +
//                            "/dump" + ".dat");
//                    Log.d(TAG, "dumpHprofData end");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    class MessengerConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "MessengerConnection onServiceDisconnected =" + name);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Exception exception = new Exception("onServiceConnected");
            Log.d(TAG, "MessengerConnection onServiceConnected =" + name + " service=" +
                            service,
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
        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        Log.d(TAG, "onCreate: NUMBER_OF_CORES=" + NUMBER_OF_CORES);
//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // Take a request from the queue.
//                    System.out.println("hahhhhahh is=" + Thread.currentThread().isInterrupted());
//                    Thread.currentThread().sleep(3000);
//                    System.out.println("gggg ");
//                } catch (InterruptedException e) {
//                    // We may have been interrupted because it was time to quit.
//                    e.printStackTrace();
//                    Log.d(TAG, "run: ", e);
//                    System.out.println("e=" + e + "  isInterrupted= " + Thread.currentThread()
//                            .isInterrupted());
//                }
//            }
//        });
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
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
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo
                    (getPackageName
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
//        ANRMonitorManager.getInstance(this).startMonitor();
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                Log.d(TAG, "dfdfsddfsff");
//            }
//        });
//        new Thread(){
//            @Override
//            public void run() {
////                Log.d(TAG, "1111111");
//                Runtime.getRuntime().exit(0);
//            }
//        }.start();
//        new Thread(){
//            @Override
//            public void run() {
//                Log.d(TAG, "1111111");
//                Runtime.getRuntime().exit(0);
//            }
//        }.start();
        final Thread.UncaughtExceptionHandler oldHandler = Thread
                .getDefaultUncaughtExceptionHandler();
        Log.d(TAG, "sadasds =" + Looper.getMainLooper().getThread().getState());
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(final Thread thread, final Throwable ex) {
//                Log.d(TAG, "1111111 thread=" + thread + " ex=" + ex);
//                Log.d(TAG, "22222 fdsfd=" + Looper.getMainLooper().getThread().getState());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////                oldHandler.uncaughtException(thread, ex);
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "22222 =" + Looper.getMainLooper().getThread().getState());
//                        try {
////                            Thread.sleep(3000);
//                            Log.d(TAG, "aaaaaaaaa");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        new Thread() {
//                            @Override
//                            public void run() {
//                                Log.d(TAG, "3333333");
//                            }
//                        }.start();
//                        Log.d(TAG, "444444");
//                    }
//                }.start();
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "55555");
//                        oldHandler.uncaughtException(thread, ex);
//                    }
//                }.start();
//                Log.d(TAG, "66666");

//            }
//        });
//        Log.d(TAG, "fdsffsdf");
//        new Thread() {
//            @Override
//            public void run() {
//                Log.d(TAG, "before aaaa this=" + this);
//                test(null);
//                Log.d(TAG, "after aaaa this=" + this);
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//        testCrash();
//        for (int i = 0; i < 20; i++) {
//            HandlerThread handlerThread = new HandlerThread("ffff") {
//                @Override
//                public void run() {
//                    while (true) ;
//                }
//            };
//            handlerThread.start();
//        }
//        while(true){
//
//        }
//            }
//        }.start();
//        Log.d(TAG, "aaaa");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    }

    int i = 0;
    private PowerManager.WakeLock wakeLock;

    private void test(File file) {
        Log.d(TAG, "test: file=" + file.exists());
    }

    private void testCrash() {
        String ss = "fff";
        Integer.valueOf(ss);
    }

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
        mLeakyContainer.clear();
//        Intent intent = new Intent(ACTION);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//        sendBroadcast(intent);
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

    int ii = 0;
    int b = 0;
    int c = 0;
    int[] aa;
    String[] bb;

    public void onStartFgServiceClicked(long a, long b, long c) {
        ii++;
        if (ii > 7500) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        onStartFgServiceClicked(a, b, c);
    }

    long total;

    private void allocMemory() {
        byte[] b = new byte[2 * 1000 * 1000];
        mLeakyContainer.add(b);
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        int largeMemoryClass = activityManager.getLargeMemoryClass();
        int memoryClass = activityManager.getMemoryClass();

        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);

        Log.d(TAG, "largeMemoryClass = " + largeMemoryClass);
        Log.d(TAG, "memoryClass = " + memoryClass / 1024 / 1024 + "   availMem=" + info.availMem
                / 1024 / 1024 + " totalMem="
                + info.totalMem / 1024 / 1024 + " threshold=" + info.threshold / 1024 / 1024 + " " +
                " freeMemory=" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " " +
                "totalMemory=" + Runtime
                .getRuntime().totalMemory() / 1024 / 1024 + " max=" + Runtime.getRuntime()
                .maxMemory());
    }

    @OnClick(R.id.start_fg_service)
    public void onStartFgServiceClicked() {
//        allocMemory();
        Log.d(TAG, "onStartFgServiceClicked start");
        final File file = new File(Environment.getExternalStorageDirectory() + "/1.dat");
        Log.d(TAG, "onStartFgServiceClicked start exist=" + file.exists());
//        Executors.newScheduledThreadPool()
        final byte[] conent = new byte[1];
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
////                        Class ProcessCpuTracker = Class.forName("com.android.internal.os" +
////                                ".ProcessCpuTracker");
//////                        Constructor<?>[] constructors = ProcessCpuTracker
//////                                .getDeclaredConstructors();
//////                        for (Constructor name : constructors) {
//////                            Log.d(TAG, "run: name=" + name);
//////                        }
////                        Constructor constructor = ProcessCpuTracker.getConstructor(boolean
/// .class);
////                        Object object = constructor.newInstance(true);
////                        Method method = ProcessCpuTracker.getDeclaredMethod("printCurrentState",
////                                long
////                                        .class);
////                        Method method1 = ProcessCpuTracker.getDeclaredMethod("update");
////                        method.setAccessible(true);
////                        method1.setAccessible(true);
////                        method1.invoke(object);
////                        Thread.sleep(3000);
////                        String body = (String) method.invoke(object, SystemClock.uptimeMillis
/// ());
////                        Log.d(TAG, "run: body=" + body);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "run: eeeeeee=" + e);
//                }
//            }
//        }.start();
//        for (int i = 0; i < 3; i++) {
//            new Thread() {
//                @Override
//                public void run() {
////                    try {
////                        Log.d(TAG, "dumpHprofData start");
////                        Debug.dumpHprofData(Environment.getExternalStorageDirectory() +
/// "/dump" +
////                                    ".dat");
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                    Log.d(TAG, "dumpHprofData end");
//                    try {
//                        FileInputStream fileInputStream = new FileInputStream(file);
//                        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
//                        FileOutputStream fileOutputStream = new FileOutputStream(Environment
//                                .getExternalStorageDirectory() + "/c.test");
//                        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
//                        int length = 0;
//                        while ((length = bis.read(conent, 0, conent.length)) != -1) {
//                            total += length;
//                            bos.write(conent);
//                        }
//                        Log.d(TAG, "onStartFgServiceClicked end result total=" + total);
//                        bos.flush();
////            fileOutputStream.flush();
////            fileOutputStream.close();
//                        bos.close();
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.d(TAG, "onStartFgServiceClicked e=" + e);
//                    }
//                }
//            }.start();
//        }

//        boolean result = file.renameTo(new File(Environment.getExternalStorageDirectory() + "/b" +
//                ".test"));
//        onStartFgServiceClicked(1,2,3);
//        aa = new int[40000000];
//                                bb = new String[4000000];
//                                aa = new int[4000000];
//                                bb = new String[4000000];
//                                for (int b = 0; b < aa.length; b++) {
//                                    aa[b] = b;
//                                }
//                                Log.d(TAG, "aa=" + aa);
//                                dArray[i].clear();
//        while (true){
//            int a = 1;
//            int b0 = 2;
//            int b1 = 2;
//            int b2 = 2;
//            int b3 = 2;
//            int b4 = 2;
//            int b5 = a + b0 + b1+b2+b3+b4;
//        }

//        Log.d(TAG, "onStartFgServiceClicked: b5=" + b5);
//        ii++;
////        c++;
//        if (ii > 7000) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
//        onStartFgServiceClicked();

//        for (int i = 0; i < 1950; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    synchronized (mLockObject) {
//                        try {
////                            long a = 1;
////                            long b0 = 2;
////                            long b1 = 2;
////                            long b2 = 2;
////                            long b3 = 2;
////                            long b4 = 2;
////                            long b5 = a + b0 + b1+b2+b3+b4;
////                            Log.d(TAG, "onStartFgServiceClicked: b5=" + b5);
//                            mLockObject.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//            }.start();
//        }
//        new Thread() {
//            @Override
//            public void run() {
//                long time = System.currentTimeMillis();
//                Log.d(TAG, "fffffffff time=" + time);
//                while (true) {
//                    if ((System.currentTimeMillis() - time) > 30000) {
////                        readlog("");
//                        List<ProcessErrorStateInfo> processErrorStateInfos = activityManager
//                                .getProcessesInErrorState();
//                        Log.d(TAG, "run: processErrorStateInfo=" + processErrorStateInfos);
//                        if (null == processErrorStateInfos) {
//                            return;
//                        }
//                        for (ProcessErrorStateInfo processErrorStateInfo :
// processErrorStateInfos) {
//                            Log.d(TAG, "onCreate: processName=" + processErrorStateInfo
//                                    .processName +
//                                    " " +
//                                    "msg=" +
//                                    processErrorStateInfo.longMsg + "  shortMsg=" +
//                                    processErrorStateInfo
//                                            .shortMsg + " stackTrace" + processErrorStateInfo
//                                    .stackTrace + " " +
//                                    " " +
//                                    "condition=" +
//                                    processErrorStateInfo.condition);
//                        }
//                        break;
//                    }
//
//                }
//            }
//        }.start();
//        Log.d(TAG, "onStartFgServiceClicked: ");
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        mHandler.sendEmptyMessageDelayed(1, 3000);
        Intent intent = new Intent(this, MyService
                .class);
        intent.putExtra("abc", "cj");
        startService(intent);
    }


    @OnClick(R.id.job_Service)
    public void onJobServiceClicked() {
        Log.d(TAG, "onJobServiceClicked");
        for (int i = 0; i < 5; i++) {
            Thread handlerThread = new Thread("name i=" + i) {
                @Override
                public void run() {
                    setPriority(Thread.MAX_PRIORITY);
                    while (true) {

                    }
                }
            };
            handlerThread.start();
        }
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
//        Intent intent = new Intent(this, MyService.class);
//        intent.putExtra("abc", "cj");
//        startService(intent);
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
//                        Log.d(TAG, "onGetAdidClicked: pid=" + Process.myPid() + " " +
//                                "tid=" + Thread.currentThread().getId() + " calllingpId=" +
//                                Binder
//                                        .getCallingPid());
                        iTestbinder.getAdId("aaa");
//                        Log.d(TAG, "onGetAdidClicked: end");
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
