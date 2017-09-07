package letv.com.testanr;

import android.app.Activity;
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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Method;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import letv.com.testanr.reflect.FieldUtils;
import letv.com.testanr.reflect.MethodUtils;

import static android.content.pm.PackageManager.GET_META_DATA;
import static android.content.pm.PackageManager.GET_SHARED_LIBRARY_FILES;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static letv.com.testanr.R.drawable.a;

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
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage what-" + msg.what);
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,
                    "DPA");

            wakeLock.acquire();
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
        public void showTYResult(String result) throws RemoteException {
            Log.d(MyActivity.TAG, "showTYResult result=" + result + " CallingPid=" + Binder
                    .getCallingPid() + " CallingUid=" + Binder.getCallingUid());
            String test = null;
            //twoway  被调用方有异常(比如空指针)发生崩溃,但是崩溃发生在调用进程
//            at android.os.Parcel.readException(Parcel.java:1626)
//            at android.os.Parcel.readException(Parcel.java:1573)
//            at letv.com.testanr.ICallback$Stub$Proxy.showTYResult(ICallback.java:112)
            Log.d(MyActivity.TAG, "showTYResult error" + test.toString());
        }

        @Override
        public void showOWResult(String result) throws RemoteException {
            Log.d(MyActivity.TAG, "showOWResult result=" + result + " CallingPid=" + Binder
                    .getCallingPid() + " CallingUid=" + Binder.getCallingUid());
            String test = null;
            //oneway  被调用方有异常(比如空指针)不会发生崩溃
            Log.d(MyActivity.TAG, "showOWResult error" + test.toString());
        }
    };

    class MessengerConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "MessengerConnection onServiceDisconnected =" + name);
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "MessengerConnection onServiceConnected =" + name + " service=" + service);
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
            Log.d(TAG, "onServiceConnected =" + name + " service=" + service);
            iTestbinder = ITestbinder.Stub.asInterface(service);
            Log.d(TAG, "onServiceConnected =" + name + " service=" + service + " iTestbinder=" +
                    iTestbinder);
            try {
//                iTestbinder.testSchool(null);
//                iTestbinder.testCall(null);
                iTestbinder.asBinder().linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        Log.d(TAG, "binderDied tNanme=" + Thread.currentThread().getName());
                    }
                }, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.d(TAG, "test ddddd=" + e);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Process.setThreadPriority(Process.THREAD_PRIORITY_LOWEST);
        setContentView(R.layout.activity_main);
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
            Log.d(TAG, "onCreate: applicationInfo.sourceDir=" + applicationInfo.sourceDir + " " +
                    "sharedLibraryFiles=" + applicationInfo.sharedLibraryFiles + " " +
                    "splitSourceDirs=" + applicationInfo.splitSourceDirs + " " +
                    "mDataDir=" + applicationInfo.dataDir + " nativeLibraryDir=" +
                    applicationInfo.nativeLibraryDir);
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
        long tPriority = Thread.currentThread().getPriority();
        int pPriority = Process.getThreadPriority(Process.myTid());
        Log.d(TAG, "onCreate: tPriority=" + tPriority + " pPriority=" + pPriority);
//        for (int i = 0; i < 200; i++) {
        new Thread() {
            @Override
            public void run() {
//                while (true) {
//                }
                Process.setThreadPriority(Process.THREAD_PRIORITY_LOWEST);
                long tPriority = Thread.currentThread().getPriority();
                int pPriority = Process.getThreadPriority(Process.myTid());
                Log.d(TAG, "onCreate: work thread 1 tPriority=" + tPriority + " pPriority=" +
                        pPriority);
                for (int a = 0; a < 40000000; a++) {
                    m += a;
                }
                Log.d(TAG, "Thread 1 dne m=" + m);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
//                while (true) {
//                }
                long tPriority = Thread.currentThread().getPriority();
                int pPriority = Process.getThreadPriority(Process.myTid());
                Log.d(TAG, "onCreate: work thread 2 tPriority=" + tPriority + " pPriority=" +
                        pPriority);
                for (int a = 0; a < 40000000; a++) {
                    n += a;
                }
                Log.d(TAG, "Thread 2 dne n=" + n);
            }
        }.start();
        for (int a = 0; a < 40000000; a++) {
            p += a;
        }
        Log.d(TAG, "main dne p=" + p);
//        }
    }

    int i;
    long m, n,p;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,
                "DPA");

        wakeLock.acquire();
        mHandler.sendEmptyMessageDelayed(0, 3000);
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
        if (wakeLock != null) {
            wakeLock.release();
        }
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
        Process.killProcess(android.os.Process.myPid());
        try {
            Method method = Process.class.getDeclaredMethod("killProcessGroup", Integer.class,
                    Integer.class);
            method.invoke(null, Process.myUid(), Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "onDestroy: e=" + e);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
        finish();
    }

    @OnClick(R.id.start_fg_service)
    public void onStartFgServiceClicked() {
        Log.d(TAG, "onStartFgServiceClicked: ");
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("abc", "cj");
        startService(intent);
    }

    @OnClick(R.id.start_bg_service)
    public void onStartBgServiceClicked() {
        Log.d(TAG, "onStartFgServiceClicked: ");
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("abc", "cj");
        startService(intent);
    }

    @OnClick(R.id.job_Service)
    public void onJobServiceClicked() {
        Log.d(TAG, "onJobServiceClicked");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pollServer();
        }
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
        bindService(intent, connection, BIND_AUTO_CREATE);
        Intent intent1 = new Intent(this, MessengerService.class);
        intent1.putExtra("abc", "cj");
        bindService(intent1, messengerConnection, BIND_AUTO_CREATE);
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
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//        sendOrderedBroadcast(intent, null);
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
        try {
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
