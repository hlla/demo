package letv.com.testanr;

import android.Manifest.permission;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
//import example.com.testlib.BuildConfig;
//import example.com.testlib.TestLib;
import letv.com.testanr.reflect.FieldUtils;
import letv.com.testanr.reflect.MethodUtils;

import static android.content.pm.PackageManager.GET_META_DATA;
import static android.content.pm.PackageManager.GET_SHARED_LIBRARY_FILES;


public class MyActivity extends Activity implements ActivityCompat
        .OnRequestPermissionsResultCallback {
    private static final String TAG = "Testanr_MyActivity";
    public static final String ACTION = "android.intent.action.mystaticreceiver";
    public static final String ACTION_DYNAMIC = "android.intent.action.mydynamicreceiver";
    public static final String mUrl = "http://10.60.214.2:8080/test_big_file.zip";
    private static final int STATIC_BROADCAST = 10;
    @BindView(R.id.start_fg_service)
    Button startFgService;
    @BindView(R.id.stop_fg_service)
    Button stopFgService;
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
    @BindView(R.id.test_notification)
    Button testNotification;
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
    private String content = "{\n" +
            "\t\t\"sceneID\": 1,\n" +
            "\t\t\"updatetime\": 1542680153,\n" +
            "\t\t\"configStr\": [\n" +
            "\t\t\t\"{\\\"coolingtime\\\": \\\"1542680153\\\",\\\"starttime\\\": " +
            "\\\"1542680153\\\"}\",\n" +
            "\t\t\t\"{\\\"coolingtime\\\": \\\"8888\\\",\\\"starttime\\\": \\\"222222\\\"}\"\n" +
            "\t\t],\n" +
            "\t\t\"datas\": [{\n" +
            "\t\t\t\t\"id\": 1,\n" +
            "\t\t\t\t\"title\": \"sky\",\n" +
            "\t\t\t\t\"type\": 0,\n" +
            "\t\t\t\t\"plaqueAdID\": \"\",\n" +
            "\t\t\t\t\"videoAdID\": \"\",\n" +
            "\t\t\t\t\"jumpurl\": \"http://wwww.xxxx.com\",\n" +
            "\t\t\t\t\"intentAction\": \"\",\n" +
            "\t\t\t\t\"desc\": \"hahhha\",\n" +
            "\t\t\t\t\"thumburl\": [\n" +
            "\t\t\t\t\t\"http://img.xxx.net\",\n" +
            "\t\t\t\t\t\"http://img.xxx.net\"\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"coverurl\": [\n" +
            "\t\t\t\t\t\"http://img.xxx.net\",\n" +
            "\t\t\t\t\t\"http://img.xxx.net\"\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"pkgname\": \"com.test.xxx\",\n" +
            "\t\t\t\t\"subposid\": \"\",\n" +
            "\t\t\t\t\"weight\": 200,\n" +
            "\t\t\t\t\"extendStr\": \"{\\\"key1\\\": \\\"value\\\",\\\"key2\\\": " +
            "\\\"value\\\"}\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"id\": 1,\n" +
            "\t\t\t\t\"title\": \"sky\",\n" +
            "\t\t\t\t\"type\": 0,\n" +
            "\t\t\t\t\"plaqueAdID\": \"\",\n" +
            "\t\t\t\t\"videoAdID\": \"\",\n" +
            "\t\t\t\t\"jumpurl\": \"http://wwww.xxxx.com\",\n" +
            "\t\t\t\t\"intentAction\": \"\",\n" +
            "\t\t\t\t\"coverurl\": [\n" +
            "\t\t\t\t\t\"http://img.xxx.net\",\n" +
            "\t\t\t\t\t\"http://img.xxx.net\"\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"pkgname\": \"com.test.xxx\",\n" +
            "\t\t\t\t\"subposid\": \"\",\n" +
            "\t\t\t\t\"weight\": 200,\n" +
            "\t\t\t\t\"extendStr\": \"{\\\"key1\\\": \\\"value\\\",\\\"key2\\\": " +
            "\\\"value\\\"}\"\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}";
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            Log.d(TAG, "handleMessage: what=" + msg.what);
            int what = msg.what;
            switch (what) {
                case 100: {
                    try {
                        Thread.sleep(30 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
//            Log.d(TAG, "after handleMessage: " + BuildConfig.IS_PERFORMANCE);
//            switch (what) {
//                case STATIC_BROADCAST: {
//                    Intent intent = new Intent(ACTION);
//                    intent.setPackage(getPackageName());
//                    sendBroadcast(intent);
////                    Intent intent1 = new Intent(MyActivity.this, MyService.class);
////                    intent1.putExtra("abc", "cj");
////                    MyActivity.this.startService(intent1);
//                    break;
//                }
//            }
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int what = msg.what;
//            switch (what) {
//                case 1: {
//                    PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
//                    wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager
//                                    .ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE,
//                            "WakeAndLock");
////                    wakeLock = ((PowerManager) getSystemService(Context.POWER_SERVICE))
//// .newWakeLock(PARTIAL_WAKE_LOCK, "cpu_lck");
////                    wakeLock = pm.newWakeLock(PARTIAL_WAKE_LOCK, "WakeAndLock");
//                    Log.d(TAG, "handleMessage what-" + msg.what + " wakeLock=" + wakeLock
// .isHeld());
//                    wakeLock.acquire();
////                    wakeLock.acquire();
////                    wakeLock.acquire();
//                    break;
//                }
//                case 2: {
//                    if (null != wakeLock) {
//                        Log.d(TAG, "handleMessage what-" + msg.what + " wakeLock=" + wakeLock
//                                .isHeld());
//                        if (wakeLock.isHeld()) {
//                            wakeLock.release();
//                        }
//                    }
//                    break;
//                }
//            }

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
        //todo 测试代码
        int a = 10;
        b = 10;
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
//        getAdId.dispatchWindowVisibilityChanged(0);
        Context context = null;
//        try {
//            context = createPackageContext("com.huawei.android.totemweather", 3);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
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
//            Exception exception = new Exception("onServiceConnected");
//
//            Log.d(TAG, "onServiceConnected =" + name + " service=" + service, exception);
//            iTestbinder = ITestbinder.Stub.asInterface(service);
//            Log.d(TAG, "onServiceConnected =" + name + " service=" + service + " iTestbinder=" +
//                    iTestbinder);
//            try {
////                Trace.beginSection();
//                iTestbinder.asBinder().linkToDeath(new IBinder.DeathRecipient() {
//                    @Override
//                    public void binderDied() {
//                        Log.d(TAG, "binderDied tNanme=" + Thread.currentThread().getName());
//                    }
//                }, 0);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
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

//    public static class CustomInstrumentation extends Instrumentation {
//        private Instrumentation base;
//
//        public CustomInstrumentation(Instrumentation base) {
//            this.base = base;
//        }
//
//        public Instrumentation.ActivityResult execStartActivity(Context who, IBinder
//                contextThread, IBinder token, Activity target, Intent intent, int requestCode,
//                                                                Bundle options) {
//            return super.execStartActivity(who, contextThread, token, target, intent,
//                    requestCode, options);
//        }
//    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        GameCenterBean gameCenterBean = new GameCenterBean();
//        gameCenterBean.setLeftData(null);
//        gameCenterBean.setRightData(null);
//        Log.d(TAG, "onCreate: " + gameCenterBean.getRightData().intern());
//        boolean isShould = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest
//                .permission.READ_EXTERNAL_STORAGE);
//        Log.d(TAG, "onCreate: isShould=" + isShould);
//        PermissionUtils.getExternalStoragePermissions(this, 11);
        PermissionUtils.requestPerssions(this, 1, permission.READ_EXTERNAL_STORAGE, permission
                .WRITE_EXTERNAL_STORAGE, permission
                .READ_PHONE_STATE);
//        TestAA testAA = new TestAA();
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(this);
//        arrayList.add(testAA);
//        testAA.aa(testAA, this);
//        testAA.aa(this, new Intent());
        Log.d(TAG, "onCreate: pkg=" + getPackageName());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager
                .LayoutParams.FLAG_KEEP_SCREEN_ON);
        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        String name = SystemProperties.get("name");
        final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String mcc_mnc = tm.getSimOperator();
        Log.d(TAG, "onCreate: NUMBER_OF_CORES=" + NUMBER_OF_CORES + " name=" + name + " mcc_mnc="
                + mcc_mnc);
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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
        ButterKnife.bind(this);
        int resId = getResources().getIdentifier(getString(R.string.test_dump_hprof_4), "drawable",
                getPackageName());
//        startBgService.setBackground(getDrawable(resId));
        Intent intent = new Intent(ACTION);
        Log.d(TAG, "Testanr_MySR onCreate: ");
        StringBuilder ddd = new StringBuilder("sssss");
        Log.d(TAG, ddd.toString());
        Log.d(TAG, "ddddd" + getResources());
        Log.d(TAG, "" + getResources());
        ddd = null;
//        ApplicationInfo appInfo = this.getPackageManager()
//                .getApplicationInfo(getPackageName(),
//                        PackageManager.GET_META_DATA);
//        String mTag = appInfo.metaData.getString("mTag");

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
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.d(TAG, "uncaughtException =" + t + " e=" + e + " t=" + t.getId() + " Thread="
                        + Thread.currentThread() + " tid=" + t.getId());
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
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
//        IntentFilter intentFilter1 = new IntentFilter(ACTION);
//        registerReceiver(new MyStaticReceiverA(), intentFilter1);
        allocMemory();
//        View view = findViewById(R.id.bind_service_dddd);
//        testSchool.setOnClickListener(v -> Log.d(TAG, "onClick: 1111"));
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: ");
//            }
//        });
//        final View.OnClickListener clickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: clickListener=" + clickListener);
//            }
//        };
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
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
//        PermissionUtils.requestPerssions(this, 2, permission.READ_CALENDAR);
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
        Exception e = new Exception("onBackPressed");
        Log.d(TAG, "onBackPressed: ", e);
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
                .maxMemory() / 1024 / 1024);
    }

    @OnClick(R.id.stop_fg_service)
    public void onStopFgServiceClicked() {
        Intent intent = new Intent(this, MyService
                .class);
        stopService(intent);
    }

    @OnClick(R.id.start_fg_service)
    public void onStartFgServiceClicked() {
        Intent intent1 = new Intent(MyActivity.this, MyService.class);
        intent1.putExtra("abc", "cj");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startForegroundService(intent1);
//                startService(intent1);
//                startService(intent1);
//                onStopFgServiceClicked();
//                startService(intent1);
//                stopService(intent);
            }
            //            @Override
//            public void run() {
//                Log.d(TAG, "run: isni=" + MyActivity.this.isFinishing());
//                windowManager.addView(view, params);
//            }
        }, 0 * 1000);
        File file = new File(Environment.getExternalStorageDirectory() + "/test.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int len = inputStream.available();
            if (len <= 0)
                return;

            byte[] buffer = new byte[len];
            inputStream.read(buffer);

            String str = new String(buffer);
            Gson gson = new Gson();
            TestBean bean = gson.fromJson(str, TestBean.class);
//            ArrayList<ArrayMap<String, String>> configs = new ArrayList<ArrayMap<String,
//                    String>>();
            if (!TextUtils.isEmpty(bean.getConfigStr())) {
                Gson gson1 = new Gson();
                bean.config = gson1.fromJson(bean.getConfigStr(), ArrayMap.class);
            }
//            JSONObject rootJsonObj = new JSONObject(str);
            Log.d(TAG, "onCreate: bean=" + bean);
//            Gson gson2 = new Gson();
//            ArrayList aa = gson2.fromJson(rootJsonObj.getJSONArray("configStr").toString(),
//                    configs.getClass());

            Log.d(TAG, "onCreate: aa=" + aa);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "onCreate: e=" + e);
        }
//        allocMemory();
        Log.d(TAG, "onStartFgServiceClicked start");
        final File file1 = new File(Environment.getExternalStorageDirectory() + "/1.dat");
        Log.d(TAG, "onStartFgServiceClicked start exist=" + file1.exists());
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
//            int b5 = a + b0 + bregisterReceiver1+b2+b3+b4;
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
        num++;
//        intent.putExtra(MyService.KEY_IS_CONTENT, "cj" + num);
//        intent.putExtra(MyService.KEY_IS_FOREGROUND, true);
//        startForegroundService(intent);
    }

    private int num = 0;

    @OnClick(R.id.job_Service)
    public void onJobServiceClicked() {
        Log.d(TAG, "onJobServiceClicked");
        Thread thread = new Thread() {
            @Override
            public void run() {
                Log.d(TAG, "work thread start");
                synchronized (MyActivity.this) {
                    Log.d(TAG, "work thread start 1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String a = null;
                    a.getBytes();
                    Log.d(TAG, "work thread end");
                }
            }
        };
        Log.d(TAG, "onJobServiceClicked thread =" + thread.getId() + " current.tid=" + Thread
                .currentThread().getId());
//        String a = null;
//        a.getBytes();
        thread.setName("abc");
        thread.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "sleep after");
//        synchronized (this) {
//            Log.d(TAG, "main thread run");
//        }
//        for (int i = 0; i < 5; i++) {
//            Thread handlerThread = new Thread("name i=" + i) {
//                @Override
//                public void run() {
//                    setPriority(Thread.MAX_PRIORITY);
//                    while (true) {
//
//                    }
//                }
//            };
//            handlerThread.start();
//        }
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
        HandlerThread handlerThread = new HandlerThread("fsdf");
        handlerThread.start();
        String dd = SystemProperties.get("dgg");
        final Handler handler = new Handler(handlerThread.getLooper());
        Log.d(TAG, "onStartBgServiceClicked: ");
//        new Thread("ddddddd") {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "onStartFgServiceClicked: start");
//                        for (int i = 0; i < 10000000; i++) {
//                            mHandler.sendEmptyMessage(0);
//                        }
//                        Log.d(TAG, "onStartFgServiceClicked: end");
//                    }
//                });
//            }
//        }.start();

//        new Thread(){
//            @Override
//            public void run() {
//                Log.d(TAG, "onStartFgServiceClicked: sssssss");
//                onStartFgBroadcastClicked();
//            }
//        }.start();

//        new Thread() {
//            @Override
//            public void run() {
//                Log.d(TAG, "run: start");
//                for (int i = 0; i < 100; i++) {
//                    mHandler.sendEmptyMessage(0);
//                }
//                Log.d(TAG, "run: end");
//                onStartFgBroadcastClicked();
////                mHandler.sendEmptyMessage(111);
//            }
//        }.start();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
        Log.d(TAG, "run: startService");
        Intent intent = new Intent(MyActivity.this, MyService.class);
        intent.putExtra("abc", "cj");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startService(intent);
//                stopService(intent);
            }
            //            @Override
//            public void run() {
//                Log.d(TAG, "run: isni=" + MyActivity.this.isFinishing());
//                windowManager.addView(view, params);
//            }
        }, 1);
//        bindService(intent, connection, BIND_AUTO_CREATE);
//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//            }
//        }, 5000);
    }

    public void pollServer() {
//        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        for (int i = 0; i < 40; i++) {
//            JobInfo jobInfo = new JobInfo.Builder(i, new ComponentName(getPackageName(),
//                    MyJobService.class.getName()))
//                    .setMinimumLatency(1000) // 5 seconds
////                    .setOverrideDeadline(10000) // 60 seconds (for brevity in the sample)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) // WiFi or data connections
//                    .build();
//            scheduler.schedule(jobInfo);
//        }
    }

    @OnClick(R.id.bind_service)
    public void onBindServiceClicked() {
        Resources d = null;
//        d.getString(R.string.FACEBOOK_APP_ID);
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("abc", "cj");
        intent.putExtra("pid", Process.myPid());
        boolean result = bindService(intent, connection, BIND_AUTO_CREATE);
        mHandler.sendEmptyMessage(11111);
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
//        intent.setPackage("letv.com.testanr11");
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent);
    }

    @OnClick(R.id.start_bg_broadcast)
    public void onStartBgBroadcastClicked() {
        Intent intent = new Intent(ACTION_DYNAMIC);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//        sendOrderedBroadcast(intent, null);
    }

    @OnClick(R.id.start_static_broadcast)
    public void onStartStaticBroadcast() {
//        mHandler.sendEmptyMessageDelayed(STATIC_BROADCAST, 70000);
        Intent intent = new Intent(ACTION);
        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        intent.setPackage(getPackageName());
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

    @OnClick(R.id.test_array)
    public void onTestArrayClicked() {
        if (null != iTestbinder) {
            Log.d(TAG, "onTestArrayClicked: pid=" + Process.myPid() + " " +
                    "tid=" + Thread.currentThread().getId() + " calllingpId=" +
                    Binder
                            .getCallingPid());
            try {
                iTestbinder.testArray(new School());
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.d(TAG, "onTestArrayClicked: e=" + e);
            }
            Log.d(TAG, "onTestArrayClicked: end");
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
//        Intent intent = new Intent(this, LoadingActivity.class);
//        intent.putExtra("abc", "cj");
//        startActivity(intent);
        try {
            File f = new File("/sdcard/_test_file_.txt");
            FileInputStream fileInputStream = new FileInputStream(f);
            fileInputStream.read();
            Log.d(TAG, "onLaunchLoadingClicked: " + f.exists());
        } catch (Exception e) {
            Log.d(TAG, "onLaunchLoadingClicked: e=" + e);
        }
    }

    @OnClick(R.id.test_handler_anr)
    public void onTestHandlerAnrClicked() {
//        new TestLib().test();
        Log.d(TAG, "onTestHandlerAnrClicked: 11");
        Message message = Message.obtain();
        final Object object = new Object();
        for (int i = 0; i < 5; i++) {
            new Thread("name" + i) {
                @Override
                public void run() {
//                    for (int i = 0; i < 2; i++) {
//                        synchronized (object) {
//                            try {
//                                object.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        mHandler.sendMessage(message);
                    } catch (Exception e) {
                    }
//                    }
                }
            }.start();
        }
        mHandler.sendEmptyMessage(100);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (object) {
//            object.notifyAll();
//        }
//        for (int i = 0; i < 100; i++) {
////            try {
////                Thread.sleep(1);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            try {
//                mHandler.sendMessage(message);
//            } catch (Exception e) {
//            }
//        }
//        mHandler.sendEmptyMessageDelayed(0, 1000);
        Log.d(TAG, "onTestHandlerAnrClicked: 22");
    }

    @OnClick(R.id.test_notification)
    public void onTestNotificationClicked() {
        Log.d(TAG, "onTestHandlerAnrClicked: 11");
        Intent intent = new Intent(this, MyRemoteActivity.class);
        startActivity(intent);
//        mHandler.sendEmptyMessageDelayed(0, 1000);
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setContentText("this is Content");
//        builder.setContentTitle("this is Content title");
////        builder.setPriority(Notification.);
////        builder.setTicker("this is ticker");
//        builder.setSmallIcon(R.drawable.ic_launcher);
//        builder.setPriority(Notification.PRIORITY_MAX);
//        final NotificationManager nm = (NotificationManager) this
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            //只在Android O之上需要渠道
//            NotificationChannel notificationChannel = new NotificationChannel("sdfdsfd",
//                    "dd", NotificationManager.IMPORTANCE_DEFAULT);
//            builder.setChannelId("sdfdsfd");
//            notificationChannel.setDescription("this is test");
//            notificationChannel.setSound(null, null);
//            notificationChannel.enableVibration(true);
//            notificationChannel.setLightColor(Color.RED);
//            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，
//            //通知才能正常弹出
//            nm.createNotificationChannel(notificationChannel);
//        }
////        builder.build().defaults |= Notification.DEFAULT_VIBRATE;
////        builder.build().defaults |= Notification.DEFAULT_SOUND;
////        builder.build().defaults |= Notification.DEFAULT_LIGHTS;
//        // 显示通知
////        nm.notify(1, builder.build());
//        final WindowManager windowManager = (WindowManager) this.getApplicationContext()
//                .getSystemService(Context
//                        .WINDOW_SERVICE);
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = -1;
//        final TextView view = new TextView(this);
//        view.setText("SYSTEM");
//        view.setBackgroundColor(Color.BLUE);
//        params.width = 1800;
//        params.height = 1800;
//        params.gravity = Gravity.CENTER_HORIZONTAL;
//        params.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
//                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
//                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
////        finish();
////        if (!Settings.canDrawOverlays(this)) {
////            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
////            intent.setData(Uri.parse("package:" + getPackageName()));
////            startActivityForResult(intent, 100);
////            return;
////        }
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d(TAG, "run: isni=" + MyActivity.this.isFinishing());
//                windowManager.addView(view, params);
//            }
//        }, 1000);
    }


    @OnClick(R.id.test_anr)
    public void onTestAnrClicked() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Log.e(TAG, "onTestAnrClicked: windowManager=" + windowManager);
        WindowManager.LayoutParams params1 = new WindowManager.LayoutParams();
        TextView view1 = new TextView(this);
        params1.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        params1.type = WindowManager.LayoutParams.TYPE_TOAST;
        params1.width = 500;
        params1.height = 500;
        params1.gravity = Gravity.CENTER_HORIZONTAL;
        view1.setText("Phone");
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: dsfdfdff");
            }
        });
        view1.setBackgroundColor(Color.YELLOW);
        windowManager.addView(view1, params1);
//        mHandler.sendEmptyMessage(0);
//        new Thread() {
//            @Override
//            public void run() {
//                long time = System.currentTimeMillis();
//                while (true) {
//                    try {
//                        Thread.currentThread().sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.d(TAG, "anr anr anr");
//                }
//            }
//        }.start();
//        try {
//            Thread.currentThread().sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        Log.d(TAG, "onWindowAttributesChanged: params=" + params);
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
//        Log.d(TAG, "onRequestPermissionsResult: requestCode=" + requestCode + " dg=" +
//                PermissionUtils.hasPermissons(this, permission.WRITE_EXTERNAL_STORAGE));
//        if (!PermissionUtils.hasPermissons(this, permission.WRITE_EXTERNAL_STORAGE)) {
//            PermissionUtils.requestPerssions(this, 5, permission
//                    .WRITE_EXTERNAL_STORAGE);
//        }
//        int i = 0;
//        for (String str : permissions) {
//            Log.d(TAG, "onRequestPermissionsResult: str=" + str + " grantResults=" +
//                    grantResults[i]);
//            i++;
//        }
    }
}
