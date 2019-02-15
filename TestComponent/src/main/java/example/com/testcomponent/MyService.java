package example.com.testcomponent;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyService extends Service {
    private static final String TAG = "TestComponent_MyService";
    public static final int NOTIFICATION_ID = 11111;
    public static final String KEY_IS_FOREGROUND = "is_foreground";
    public static final String KEY_IS_CONTENT = "content";
    private SharedPreferences mSp;
    private IMyAidlInterface.Stub iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void test(int a) throws RemoteException {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap<String, ?> values = (HashMap) mSp.getAll();
            Random random = new Random();
            int next = random.nextInt(100);
            Log.d(TAG, "test: values=" + values + " next=" + next);
            mSp.edit().putLong("haha", next).apply();

        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mSp = getSharedPreferences("cj_file", MODE_MULTI_PROCESS);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setTicker("ffffff").setSmallIcon(R.mipmap.ic_launcher);
//        startForeground(NOTIFICATION_ID, new Notification());
//        IntentFilter intentFilter = new IntentFilter(ACTION_DYNAMIC);
//        MyDynamicReceiverB myDynamicReceiverB = new MyDynamicReceiverB();
//        registerReceiver(myDynamicReceiverB, intentFilter);
//        try {
//            Thread.currentThread().sleep(22000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onCreate 11: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand 11: startId=" + startId + " intent=" + intent);
//        builder.build().defaults |= Notification.DEFAULT_VIBRATE;
//        builder.build().defaults |= Notification.DEFAULT_SOUND;
//        builder.build().defaults |= Notification.DEFAULT_LIGHTS;
        // 显示通知
//        nm.notify(1, builder.build());
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setTicker("ffffff").setSmallIcon(R.mipmap.ic_launcher);
//        Intent innerIntent = new Intent(this, GrayInnerService.class);
//        startService(innerIntent);
//        if (intent.getBooleanExtra(KEY_IS_FOREGROUND, false)) {
        Notification.Builder builder = new Notification.Builder(this);
        String content = intent.getStringExtra(KEY_IS_CONTENT);
        builder.setContentText(content);
        builder.setContentTitle("this is Content title");
//        builder.setPriority(Notification.);
//        builder.setTicker("this is ticker");
        builder.setSmallIcon(R.drawable.aa);
        builder.setPriority(Notification.PRIORITY_MAX);
        final NotificationManager nm = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            //只在Android O之上需要渠道
            NotificationChannel notificationChannel = new NotificationChannel("sdfdsfd",
                    "dd", NotificationManager.IMPORTANCE_DEFAULT);
            builder.setChannelId("sdfdsfd");
            notificationChannel.setDescription("this is test");
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(Color.RED);
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，
            //通知才能正常弹出
            nm.createNotificationChannel(notificationChannel);
        }
//        startForeground(NOTIFICATION_ID, builder.build());
//            startForeground(NOTIFICATION_ID, new Notification());
//        stopForeground(true);
//        stopSelf();
//        }
//        try {
//            Thread.currentThread().sleep(22000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int resultCode = super.onStartCommand(intent, flags, startId);
//        Log.d(TAG, "onStartCommand end: startId=" + startId + " resultCode=" + resultCode);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind 11: intent=" + intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind 11: intent=" + intent);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind intent=" + intent);
        return iMyAidlInterface;
    }
}
