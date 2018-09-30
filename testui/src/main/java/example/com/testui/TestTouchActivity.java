package example.com.testui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RemoteViews;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

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
    //    @BindView(R.id.text)
//    TestTextView text;
    @BindView(R.id.text_id)
    TestTextView textId;
    @BindView(R.id.touch_area)
    TestRelativeLayout touchArea;
    @BindView(R.id.test_content)
    TestLinearLayout testContent;
    @BindView(R.id.test_root)
    FrameLayout root;
    @BindView(R.id.cancel_notify)
    Button cancelNotify;
    private NotificationManager mNotificationManager;
    private WindowManager mWindowManager;

    @Override
    public boolean onLongClick(View v) {
        Exception exception = new Exception("onLongClick");
        Log.e(TAG, "onLongClick: ", exception);
        return false;
    }

    @OnClick(R.id.img0)
    public void onImg0Clicked() {
    }

    class CM extends PopupWindow {

    }

    class MyDialog extends Dialog {
        public MyDialog(Context context) {
            super(context);
        }

        @Override
        protected void onStop() {
            Log.e("chengjian", "onStop: ");
        }

        @Override
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Log.e("chengjian", "onDetachedFromWindow: ");
        }
    }

    private void addWindowManager() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//视图延伸至状态栏区域，状态栏上浮于视图之上
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//视图延伸至导航栏区域，导航栏上浮于视图之上
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE//保持整个View稳定, 常和控制System UI悬浮,
                    // 隐藏的Flags共用, 使View不会因为System UI的变化而重新layout
            );
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        final View view = LayoutInflater.from(this).inflate(R.layout.test_window, null);
        Log.e(TAG, "addWindowManager: " + view.getHeight());
        final TextView textView = new TextView(this);
        textView.setText("dsgdggdsgdgdfg");
        textView.setBackgroundColor(0xff00ff00);
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && MotionEvent.ACTION_UP == event.getAction
                        ()) {
                    Log.e(TAG, "onKey: ");
//                    TranslateAnimation exitAnimationTranslate = new TranslateAnimation(200, 0, 0,
//                            600);
//                    exitAnimationTranslate.setDuration(2800);
//                    view.startAnimation(exitAnimationTranslate);
                    mWindowManager.removeView(view);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    return true;
                }
                return false;
            }
        });
        textView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && MotionEvent.ACTION_UP == event.getAction
                        ()) {
                    Log.e(TAG, "onKey: ");
                    mWindowManager.removeView(textView);
                    mWindowManager.removeView(view);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    return true;
                }
                return false;
            }
        });
//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
        view.findViewById(R.id.test_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ddddddd");
            }
        });
        view.setFocusableInTouchMode(true);
//        textView.setFocusableInTouchMode(true);
//        textView.setText("sdsadsdsdsadasdda");
//        textView.setWidth(50);
//        textView.setWidth(50);
//        textView.setGravity(Gravity.CENTER);
//        textView.setBackgroundColor(Color.RED);
//        frameLayout.addView(textView);
//        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(500, 500));
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;
//        params.format = PixelFormat.RGBA_8888;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
//        params.gravity = Gravity.LEFT | Gravity.TOP;
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        TranslateAnimation exitAnimationTranslate = new TranslateAnimation(200, 0, 0,
//                600);
//        exitAnimationTranslate.setDuration(2800);
//        view.startAnimation(exitAnimationTranslate);
//        mWindowManager.addView(view, getLayoutParams());
        final WindowManager.LayoutParams params = initLayoutParams(600);
        params.height = 1800;
//        params.y = 600;
//        params.gravity = Gravity.TOP | Gravity.RIGHT;
        params.x = 200;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager
//                .LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager
//                .LayoutParams.FLAG_LAYOUT_NO_LIMITS | WindowManager
//                .LayoutParams.FLAG_FULLSCREEN | WindowManager
//                .LayoutParams.FLAG_LAYOUT_INSET_DECOR/*| WindowManager.LayoutParams
//                .FLAG_NOT_TOUCHABLE*/;
//        params.y = 800;
//        mWindowManager.addView();
        mWindowManager.addView(textView, params);
//        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 0);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
////                params.verticalMargin = (float) animation.getAnimatedFraction();
////                mWindowManager.updateViewLayout(textView, params);
//                params.y = (int) animation.getAnimatedValue();
////                Log.e(TAG, "onAnimationUpdate: params.height=" + params.height);
//                //保证已attach to windowManager
//                mWindowManager.updateViewLayout(textView, params);
//            }
//        });
//        valueAnimator.setDuration(400);
//        valueAnimator.start();
    }

    private WindowManager.LayoutParams initLayoutParams(int viewHeight) {
        WindowManager.LayoutParams adWindowParams = new WindowManager.LayoutParams();
        adWindowParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;
        adWindowParams.format = PixelFormat.RGBA_8888;
        adWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams
                .FLAG_LAYOUT_NO_LIMITS;

        adWindowParams.width = 100;
//        adWindowParams.height = 100;
//        adWindowParams.gravity = Gravity.TOP;
        adWindowParams.gravity = Gravity.FILL_VERTICAL;
        adWindowParams.windowAnimations = android.R.style.Animation_InputMethod;
//        adWindowParams.y = viewHeight;
        return adWindowParams;
    }

    private WindowManager.LayoutParams getLayoutParams() {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE            //
//                // 使window不能获得焦点，这样就不能向该window发送按键事件及按钮事件(back、menu等)
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE                 //
//                // 使window不接受触摸屏事件,即window不拦截触摸事件
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL               //
//                // 即使在该window在可获得焦点情况下，仍然把该window之外的任何event发送到该window之后的其他window.
//                | WindowManager.LayoutParams.FLAG_FULLSCREEN
//                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        ;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE            //
//                // 使window不能获得焦点，这样就不能向该window发送按键事件及按钮事件(back、menu等)
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE                 //
//                // 使window不接受触摸屏事件,即window不拦截触摸事件
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL               //
//                // 即使在该window在可获得焦点情况下，仍然把该window之外的任何event发送到该window之后的其他window.
//                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams
//                .FLAG_WATCH_OUTSIDE_TOUCH;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager
//                .LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams
//                .FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
//                WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams
//                .FLAG_LAYOUT_INSET_DECOR;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
//        params.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams
//                .FLAG_LAYOUT_IN_SCREEN;
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {              // 19以上透明通知栏和虚拟键
//            Point p = new Point();
//            mWindowManager.getDefaultDisplay().getRealSize(p);
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = 200;
            params.gravity = Gravity.TOP;
//            params.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS  // SDK >=
//                    // 19才能使用，半透明status_bar
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION    // SDK >=
            // 19才能使用，半透明navigation_bar
            ;
        } else {
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
        }
//        params.windowAnimations = R.style.default_style;
//        params.systemUiVisibility = (Build.VERSION.SDK_INT >= 19 ? 0x1606 : 0x1604);
//        params.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View
//                .SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View
//                .SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LOW_PROFILE;
//        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View
//                .SYSTEM_UI_FLAG_LOW_PROFILE;
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN;
        params.format = PixelFormat.RGBA_8888;
//        if (Build.VERSION.SDK_INT > 24 || Build.VERSION.SDK_INT <= Build.VERSION_CODES
//                .JELLY_BEAN_MR2) {
//            params.type = WindowManager.LayoutParams.TYPE_PHONE;
//        } else {
//            params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        }
//        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        if (Build.VERSION.SDK_INT >= 23
                && !Settings.canDrawOverlays(TestApp.getInstance())) {
            params.type = WindowManager.LayoutParams.TYPE_TOAST;
        }
        return params;
    }

    PopupWindow popupWindow = null;

    @OnClick(R.id.test_notify)
    public void onTestNotifyClicked() {
        addWindowManager();
//        root.setPadding(0, 0, 0, 0);
//        showDialog(TestApp.getInstance());
////        showDialog(this);
//        popupWindow = new PopupWindow(LayoutInflater.from(TestApp.getInstance()).inflate(R.layout
//                .activity_test_touch, null), 100, 100);
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                Log.e("chengjian", "popupWindow onDismiss: ");
//            }
//        });
//        Log.e("chengjian", "popupWindow testNotify: =" + testNotify.getWindowToken() + " ff=" +
//                getWindow().getDecorView().getWindowToken());
////        popupWindow.showAsDropDown(testNotify);
////        popupWindow.setOutsideTouchable(false);
////        finish();
////        myHandler.sendEmptyMessageDelayed(1, 3000);
//        NotificationBuilderCompat builder = new NotificationBuilderCompat(this);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(
//                this,
//                0,
//                new Intent(),
//                PendingIntent.FLAG_CANCEL_CURRENT);
//
//        builder.setPriority(NotificationBuilderCompat.PRIORITY_MAX)
//                .setVisibility(NotificationBuilderCompat.VISIBILITY_PUBLIC)
//                .setWhen(2147483647L)
//                .setOngoing(true)
//                .setAutoCancel(true)
//                .setSmallIcon(R.drawable.aa)
//                .setContentIntent(pendingIntent);
//        RemoteViews remoteViews = new RemoteViews(getPackageName(),
//                R.layout.activity_test_remoteview_one);
//        remoteViews.setImageViewResource(R.id.ic_close, R.drawable.ic_close);
////        int requestCode = 0;
////        initBroadcastIntent(remoteViews, R.id.notification_tab2, requestCode++);
////        initBroadcastIntent(remoteViews, R.id.notification_tab3, requestCode++);
////        initBroadcastIntent(remoteViews, R.id.notification_tab4, requestCode++);
////        initBroadcastIntent(remoteViews, R.id.notification_tab6, requestCode++);
////        //初始化省电按钮点击事件
////        initBroadcastIntent(remoteViews, R.id.notification_tab7, requestCode++);
//        builder.setContent(remoteViews);
//        Notification notification = builder.build();
//        mNotificationManager.notify(1000, notification);
    }

    private void initBroadcastIntent(RemoteViews remoteViews, int viewId,
                                     int requestCode) {
        Intent intent = new Intent("android.intent.action.mystaticreceiver");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(viewId, pendingIntent);
    }

    public void test(@NotNull String aa) {

    }

    @OnClick(R.id.touch_area1)
    public void onTouchArea1Clicked() {
        test(null);
    }

    @OnClick(R.id.img)
    public void onImgClicked() {
        touchArea.addView(img);
    }

    @OnClick(R.id.img2)
    public void onImg2Clicked() {
    }

    //    @OnClick(R.id.text)
//    public void onTextClicked() {
//    }
    @OnClick(R.id.text_id)
    public void onTextIDClicked() {
        Log.e(TAG, "onTextIDClicked: width=" + textId.getWidth() + " height=" + textId.getHeight());
    }

    @OnClick(R.id.touch_area)
    public void onTouchAreaClicked() {
    }

    @OnClick(R.id.test_content)
    public void onTestContentClicked() {
    }

    private Bitmap mOriginal;

    @OnClick(R.id.cancel_notify)
    public void onCancelNotify() {
        addWindowManager();
//        root.setBackground(new BitmapDrawable(mBitmap));
//        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.biggest_1);
//        Log.e(TAG, "onCancelNotify: dddddd=" + original);
//        popupWindow.dismiss();
//        if (mNotificationManager != null) {
//            try {
//                mNotificationManager.cancel(1000);
//            } catch (Exception e) {
//            }
//        }
    }

//    static {
//        try {
//            System.load(LETV_AD_SDK_UPD_PATH);
//        } catch (Exception e) {
//            Log.e(TAG, "LETV_AD_SDK_UPD_PATH ee=" + e);
//            // 如果新库文件不能成功加载,则删除
//            System.loadLibrary("dddd");
//        } catch (Error r) {
//            Log.e(TAG, "LETV_AD_SDK_UPD_PATH error=" + r);
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
    private class MyHandler extends Handler {
        private WeakReference<Activity> reference;

        public MyHandler(Activity activity) {
            reference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            PowerManager pm = (PowerManager) reference.get().getSystemService(Context
                    .POWER_SERVICE);
//如果不是在Activity里面需要得到当时的上下文句柄 用context.getSystemService...
            boolean isScreenOn = pm.isInteractive();
            KeyguardManager mKeyguardManager = (KeyguardManager) reference.get().getSystemService
                    (Context
                            .KEYGUARD_SERVICE);
            boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
            Log.e(TAG, "handleMessage: isScreenOn=" + isScreenOn + " flag=" + flag);
            Log.e(TAG, "handleMessage activity=" + reference.get());
            if (msg.what == 1) {
//                reference.get().finish();
                Log.e(TAG, "handleMessage mDialog.isShowing()=" + mDialog.isShowing());
                finish();
                myHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        mDiaLog.eismiss();
                        try {
                            popupWindow.showAsDropDown(testNotify);
                        } finally {
                            Log.e(TAG, "handleMessage111 mDialog.isShowing()=" + mDialog
                                    .isShowing());
                        }
                    }
                }, 200);
//                showDialog(TestTouchActivity.this);
            }
        }
    }

    MyDialog mDialog;

    void showDialog(Context context) {
        mDialog = new MyDialog(context);
        mDialog.setTitle("dgsg");
        mDialog.setContentView(R.layout.activity_test_touch);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                Log.e("chengjian", "onDismiss: ");
            }
        });
        mDialog.show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(Context
                .KEYGUARD_SERVICE);
        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
        Log.e(TAG, "onWindowFocusChanged: hasFocus=" + hasFocus + " flag=" + flag);
    }

    private TestRelativeLayout mLinearLayout;
    private TestTextView mTextView;
    MyHandler myHandler;

    public static void setNaviAndStatusBackground(Activity activity/*, int additionalFlags*/) {
        int flags = 0;
        if (Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
            flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        } else if (Build.VERSION.SDK_INT >= 21) {
            flags |= WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;
        }
        activity.getWindow().addFlags(flags);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

    public void setFullScreen(boolean isFullScreen) {
        if (isFullScreen) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 底部虚拟按键栏的高度
     *
     * @return
     */
    public int getSoftButtonsBarHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        //这个方法获取可能不是真实屏幕的高度
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;
        //获取当前屏幕的真实高度
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;
        if (realHeight > usableHeight) {
            return realHeight - usableHeight;
        } else {
            return 0;
        }
    }

    private Bitmap mBitmap = null;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(12);
        requestWindowFeature(13);
        getSoftButtonsBarHeight();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐去标题栏（应用程序的名字）
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐去状态栏部分(电池等图标和一切修饰部分)
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setFullScreen(true);
//        int flags =/* WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//                | */WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        int flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
//        setNaviAndStatusBackground(this);
//        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////设置状态栏颜色
//        getWindow().setStatusBarColor(statusColor);
        // getResources().getDrawable(R.drawable.ad_pause_del);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION |
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | 0x00001000);
        setContentView(R.layout.activity_test_touch);
        ButterKnife.bind(this);


        View view = findViewById(R.id.test_content);
//        view.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View
// .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        testContent.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        root.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION |
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION |
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        getWindow().setNavigationBarColor(0);
//        getWindow().setStatusBarColor(0);
//        Window window = getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 状态栏（以上几行代码必须，参考setStatusBarColor|setNavigationBarColor方法源码）
//        window.setStatusBarColor(Color.TRANSPARENT);
//        // 虚拟导航键
//        window.setNavigationBarColor(Color.TRANSPARENT);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        hideBottomUIMenu();
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ButterKnife.bind(this);
        mWindowManager = (WindowManager) getSystemService
                (Context.WINDOW_SERVICE);
//        popupWindow = new PopupWindow(LayoutInflater.from(TestApp.getInstance()).inflate(R.layout
//                .activity_test_touch, null), 100, 100);
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                Log.e("chengjian", "popupWindow onDismiss: ");
//            }
//        });
//        Log.e("chengjian", "popupWindow testNotify: =" + testNotify.getWindowToken() + " ff=" +
//                getWindow().getDecorView().getWindowToken());
//        popupWindow.showAsDropDown(testNotify);
//        final Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Bitmap original1 = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.aa, options);
        int height = original.getHeight();
        int width = original.getWidth();
        int x = (width - height / 2) / 2;
        mBitmap = Bitmap.createBitmap(original, 0, 0, height / 2, height / 2);
        final Bitmap b = Bitmap.createBitmap(148, 148, Bitmap.Config.ARGB_8888);
//        Bitmap original2 = Bitmap.createBitmap(original1, 0, 0, 1000, 2000);
//        Drawable drawable = getResources().getDrawable(R.drawable.progress_btn_bg,null);
//        Drawable drawable = getResources().getDrawable(R.drawable.preview_background, null);
//        drawable.setColorFilter(0x8F0000ff, PorterDuff.Mode.SRC_OVER);
//        drawable.clearColorFilter();
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
        canvas.drawBitmap(original, null, new RectF(0, 0, 148, 148), null);
//        new BitmapDrawable(original).draw(canvas);
//        canvas.setBitmap(null);
        ((ImageView) findViewById(R.id.img)).setImageBitmap(b);
//        ((ImageView) findViewById(R.id.img)).setImageDrawable(drawable);
//        final Bitmap bb = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
//        canvas.setBitmap(bb);
//        canvas.translate(50, 50);
//        canvas.drawBitmap(original, 0, 0, null);
//        ((ImageView) findViewById(R.id.img2)).setImageBitmap(bb);
        Log.e(TAG, "onCreate this11=" + this + "=" + TestA.class);
        // mTextView = (TestTextView) findViewById(R.id.text);
        // mLinearLayout = (TestRelativeLayout) findViewById(R.id.touch_area);
        // Log.e(TAG, "onCreate visible=" + mTextView.getVisibility());
        // Button cv = (Button)findViewById(R.id.hide_cv);
        // cv.setOnClickListener(this);
        // Button pv = (Button)findViewById(R.id.hide_pv);
        // pv.setOnClickListener(this);
//        myHandler = new MyHandler(this);
//        myHandler.sendEmptyMessageDelayed(0, 5000);
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
        // // Log.e(TAG, "onCreate android_id=" + getAndroidId());
        // Log.e(TAG, "onCreate CallingPackage=" + getCallingPackage());
        // Log.e(TAG, "onCreate ddd=" +
        // System.getProperty("java.library.path"));
        // Log.e(TAG,
        // "onCreate classLoad.getSystemClassLoader()=" +
        // ClassLoader.getSystemClassLoader());
        // Log.e(TAG,
        // "onCreate classLoad.getSystemClassLoader().parent="
        // + ClassLoader.getSystemClassLoader().getParent());
        Log.e(TAG,
                "onCreate getClassLoader="
                        + getClassLoader().getResourceAsStream(
                        "res/drawable-hdpi-v4/ad_pause_del.png"));
        // Log.e(TAG, "onCreate getClassLoader.parent=" +
        // getClassLoader().getParent());
        // Log.e(TAG, "onCreate System.loadLibrary=" +
        // System.class.getClassLoader());
        // Log.e(TAG, "onCreate file=" + file.getAbsolutePath());
        // Log.e(TAG, "onCreate file.getPath=" + file.getPath());
        // Log.e(TAG, "onCreate file.exists=" + file.exists());
        // TestLib testLib = new TestLib();
        // Log.e(TAG, "onCreate testLib=" + testLib.getPic(this));
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
        UnlockBroadcastReceiver unlockBroadcastReceiver = new UnlockBroadcastReceiver();
        if (unlockBroadcastReceiver != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_USER_PRESENT);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            filter.addAction(Intent.ACTION_SCREEN_ON);
            registerReceiver(unlockBroadcastReceiver, filter);
        }
        getContentResolver().registerContentObserver(Settings.System.getUriFor
                ("navigationbar_is_min"), true, mNavigationStatusObserver);
    }

    private ContentObserver mNavigationStatusObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            int navigationBarIsMin = Settings.System.getInt(getContentResolver(),
                    "navigationbar_is_min", 0);
            if (navigationBarIsMin == 1) {//导航键隐藏了
                Log.e(TAG, "-----导航键隐藏了");
            } else {//导航键显示了
                Log.e(TAG, "-----导航键显示了");
            }
        }
    };

    class UnlockBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e(TAG, "onReceive: action=" + action);
            KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(Context
                    .KEYGUARD_SERVICE);
            boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();

            Log.e(TAG, "onReceive: lock flag=" + flag);
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION |
//                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(-2147483648);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
//        setNaviAndStatusBackground(this);

        setupTransparentSystemBarsForLollipop();
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * Sets up transparent navigation and status bars in Lollipop.
     * This method is a no-op for other platform versions.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupTransparentSystemBarsForLollipop() {
        Window window = getWindow();
        window.getAttributes().systemUiVisibility |=
                (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        Log.e(TAG, "finalize this=" + this);
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
        Log.e(TAG, "md5 result=" + result);
        return result;
    }

    TranslateAnimation translateAnimation;

    @Override
    protected void onResume() {
        super.onResume();
//        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
////如果不是在Activity里面需要得到当时的上下文句柄 用context.getSystemService...
//        boolean isScreenOn = pm.isInteractive();
//        KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(Context
//                .KEYGUARD_SERVICE);
//        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
//
//        Log.e(TAG, "onResume: isScreenOn=" + isScreenOn + " flag=" + flag);
////        myHandler.sendEmptyMessageDelayed(1, 300);
////        Log.e(TAG, "onResume: ");
//        translateAnimation = new TranslateAnimation(200, 400, 100, 600);
//        translateAnimation = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
//        translateAnimation.setDuration(3600);
//        translateAnimation.setFillEnabled(true);
////        translateAnimation.setFillBefore(true);
//        translateAnimation.setFillBefore(true);
//        myHandler.sendEmptyMessage(0);
//        translateAnimation.setFillAfter(true);
    }

    // @Override
    // public boolean onTouch(View v, MotionEvent event) {
    // Log.e(TAG, "onTouch v=" + v + " action=" + event.getAction());
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
    // // Log.e(TAG, "onTouch file1 path=" + file1.getPath());
    // // Log.e(TAG, "onTouch file1 exists=" + file1.exists());
    // // Log.e(TAG,
    // // "onTouch file1 isDirectory="
    // // + file1.isDirectory());
    // // if (!file1.exists()) {
    // // boolean isSuccess = file1.mkdirs();
    // // Log.e(TAG, "onTouch isSuccess=" + isSuccess);
    // // }
    // // };
    // // }.start();
    // // }
    // // // Exception exception = new Exception("erroro");
    // // // exception.fillInStackTrace();
    // // // Log.e(TAG, "exception=" + exception);
    // // // Log.e(TAG, Log.getStackTraceString(new
    // // Throwable("fffff")));
    // // Exception re = new RuntimeException();
    // // re.fillInStackTrace();
    // // // Log.e(TAG, "stackTrace", re);
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
    // // // Log.e(TAG, "onTouch getAbsolutePath=" +
    // // // file1.getAbsolutePath());
    // // // Log.e(TAG, "onTouch getPath=" + file1.getPath());
    // // // Log.e(TAG, "onTouch exists=" + file1.exists());
    // // // File file1 = new
    // // // File(Environment.getExternalStorageDirectory()
    // // // + path3);
    // // // Log.e(TAG, "onTouch file1 path=" + file1.getPath());
    // // // Log.e(TAG, "onTouch file1 exists=" + file1.exists());
    // // // Log.e(TAG, "onTouch file1 isDirectory=" +
    // // // file1.isDirectory());
    // // // if (!file1.exists()) {
    // // // boolean isSuccess = file1.mkdirs();
    // // // Log.e(TAG, "onTouch isSuccess=" + isSuccess);
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
    // // // Log.e(TAG, "onTouch=" + e);
    // // // }
    // //
    // // // Log.e(TAG, "getX=" + event.getX());
    // // // Log.e(TAG, "getY=" + event.getY());
    // // // Log.e(TAG, "getRawX=" + event.getRawX());
    // // // Log.e(TAG, "getRawY=" + event.getRawY());
    // // // Log.e(TAG, "v.getBottom()=" + v.getBottom());
    // // // Log.e(TAG, "v.getheight=" + v.getHeight());
    // // // Log.e(TAG,
    // // // "oncreat = "
    // // // + getResources().getDimension(
    // // // R.dimen.activity_vertical_margin));
    // // }
    // break;
    // }
    // case R.id.touch_area1: {
    // // if (MotionEvent.ACTION_UP == event.getAction()) {
    // // Log.e(TAG, "getX11=" + event.getX());
    // // Log.e(TAG, "getY11=" + event.getY());
    // // Log.e(TAG, "getRawX11=" + event.getRawX());
    // // Log.e(TAG, "getRawY11=" + event.getRawY());
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
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//如果不是在Activity里面需要得到当时的上下文句柄 用context.getSystemService...
        boolean isScreenOn = pm.isScreenOn();
        KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(Context
                .KEYGUARD_SERVICE);
        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
        Log.e(TAG, "onPause: isScreenOn=" + isScreenOn + " flag=" + flag + " isScreenoffPause=" +
                (flag || (!isScreenOn)));
        try {
            throw new MyException();
        } catch (MyException e) {

        }
        // boolean ss = isKeyGuard(TestTouchActivity.this);
        // Log.e(TAG, "onPause isKeyGuard ss=" + ss);
        // mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.e(TAG, "onDestroy=" + 11);
        // mHandler.removeMessages(0);
    }

    // private Handler mHandler = new Handler() {
    // public void handleMessage(android.os.Message msg) {
    // // boolean ss = isKeyGuard(TestTouchActivity.this);
    // Log.e(TAG, "isKeyGuard ss=" + 11);
    // };
    // };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "Activity onTouchEvent action=" + event.getAction());
        boolean handle = super.onTouchEvent(event);
        Log.e(TAG, "Activity onTouchEvent handle=" + handle);
        return handle;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent: ");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "Activity dispatchTouchEvent action=" + ev.getAction());
        boolean handle = super.dispatchTouchEvent(ev);
        Log.e(TAG, "Activity dispatchTouchEvent handle=" + handle);
//        final Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
//        Drawable drawable = new BitmapDrawable(original);
//        drawable.clearColorFilter();
//        ((ImageView) findViewById(R.id.img)).clearColorFilter();
//        new AlertDialog.Builder(this).setMessage("fdsdffdf")
//                .create().show();
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
            Log.e(TAG, "isKeyGuard ex=" + ex);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File apkFile = new File(Environment.getExternalStorageDirectory() + "/Download/" + "app.apk");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            install.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(this, "应用报名.fileProvider", apkFile);
            install.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            install.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android" +
                    ".package-archive");
        }

        startActivity(install);
        // TODO Auto-generated method stub
        int id = v.getId();
        Exception exception = new Exception("onClick");
        Log.e(TAG, "onClick v=" + v, exception);
//        switch (id) {
//            case R.id.img0: {
////                findViewById(R.id.img0).offsetTopAndBottom(-findViewById(R.id.img0).getHeight
/// () /
////                        2);
//                Log.e(TAG, "onClick 11=" + findViewById(R.id.img0).getTop());
////                findViewById(R.id.img0).setTranslationY(findViewById(R.id.img0).getHeight()*2);
////                findViewById(R.id.img0).requestLayout();
//                Log.e(TAG, "onClick 22=" + findViewById(R.id.img0).getTop());
//                findViewById(R.id.img0).startAnimation(translateAnimation);
//                break;
//            }
//        }
        // switch (id) {
        // case R.id.hide_cv: {
        // Log.e(TAG, "hide_cv");
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
        // Log.e(TAG, "hide_pv cv=" + mTextView.getVisibility());
        // break;
        // }
        // }
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
            decorView.setSystemUiVisibility(uiOptions);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
