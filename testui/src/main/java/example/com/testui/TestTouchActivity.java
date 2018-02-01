package example.com.testui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;

import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//class PriorityEntity implements Comparable<PriorityEntity> {
//    private static int count = 0;
//    private int id = count++;
//    private int priority;
//    private int index = 0;
//
//    public PriorityEntity(int _priority, int _index) {
//        this.priority = _priority;
//        this.index = _index;
//    }
//
//    public String toString() {
//        return id + "# [index=" + index + " priority=" + priority + "]";
//    }
//
//    // ����С�����ȼ���
//    public int compareTo(PriorityEntity o) {
//        return this.priority > o.priority ? 1 : -1;
//    }
//
//    // ���ִ����ȼ���
//    // public int compareTo(PriorityTask o) {
//    // return this.priority < o.priority ? 1
//    // : this.priority > o.priority ? -1 : 0;
//    // }
//}

public class TestTouchActivity extends Activity implements OnClickListener, View
        .OnLongClickListener {
    public static final String LETV_AD_SDK_UPD_PATH = Environment.getExternalStorageDirectory()
            + File.separator
            + "libhello-jni.so"; // data/data/com.letv.adlib.sdk/.sdkupd/libLetvAdSDK.so";
    private static final String TAG = "Touch_TouchActivity";
    @BindView(R.id.img0)
    ImageView img0;
    @BindView(R.id.test_notify)
    Button testNotify;
    @BindView(R.id.touch_area1)
    TestLinearLayout touchArea1;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.text)
    TestTextView text;
    @BindView(R.id.touch_area)
    TestRelativeLayout touchArea;
    @BindView(R.id.test_content)
    FrameLayout testContent;
    @BindView(R.id.cancel_notify)
    Button cancelNotify;
    private NotificationManager mNotificationManager;

    @Override
    public boolean onLongClick(View v) {
        Exception exception = new Exception("onLongClick");
        Log.d(TAG, "onLongClick: ", exception);
        return false;
    }

    @OnClick(R.id.img0)
    public void onImg0Clicked() {
    }

    @OnClick(R.id.test_notify)
    public void onTestNotifyClicked() {
        NotificationBuilderCompat builder = new NotificationBuilderCompat(this);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                new Intent(),
                PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setPriority(NotificationBuilderCompat.PRIORITY_MAX)
                .setVisibility(NotificationBuilderCompat.VISIBILITY_PUBLIC)
                .setWhen(2147483647L)
                .setOngoing(true)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.aa)
                .setContentIntent(pendingIntent);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.notification_shortcut_bar);
        int requestCode = 0;
        initBroadcastIntent(remoteViews, R.id.notification_tab2, requestCode++);
        initBroadcastIntent(remoteViews, R.id.notification_tab3, requestCode++);
        initBroadcastIntent(remoteViews, R.id.notification_tab4, requestCode++);
        initBroadcastIntent(remoteViews, R.id.notification_tab6, requestCode++);
        //初始化省电按钮点击事件
        initBroadcastIntent(remoteViews, R.id.notification_tab7, requestCode++);
        builder.setContent(remoteViews);
        Notification notification = builder.build();
        mNotificationManager.notify(1000, notification);
    }

    private void initBroadcastIntent(RemoteViews remoteViews, int viewId,
                                     int requestCode) {
        Intent intent = new Intent("android.intent.action.mystaticreceiver");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(viewId, pendingIntent);
    }


    @OnClick(R.id.touch_area1)
    public void onTouchArea1Clicked() {
    }

    @OnClick(R.id.img)
    public void onImgClicked() {
    }

    @OnClick(R.id.img2)
    public void onImg2Clicked() {
    }

    @OnClick(R.id.text)
    public void onTextClicked() {
    }

    @OnClick(R.id.touch_area)
    public void onTouchAreaClicked() {
    }

    @OnClick(R.id.test_content)
    public void onTestContentClicked() {
    }

    @OnClick(R.id.cancel_notify)
    public void onCancelNotify() {
        if (mNotificationManager != null) {
            try {
                mNotificationManager.cancel(1000);
            } catch (Exception e) {
            }
        }
    }

//    static {
//        try {
//            System.load(LETV_AD_SDK_UPD_PATH);
//        } catch (Exception e) {
//            Log.d(TAG, "LETV_AD_SDK_UPD_PATH ee=" + e);
//            // 如果新库文件不能成功加载,则删除
//            System.loadLibrary("dddd");
//        } catch (Error r) {
//            Log.d(TAG, "LETV_AD_SDK_UPD_PATH error=" + r);
//        }
//    }

    // public static int version = 1;
    // private static boolean nativeLibLoaded = false;
    // public static final String LETV_AD_SDK = "LetvAdSDK"; //
    // Ӧ�÷���ʱ�ӵ�libs/armeabi��,����������µ�SDK,ʹ�ø�SDK
    // public static final String LETV_AD_SDK_UPD = "LetvAdSDKUpd"; //
    // ����и���,��������µ�SDK
    // public static final String LETV_AD_SDK_TMP = "LetvAdSDKTmp"; //
    // ���ڱ�������ʱ����ʱ�ļ�
    // public static final String LETV_AD_SDK_TEST = "LetvAdSDKTest"; //
    // ���ڱ�������ʱ����ʱ�ļ�
    // public static final String LETV_AD_SDK_UPD_PATH = Environment
    // .getExternalStorageState() + File.separator + "libLetvAdSDK.so"; //
    // data/data/com.letv.adlib.sdk/.sdkupd/libLetvAdSDK.so";

    // private LinearLayout mLinearLayout;
    // private LinearLayout mLinearLayout1;

    // public String getAndroidId() {
    // String android_id = Settings.Secure.getString(getContentResolver(),
    // Settings.Secure.ANDROID_ID);
    // if (android_id == null || android_id.equals("9774d56d682e549c")
    // || android_id.length() < 15) {
    // final SecureRandom random = new SecureRandom();
    // android_id = new BigInteger(64, random).toString(16);
    // }
    // return android_id;
    // }

    // private static Scroller mScroller; // й¶Activity���󣬵����ص��back��ť
    private static class MyHandler extends Handler {
        private WeakReference<Activity> reference;

        public MyHandler(Activity activity) {
            reference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            Log.d(TAG, "handleMessage activity=" + reference.get());
        }
    }

    private TestRelativeLayout mLinearLayout;
    private TestTextView mTextView;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getResources().getDrawable(R.drawable.ad_pause_del);
        setContentView(R.layout.activity_test_touch);
        ButterKnife.bind(this);
        final Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
        Drawable drawable = new BitmapDrawable(original);
        drawable.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC);
        drawable.clearColorFilter();
        Canvas canvas = new Canvas();
        //BubbleContentUtil.getGlowBitmap(getWidth() + padding, getHeight() + padding);
        canvas.setBitmap(b);
//        canvas.drawARGB(256, 256, 0, 0);
//        canvas.drawColor(Color.RED, PorterDuff.Mode.CLEAR);
//        canvas.scale(0.5f, 0.5f);
//        canvas.rotate(80);
//        canvas.translate(80,90);
//        canvas.clipRect(new Rect(0, 0, 100, 300));
//        canvas.translate(50, 0);
//        original.recycle();
        canvas.drawBitmap(original, 0, 0, null);
//        drawable.draw(canvas);
        canvas.setBitmap(null);
//        ((ImageView) findViewById(R.id.img)).setImageBitmap(b);
        ((ImageView) findViewById(R.id.img)).setImageDrawable(drawable);
//        final Bitmap bb = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
//        canvas.setBitmap(bb);
//        canvas.translate(50, 50);
//        canvas.drawBitmap(original, 0, 0, null);
//        ((ImageView) findViewById(R.id.img2)).setImageBitmap(bb);
        Log.d(TAG, "onCreate this11=" + this + "=" + TestA.class);
        // mTextView = (TestTextView) findViewById(R.id.text);
        // mLinearLayout = (TestRelativeLayout) findViewById(R.id.touch_area);
        // Log.d(TAG, "onCreate visible=" + mTextView.getVisibility());
        // Button cv = (Button)findViewById(R.id.hide_cv);
        // cv.setOnClickListener(this);
        // Button pv = (Button)findViewById(R.id.hide_pv);
        // pv.setOnClickListener(this);
        MyHandler myHandler = new MyHandler(this);
        myHandler.sendEmptyMessageDelayed(0, 5000);
        Random random = new Random(47);
        final PriorityBlockingQueue q = new PriorityBlockingQueue();
        ExecutorService se = Executors.newCachedThreadPool();
        // execute producer
        // se.execute(new Runnable() {
        // public void run() {
        // int i = 0;
        // while (true) {
        // q.put(new PriorityEntity(r.nextInt(10), i++));
        // try {
        // TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        // }
        // });
//        for (int i = 0; i < 10; i++) {
//            q.put(new PriorityEntity(random.nextInt(100), i++));
//        }
        System.out.println("size=" + q.size());
        // execute consumer
        se.execute(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        System.out
                                .println("take-- " + q.take() + " left:-- [" + q.toString() + "]");
                        // try {
                        // TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                        // } catch (InterruptedException e) {
                        // // TODO Auto-generated catch block
                        // e.printStackTrace();
                        // }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // try {
        // TimeUnit.SECONDS.sleep(5);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println("shutdown");
        // mHandler.sendEmptyMessageDelayed(0, 5000);
        // System.loadLibrary(LETV_AD_SDK);
        // File file = new File(Environment.getExternalStorageDirectory()
        // + "/test.cde");
        // // Log.d(TAG, "onCreate android_id=" + getAndroidId());
        // Log.d(TAG, "onCreate CallingPackage=" + getCallingPackage());
        // Log.d(TAG, "onCreate ddd=" +
        // System.getProperty("java.library.path"));
        // Log.d(TAG,
        // "onCreate classLoad.getSystemClassLoader()=" +
        // ClassLoader.getSystemClassLoader());
        // Log.d(TAG,
        // "onCreate classLoad.getSystemClassLoader().parent="
        // + ClassLoader.getSystemClassLoader().getParent());
        Log.d(TAG,
                "onCreate getClassLoader="
                        + getClassLoader().getResourceAsStream(
                        "res/drawable-hdpi-v4/ad_pause_del.png"));
        // Log.d(TAG, "onCreate getClassLoader.parent=" +
        // getClassLoader().getParent());
        // Log.d(TAG, "onCreate System.loadLibrary=" +
        // System.class.getClassLoader());
        // Log.d(TAG, "onCreate file=" + file.getAbsolutePath());
        // Log.d(TAG, "onCreate file.getPath=" + file.getPath());
        // Log.d(TAG, "onCreate file.exists=" + file.exists());
        // TestLib testLib = new TestLib();
        // Log.d(TAG, "onCreate testLib=" + testLib.getPic(this));
        // mLinearLayout = (LinearLayout) findViewById(R.id.touch_area);
        // mLinearLayout1 = (LinearLayout) findViewById(R.id.touch_area1);
        // mLinearLayout.setOnTouchListener(this);d
        // mLinearLayout1.setOnTouchListener(this);
        // mLinearLayout.setOnClickListener(this);
        // mLinearLayout1.setOnClickListener(this);
        // TextView textView = (TextView) findViewById(R.id.text);
        // textView.setOnClickListener(this);
        // textView.setOnTouchListener(this);
        // TelephonyManager ff;
        // List<String> tempList = new ArrayList<>();
        // StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
        // // .detectCustomSlowCalls() // ��������滻ΪdetectAll()
        // �Ͱ����˴��̶�д������I/O
        // .detectDiskReads()
        // .detectAll()
        // .detectDiskWrites()
        // .penaltyLog()
        // .penaltyDropBox()
        // .penaltyDialog()// ��ӡlogcat����ȻҲ���Զ�λ��dropbox��ͨ���ļ�������Ӧ��log
        // .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll() // ̽��SQLite���ݿ����
                .penaltyLog() // ��ӡlogcat
                // .penaltyDeath()
                .build());
        // mScroller = new Scroller(this);
//        findViewById(R.id.img0).setOnClickListener(this);
//        findViewById(R.id.img0).setOnLongClickListener(this);
        mNotificationManager = (NotificationManager) getSystemService(Context
                .NOTIFICATION_SERVICE);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        Log.d(TAG, "finalize this=" + this);
    }

    public static String md5(String input) {
        String result = input;
        if (input != null && !"".equals(input)) {
            MessageDigest md; // or "SHA-1"
            try {
                md = MessageDigest.getInstance("MD5");
                md.update(input.getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                result = hash.toString(16);
                while (result.length() < 32) {
                    result = "0" + result;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }

        }
        Log.d(TAG, "md5 result=" + result);
        return result;
    }

    TranslateAnimation translateAnimation;

    @Override
    protected void onResume() {
        super.onResume();
        translateAnimation = new TranslateAnimation(200, 400, 100, 600);
        translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(3600);
        translateAnimation.setFillEnabled(true);
//        translateAnimation.setFillBefore(true);
        translateAnimation.setFillBefore(true);
//        translateAnimation.setFillAfter(true);
    }

    // @Override
    // public boolean onTouch(View v, MotionEvent event) {
    // Log.d(TAG, "onTouch v=" + v + " action=" + event.getAction());
    // int id = v.getId();
    // switch (id) {
    // case R.id.touch_area: {
    // // if (MotionEvent.ACTION_UP == event.getAction()) {
    // // for (int i = 0; i < 100; i++) {
    // // new Thread() {
    // // public void run() {
    // // String path3 = "/Letv/storage/.ark_download";
    // // File file1 = new File(
    // // Environment.getExternalStorageDirectory()
    // // + path3);
    // // Log.d(TAG, "onTouch file1 path=" + file1.getPath());
    // // Log.d(TAG, "onTouch file1 exists=" + file1.exists());
    // // Log.d(TAG,
    // // "onTouch file1 isDirectory="
    // // + file1.isDirectory());
    // // if (!file1.exists()) {
    // // boolean isSuccess = file1.mkdirs();
    // // Log.d(TAG, "onTouch isSuccess=" + isSuccess);
    // // }
    // // };
    // // }.start();
    // // }
    // // // Exception exception = new Exception("erroro");
    // // // exception.fillInStackTrace();
    // // // Log.d(TAG, "exception=" + exception);
    // // // Log.d(TAG, Log.getStackTraceString(new
    // // Throwable("fffff")));
    // // Exception re = new RuntimeException();
    // // re.fillInStackTrace();
    // // // Log.d(TAG, "stackTrace", re);
    // // String path = "/Letv/storage/.ark_download/2.txt";
    // // String path1 = "/test/1.txt";
    // // String path2 = "/chengjian/lj/.cj";
    // // String path3 = "/Letv/storage/";
    // // // File file = new
    // // // File(Environment.getExternalStorageDirectory()
    // // // + path3);
    // // // File file1 = new
    // // // File(Environment.getExternalStorageDirectory()
    // // // + "/Letv/storage/.ark_download/");
    // // // Log.d(TAG, "onTouch getAbsolutePath=" +
    // // // file1.getAbsolutePath());
    // // // Log.d(TAG, "onTouch getPath=" + file1.getPath());
    // // // Log.d(TAG, "onTouch exists=" + file1.exists());
    // // // File file1 = new
    // // // File(Environment.getExternalStorageDirectory()
    // // // + path3);
    // // // Log.d(TAG, "onTouch file1 path=" + file1.getPath());
    // // // Log.d(TAG, "onTouch file1 exists=" + file1.exists());
    // // // Log.d(TAG, "onTouch file1 isDirectory=" +
    // // // file1.isDirectory());
    // // // if (!file1.exists()) {
    // // // boolean isSuccess = file1.mkdirs();
    // // // Log.d(TAG, "onTouch isSuccess=" + isSuccess);
    // // // }
    // // // RandomAccessFile accessFile;
    // // // try {
    // // // accessFile = new RandomAccessFile(file, "rwd");
    // // // accessFile.setLength(999);
    // // // accessFile.close();
    // // // String[] command = { "chmod", "666",
    // // file.getAbsolutePath()
    // // // };
    // // // ProcessBuilder builder = new ProcessBuilder(command);
    // // // builder.start();
    // // // } catch (Exception e) {
    // // // // TODO Auto-generated catch block
    // // // e.printStackTrace();
    // // // Log.d(TAG, "onTouch=" + e);
    // // // }
    // //
    // // // Log.d(TAG, "getX=" + event.getX());
    // // // Log.d(TAG, "getY=" + event.getY());
    // // // Log.d(TAG, "getRawX=" + event.getRawX());
    // // // Log.d(TAG, "getRawY=" + event.getRawY());
    // // // Log.d(TAG, "v.getBottom()=" + v.getBottom());
    // // // Log.d(TAG, "v.getheight=" + v.getHeight());
    // // // Log.d(TAG,
    // // // "oncreat = "
    // // // + getResources().getDimension(
    // // // R.dimen.activity_vertical_margin));
    // // }
    // break;
    // }
    // case R.id.touch_area1: {
    // // if (MotionEvent.ACTION_UP == event.getAction()) {
    // // Log.d(TAG, "getX11=" + event.getX());
    // // Log.d(TAG, "getY11=" + event.getY());
    // // Log.d(TAG, "getRawX11=" + event.getRawX());
    // // Log.d(TAG, "getRawY11=" + event.getRawY());
    // // }
    // break;
    // }
    // }
    // return super.onTouchEvent(event);
    // }
    class MyException extends Exception {

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        try {
            throw new MyException();
        } catch (MyException e) {

        }
        // boolean ss = isKeyGuard(TestTouchActivity.this);
        // Log.d(TAG, "onPause isKeyGuard ss=" + ss);
        // mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "onDestroy=" + 11);
        // mHandler.removeMessages(0);
    }

    // private Handler mHandler = new Handler() {
    // public void handleMessage(android.os.Message msg) {
    // // boolean ss = isKeyGuard(TestTouchActivity.this);
    // Log.d(TAG, "isKeyGuard ss=" + 11);
    // };
    // };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "Activity onTouchEvent action=" + event.getAction());
        boolean handle = super.onTouchEvent(event);
        Log.d(TAG, "Activity onTouchEvent handle=" + handle);
        return handle;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "Activity dispatchTouchEvent action=" + ev.getAction());
        boolean handle = super.dispatchTouchEvent(ev);
        Log.d(TAG, "Activity dispatchTouchEvent handle=" + handle);
//        final Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
//        Drawable drawable = new BitmapDrawable(original);
//        drawable.clearColorFilter();
//        ((ImageView) findViewById(R.id.img)).clearColorFilter();
        return handle;
    }

    public static boolean isKeyGuard(Context context) {
        if (context == null) {
            return false;
        }
        try {
            KeyguardManager mKeyguardManager = (KeyguardManager) context
                    .getSystemService(Context.KEYGUARD_SERVICE);

            return mKeyguardManager.inKeyguardRestrictedInputMode();
        } catch (Exception ex) {
            Log.d(TAG, "isKeyGuard ex=" + ex);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int id = v.getId();
        Exception exception = new Exception("onClick");
        Log.d(TAG, "onClick v=" + v, exception);
//        switch (id) {
//            case R.id.img0: {
////                findViewById(R.id.img0).offsetTopAndBottom(-findViewById(R.id.img0).getHeight
/// () /
////                        2);
//                Log.d(TAG, "onClick 11=" + findViewById(R.id.img0).getTop());
////                findViewById(R.id.img0).setTranslationY(findViewById(R.id.img0).getHeight()*2);
////                findViewById(R.id.img0).requestLayout();
//                Log.d(TAG, "onClick 22=" + findViewById(R.id.img0).getTop());
//                findViewById(R.id.img0).startAnimation(translateAnimation);
//                break;
//            }
//        }
        // switch (id) {
        // case R.id.hide_cv: {
        // Log.d(TAG, "hide_cv");
        // if (mTextView.getVisibility() == View.VISIBLE) {
        // mTextView.setVisibility(View.GONE);
        // } else {
        // mTextView.setVisibility(View.VISIBLE);
        // }
        // break;
        // }
        // case R.id.hide_pv: {
        // if (mLinearLayout.getVisibility() == View.VISIBLE) {
        // mLinearLayout.setVisibility(View.GONE);
        // } else {
        // mLinearLayout.setVisibility(View.VISIBLE);
        // }
        // Log.d(TAG, "hide_pv cv=" + mTextView.getVisibility());
        // break;
        // }
        // }
    }
}
