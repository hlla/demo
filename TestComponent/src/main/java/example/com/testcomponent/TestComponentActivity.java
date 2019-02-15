package example.com.testcomponent;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.testcomponent.statics.TestStaticA;
import example.com.testcomponent.statics.TestStaticD;

//import android.os.SystemProperties;

public class TestComponentActivity extends Activity {
    private static class SingletonHolder {
        private static final TestComponentActivity INSTANCE = new TestComponentActivity();
    }

    private TestComponentActivity() {
    }

    public static final TestComponentActivity getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final int MSG_TIMER = 1;
    private static final String TAG = "TestComponent1_Activity";
    public static final String MAIN_PROCESS_ACTION = "android.intent.action.mystaticreceiver";
    public static final String LOADING_PROCESS_ACTION = "android.intent.action.MyStaticReceiverA";
    @BindView(R.id.bindservice)
    Button bindservice;
    @BindView(R.id.unBindservice)
    Button unBindservice;
    @BindView(R.id.main_broadcast)
    Button mainBroadcast;
    @BindView(R.id.loading_broadcast)
    Button loadingBroadcast;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.test_handler)
    Button testHandler;
    @BindView(R.id.test_alarm)
    Button testAlarm;
    private WeakHashMap<TestComponentActivity, String> weakHashMap = new WeakHashMap<>();
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.test_file_provider)
    Button testFileProvider;
    public static TextView sContent;
    final String PKG_NAME = BuildConfig.APPLICATION_ID;
    public static final Uri TEST_URI = Uri.parse("content://com.huawei.rcsbaseline.database.zone");

    private void launchLauncher(String name) {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");

//        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
//            localIntent.setPackage(getPackageName());
            localIntent.setComponent(new ComponentName(getPackageName(), name));
            startActivity(localIntent);
        } catch (Exception localException) {
            localIntent.setComponent(new ComponentName(getApplicationContext(),
                    TestComponentActivity.class));
            startActivity(localIntent);
        } finally {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onChange: selfChange=" + PKG_NAME);
//        String name = SystemProperties.get("fhgfh");
//        getContentResolver().registerContentObserver(TEST_URI,
//                true, new ContentObserver(null) {
//                    @Override
//                    public void onChange(boolean selfChange) {
//                        super.onChange(selfChange);
//                        Log.e(TAG, "onChange: selfChange=" + selfChange);
//                    }
//
//                    @Override
//                    public void onChange(boolean selfChange, Uri uri) {
//                        super.onChange(selfChange, uri);
//                        Log.e(TAG, "onChange: uri=" + uri + " selfChange=" + selfChange);
//                    }
//
//                });
//        String className = getIntent().getComponent().getClassName();
//        Log.e(TAG, "onCreate: className=" + className);
        setContentView(R.layout.test_component);
        ButterKnife.bind(this);
        sContent = content;
//        getContentResolver().registerContentObserver(URIField.ACCOUNT_URI, true, new
//                ContentObserver(null) {
//                    @Override
//                    public void onChange(boolean selfChange) {
//                        Log.e(TAG, "onChange selfChange=" + selfChange);
//                    }
//                });
//        try {
//            Context context = createPackageContext("tropical.island.summer.theme.cool", Context
//                    .CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
//            Log.e(TAG, "onCreate: pkg=" + context.getPackageName());
//            int id = context.getResources().getIdentifier("loading_gear_blue", "drawable", context
//                    .getPackageName());
//            Log.e(TAG, "onCreate: id=" + id);
//            query.setBackground(context.getDrawable(id));
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
        content.setMovementMethod(ScrollingMovementMethod.getInstance());
        //设置触摸事件
        content.setOnTouchListener(touchListener);
    }

    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";

    @OnClick(R.id.query)
    public void onQueryClicked() {
        int secondaryCount = 0;
        int secondaryNumber = 2;
        File file = new File(Environment.getExternalStorageDirectory() + "/1.apk");
        long time = 0;
        try {
            time = System.currentTimeMillis();
            Log.d(TAG, "onQueryClicked: start");
            final ZipFile apk = new ZipFile(file);
            Log.d(TAG, "onQueryClicked: start 1 duration=" + (System.currentTimeMillis() - time));
            ZipEntry dexFile = apk.getEntry(DEX_PREFIX + secondaryNumber + DEX_SUFFIX);
            while (dexFile != null) {
                secondaryCount++;
                secondaryNumber++;
                dexFile = apk.getEntry(DEX_PREFIX + secondaryNumber + DEX_SUFFIX);
            }
        } catch (Exception e) {

        }
        Log.d(TAG, "onQueryClicked: end secondaryCount=" + secondaryCount + " duration=" +
                (System.currentTimeMillis() - time));
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Class cr = getClassLoader().loadClass("android.content.ContentResolver");
//                    Method method = cr.getMethod("acquireProvider", Uri.class);
//                    Object transport = method.invoke(getContentResolver(), URIField
//                            .ACCOUNT_URI);
//                    Log.e(TAG, "onQueryClicked: " + transport + "  class=" + transport.getClass
// ());
//                    Class tsCl = transport.getClass();
//                    Method get = tsCl.getDeclaredMethod("getContentProvider");
//                    get.setAccessible(true);
//                    Log.e(TAG, "onQueryClicked: get" + get.invoke(transport));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, "onQueryClicked: e" + e);
//                }
//                ContentProviderClient providerClient = null;
//                try {
//                    providerClient = getContentResolver().acquireContentProviderClient(URIField
//                            .ACCOUNT_URI);
////                    providerClient.setDetectNotResponding(3000);
//                    providerClient.query
//                            (URIField.ACCOUNT_URI, null, null, null, null, null);
////                    getContentResolver().query
////                            (URIField.ACCOUNT_URI, null, null, null, null, null);
//                } catch (Exception e) {
//                } finally {
//                    boolean isResult = providerClient.release();
//                    Log.e(TAG, "run: isResult=" + isResult);
//                }
//                weakHashMap.put(TestComponentActivity.this, "aaaa");
//            }
//        }.start();
//        weakHashMap.put(new TestComponentActivity(), "bbbb");
    }

    int i = 0;
    private AtomicInteger integer = new AtomicInteger(1);

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        Intent intent1 = new Intent(LOADING_PROCESS_ACTION);
//        intent1.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        sendBroadcast(intent1);
        Log.d(TAG, "onInsertClicked: start 0");
//        final DatabaseHelper helper = new DatabaseHelper(TestComponentActivity.this,
//                "hizone.db");
        for (int m = 0; m < 500; m++) {
            new Thread() {
                @Override
                public void run() {
                    synchronized (TestComponentActivity.this) {
                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //                    DatabaseHelper helper = new DatabaseHelper
                        // (TestComponentActivity.this,
//                            "hizone.db");
//                    SQLiteDatabase database = helper.getReadableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("login_account", "cj" + integer.getAndIncrement());
//                    ContentValues contentValues = new ContentValues();
                        contentValues.put("login_account", "cj" + i);
                        getContentResolver().insert(URIField.ACCOUNT_URI, contentValues);
//                    if (integer.get() % 2 == 0) {
//                    database.insert(DatabaseHelper.Tables.ACCOUNT, null, contentValues);
//                    } else {
//                        database.query(DatabaseHelper.Tables.ACCOUNT, null, null, null, null,
// null,
//                                null);
//                    }
//                    database.close();
                    }
                }
            }.start();
        }
        Log.d(TAG, "onInsertClicked: start 1");
        int secondaryCount = 0;
        File file = new File(Environment.getExternalStorageDirectory() + "/1.apk");
        long time = 0;
        try {
            time = System.currentTimeMillis();
            final ZipFile apk = new ZipFile(file);
            Log.d(TAG, "onInsertClicked: start duration=" + (System.currentTimeMillis() - time));
            Enumeration sd = apk.entries();
            while (sd.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) sd.nextElement();
                if (null != zipEntry) {
                    if (zipEntry.getName().contains("classes")) {
                        secondaryCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onInsertClicked: secondaryCount=" + secondaryCount + "  duration=" + (System
                .currentTimeMillis() - time));
//        try {
//            WallpaperManager wpm = (WallpaperManager) getSystemService(
//                    Context.WALLPAPER_SERVICE);
//
//            if (wpm != null) {
//                wpm.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.aa));
//                Log.e(TAG, "wallpaper not null");
//            }
//        } catch (IOException e) {
//            Log.e(TAG, "Failed to set wallpaper: " + e);
//        }

//        mHandler.sendEmptyMessageDelayed(MSG_TIMER, 0);
//        getContentResolver().notifyChange(TEST_URI,
//                null);
////        i++;
//        new Thread() {
//            @Override
//            public void run() {
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("login_account", "cj" + i);
//                getContentResolver().insert(URIField.ACCOUNT_URI, contentValues);
//                Iterator keys = weakHashMap.keySet().iterator();
//                while (keys.hasNext()) {
//                    Log.e(TAG, "onInsertClicked: " + weakHashMap.get(keys.next()));
//                }
//            }
//        }.start();
//        PackageManager pm = getPackageManager();
//        pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
//                        ".TestComponentActivity"),
//                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
//        pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
//                        ".MainAliasActivity"),
//                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
//        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
////            SystemProperties.set("debug.test.euro", "false");
//        sharedPreferences.edit().putBoolean("debug.test.euro", true).apply();
//
    }

    public static String timeStamp2Date(long seconds, String format) {
        if (format == null || format.isEmpty()) {
            format = "HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(seconds));
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case MSG_TIMER: {
                    Log.e(TAG, "handleMessage: MSG_TIMER " + timeStamp2Date(SystemClock
                                    .uptimeMillis(),
                            null));
                    String text = sContent.getText().toString();
                    sContent.setText(text + "\r\n" + timeStamp2Date(System.currentTimeMillis(),
                            null) + "MSG ," + timeStamp2Date(SystemClock.uptimeMillis(),
                            null));
                    sendEmptyMessageDelayed(MSG_TIMER, 5000);
                    break;
                }
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @OnClick(R.id.update)
    public void onUpdateClicked() {
        final SharedPreferences sp = getSharedPreferences("cj_file", MODE_MULTI_PROCESS);
        HashMap<String, ?> values = (HashMap) sp.getAll();
        Random random = new Random();
        int next = random.nextInt(100);
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5l; i++) {
            sb.append(i);
        }
//        Log.d(TAG, "test: values=" + values + " next=" + next);
        Log.d(TAG, "onUpdateClicked");
        new Thread() {
            @Override
            public void run() {
                Log.d(TAG, "onUpdateClicked 11");
                for (int m = 0; i < 10000l; i++) {
                    sp.edit().putString(String.valueOf(i), sb.toString()).apply();
                }
            }
        }.start();
//        sp.edit().putLong("aaa", next).putInt("ss", next).apply();
        try {
            getClassLoader().loadClass("example.com.testcomponent.statics.TestStaticE");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "onUpdateClicked b=" + TestStaticA.b);
//        TestStaticA.class.getDeclaredMethods();
//        Log.e(TAG, "onUpdateClicked b=" + TestStaticA.getTest());
//        new TestLib().test();
//        try {
//        TestLib testLib = new TestLib();
//        Log.e(TAG, "onUpdateClickedprovider=" + TestLib.class);
//        TestProvider provider = new TestProvider();
//        Log.e(TAG, "onUpdateClickedprovider=" + provider);

//        Class classTest = null;
//        try {
//            classTest = getClassLoader().loadClass("example.com.testcomponent.statics" +
//                    ".TestStaticA");
////            classTest = getClassLoader().loadClass("fdsfdf.fdfdf.dsfdsf");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        classTest.getDeclaredMethods();
//        } catch (Throwable e) {
//            Log.e(TAG, "onUpdateClicked e=" + e, e);
//        }
        String className = getIntent().getComponent().getClassName();
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        boolean isEuro = sharedPreferences.getBoolean("debug.test.euro", false);
        Log.e(TAG, "onCreate: isEuro=" + isEuro);
        if (isEuro) {
            PackageManager pm = getPackageManager();
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".MainAliasActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".TestComponentActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            if ("example.com.testcomponent.MainAliasActivity".equalsIgnoreCase(className)) {
                launchLauncher("example.com.testcomponent.TestComponentActivity");
            }
//            SystemProperties.set("debug.test.euro", "false");
            sharedPreferences.edit().putBoolean("debug.test.euro", false).apply();
        }

//        new Thread() {
//            @Override
//            public void run() {
//                getContentResolver().update(URIField.ACCOUNT_URI, new ContentValues(), null,
// null);
//            }
//        }.start();
    }

    private IMyAidlInterface mIMyAidlInterface;
    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: name=" + name + " service=" + service);
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected: name=" + name);
        }

        @Override
        public void onBindingDied(ComponentName name) {
            Log.e(TAG, "onBindingDied: name=" + name);
        }
    };

    @OnClick(R.id.unBindservice)
    public void onUnBindserviceClicked() {
        unbindService(mServiceConnection);
    }

    @OnClick(R.id.bindservice)
    public void onBindserviceClicked() {
//        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        manager.killBackgroundProcesses("example.com.testcomponent");
        Intent intent = new Intent();
//        intent.setClassName("letv.com.testanr11", "letv.com.testanr.MyService");
        intent.setClassName("example.com.testcomponent.dd", "example.com.testcomponent.MyService");
        boolean result = bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
        new Thread() {
            @Override
            public void run() {
                if (null != mIMyAidlInterface) {
                    try {
                        mIMyAidlInterface.test(1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        Log.e(TAG, "onBindServiceClicked: end result=" + result);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.main_broadcast)
    public void onMainBroadcastClicked() {
        Intent intent = new Intent(MAIN_PROCESS_ACTION);
//        Intent intent = new Intent(Intent.ACTION_PACKAGE_ADDED);
//        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//        intent.setPackage(getPackageName());
        sendBroadcast(intent);
//        pollServer();
//        testAlarm();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void pollServer() {
        Log.e(TAG, "pollServer: ");
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        for (int i = 0; i < 40; i++) {
        JobInfo jobInfo = new JobInfo.Builder(i, new ComponentName(getPackageName(),
                MyJobService.class.getName()))
                .setMinimumLatency(10000) // 5 seconds
//                    .setOverrideDeadline(10000) // 60 seconds (for brevity in the sample)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) // WiFi or data connections
//                .setPeriodic(5000)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//                .setRequiresDeviceIdle(true)
//                    .setRequiresCharging(true)
                .build();
        scheduler.schedule(jobInfo);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: data=");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: data=" + intent.getStringExtra("name"));
    }

    int id = 1;

    @OnClick(R.id.loading_broadcast)
    public void onLoadingBroadcastClicked() {
//        Intent intent1 = new Intent(LOADING_PROCESS_ACTION);
//        intent1.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//        sendBroadcast(intent1);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("this is Content");
        builder.setContentTitle("this is Content title" + id);
        Intent switchPanelIntent = new Intent(this, TestComponentActivity.class);
        switchPanelIntent.putExtra("name", "fds");
        switchPanelIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_NO_ANIMATION);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 11,
                switchPanelIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
//        builder.setPriority(Notification.);
//        builder.setTicker("this is ticker");
        builder.setSmallIcon(R.drawable.aa);
        builder.setPriority(Notification.PRIORITY_MAX);
        final NotificationManager nm = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        builder.build().defaults |= Notification.DEFAULT_VIBRATE;
        builder.build().defaults |= Notification.DEFAULT_SOUND;
        builder.build().defaults |= Notification.DEFAULT_LIGHTS;
        id++;
        nm.notify(id, builder.build());


        Notification.Builder builder1 = new Notification.Builder(this);
        builder1.setContentText("this is Content");
        builder1.setContentTitle("this is Content title" + id);
        Intent switchPanelIntent1 = new Intent(this, TestComponentActivity.class);
        switchPanelIntent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_NO_ANIMATION);
        switchPanelIntent1.putExtra("name", "abcd");
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 11,
                switchPanelIntent1, PendingIntent.FLAG_UPDATE_CURRENT);
        builder1.setContentIntent(pendingIntent1);
//        builder.setPriority(Notification.);
//        builder.setTicker("this is ticker");
        builder1.setSmallIcon(R.drawable.aa);
        builder1.setPriority(Notification.PRIORITY_MAX);
        builder1.build().defaults |= Notification.DEFAULT_VIBRATE;
        builder1.build().defaults |= Notification.DEFAULT_SOUND;
        builder1.build().defaults |= Notification.DEFAULT_LIGHTS;
        id++;
//        nm.notify(id, builder1.build());
    }

    @OnClick(R.id.content)
    public void onContentClicked() {
    }

    @OnClick(R.id.test_handler)
    public void onTestHandlerClicked() {
        mHandler.sendEmptyMessage(MSG_TIMER);
    }

    @OnClick(R.id.test_alarm)
    public void onTestAlarmClicked() {
        new TestStaticD().testPub(null);
//        TranslateAnimation animation = new TranslateAnimation(0, 0, 50, 0);
//        animation.setDuration(5000);
//        testAlarm.startAnimation(animation);
//        testAlarm();
//        Log.d(TAG, TestStaticA.b + "");
    }

    @OnClick(R.id.test_file_provider)
    public void onTestFileProvider() {
        File sourceFile = new File(Environment.getExternalStorageDirectory().getPath() + "/1.apk");
        File targetFile = new File(getFilesDir() + "/1.apk");
//        targetFile = new File(getExternalFilesDir(null) + "/1.apk");
        FileUtils.copyFile(sourceFile.getPath(), targetFile.getPath());
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";
        Uri contentUri = FileProvider.getUriForFile(this,
                BuildConfig.APPLICATION_ID + ".myprovider", targetFile);
        contentUri = Uri.fromFile(targetFile);

        intent.setDataAndType(contentUri, type);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    private void init(float[] ctrl_points) {
        final int length = ctrl_points.length;
        if (length % 2 != 0 || length < 2)
            throw new IllegalArgumentException("error in BezierCurve::Init");

        final int count = length / 2;
        float[] px = new float[count];
        float[] py = new float[count];
        for (int i = 0, j = 0; i < length; i += 2, j++) {
            px[j] = ctrl_points[i];
            py[j] = ctrl_points[i + 1];
        }
    }

    private void testAlarm() {
//        float[] controls = new float[]{0f, 0f, .17f, 0f, .241f, .176f, .338f, .347f, .437f,
//                .518f, .571f, .659f, .65f, .712f, .729f, .765f, .893f, 1f, 1f, 1f};
//        init(controls);
//        try {
//            Context launcherContext = createPackageContext("com.ksmobile.launcher",
//                    Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY | 8);
//
////            File dir = launcherContext.getFilesDir();
//            File dir = launcherContext.getExternalFilesDir(null);
////            File dir = new File(Environment.getExternalStorageDirectory().getPath() +
////                    "/Android/data/com" +
////                    ".ksmobile.launcher/files");
////            boolean isDelete = dir.delete();
//            File launcher = new File(dir, "CMLauncher/dump/");
//            String[] pathList = launcher.list();
//            if (null != pathList) {
//                for (String path : pathList) {
//                    Log.e(TAG, "testAlarm path=" + path);
//                }
//            }
//            Log.e(TAG, "testAlarm: dir=" + dir + " dir.exists()=" + dir.exists() + " dir.canRead="
//                    + dir
//                    .canRead() + " dir.canWrite()=" + dir
//                    .canWrite() + " launcher=" +
//                    launcher + " launcher" +
//                    ".canRead()=" + launcher.canRead() + "  launcher.canWrite()=" + launcher
//                    .canWrite() + " sda="
//                    + launcher.delete());
//            if (null != dir) {
//                File file = new File(dir, "11.txt");
//                file.delete();
//                try {
//                    file.createNewFile();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, "testAlarm: createNewFile e=" + e);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(TAG, "testAlarm: testAlarm 111e=" + e);
//        }
        Log.e(TAG, "testAlarm: ");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        Intent serviceIntent = new Intent(this, MyService.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent,
//                PendingIntent.FLAG_CANCEL_CURRENT);
//        PendingIntent pendingIntent = PendingIntent.getService(this, 0, serviceIntent,
//                PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent pendingIntent = PendingIntent.getForegroundService(this, 0, serviceIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 5 * 1000 + System
//                        .currentTimeMillis(),
//                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, 20 * 1000 + System
//                .currentTimeMillis(), pendingIntent);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(
//                Context.ALARM_SERVICE);

        final Intent stateChangeIntent = new Intent(this, AlarmBroadcastReceiver.class);
        stateChangeIntent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        stateChangeIntent.setAction("indicator");
        PendingIntent operation = PendingIntent.getBroadcast(this, 0 /* requestCode */,
                stateChangeIntent, 0);
        // Treat alarm state change as high priority, use foreground broadcasts
        long alarmTime = 15 * 1000 + System.currentTimeMillis();

        // Create an intent that can be used to show or edit details of the next alarm.
        PendingIntent viewIntent = PendingIntent.getActivity(this, 11111,
                createViewAlarmIntent(),
                PendingIntent.FLAG_UPDATE_CURRENT);

//        AlarmManager.AlarmClockInfo info =
//                new AlarmManager.AlarmClockInfo(alarmTime, viewIntent);
//        alarmManager.setAlarmClock(info, operation);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System
                .currentTimeMillis() + 80 * 1000, pendingIntent);
    }

    public Intent createViewAlarmIntent() {
        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    /**
     * 设置触摸事件，由于EditView与TextView都处于ScollView中，
     * 所以需要在OnTouch事件中通知父控件不拦截子控件事件
     */
    private View.OnTouchListener touchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN
                    || event.getAction() == MotionEvent.ACTION_MOVE) {
                //按下或滑动时请求父节点不拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                //抬起时请求父节点拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;

        }
    };
}
