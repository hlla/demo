package letv.com.testanr;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyService extends IntentService {
    private static final String TAG = "Testanr_MyService";
    public static final int NOTIFICATION_ID = 11111;
    public static final String KEY_IS_FOREGROUND = "is_foreground";
    public static final String KEY_IS_CONTENT = "content";

    public MyService() {
        super("dfdsfdfd");
    }

//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//        Log.d(TAG, "onHandleIntent: intent=" + intent);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        int pid = intent.getIntExtra("pid", -1);
////        Process.killProcess(pid);
//    }

    private RemoteCallbackList<ICallback> mCallbacks = new RemoteCallbackList<ICallback>() {
        @Override
        public void onCallbackDied(ICallback callback) {
            super.onCallbackDied(callback);
            Log.d(TAG, "onCallbackDied: callback=" + callback);
        }

        @Override
        public void onCallbackDied(ICallback callback, Object cookie) {
            super.onCallbackDied(callback, cookie);
            Log.d(TAG, "onCallbackDied: callback=" + callback + " cookie=" + cookie);
        }
    };

    private ITestbinder.Stub iTestbinder = new ITestbinder.Stub() {

        @Override
        public int getAdId(String aa) throws RemoteException {
            Log.d(MyService.TAG, "getAdId: ");
//            notifyResult("ffff");
            try {
                Thread.currentThread().sleep(1500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 11111;
        }

        @Override
        public void testCall(List<School> ssss) throws RemoteException {
//            RuntimeException runtimeException = new RuntimeException("testCall");
            Log.d(MyService.TAG, "testCall: ");
            try {
                Thread.sleep(1500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(MyService.TAG, "testCall: end");
//            throw runtimeException;
        }

        @Override
        public List<School> test(School sc) throws RemoteException {
            Log.d(MyService.TAG, "test: ");
            return null;
        }

        @Override
        public void testSchool(School sc) throws RemoteException {
            Log.d(MyService.TAG, "testSchool: ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(MyService.TAG, "testSchool: end");
        }

        @Override
        public School[] testArray(School sc) throws RemoteException {
            return new School[0];
        }

        @Override
        public void unregisterCallback(ICallback cb) throws RemoteException {
            Log.d(MyService.TAG, "unregisterCallback: ");
            mCallbacks.unregister(cb);
        }

        @Override
        public void registerCallback(ICallback cb) throws RemoteException {
            Log.d(MyService.TAG, "registerCallback: ");
            mCallbacks.register(cb);
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private void notifyResult(String result) {
        final int len = mCallbacks.beginBroadcast();
        for (int i = 0; i < len; i++) {
            try {
                // 通知回调
                mCallbacks.getBroadcastItem(i).showResult(result);
                mCallbacks.getBroadcastItem(i).showTestResult(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        mCallbacks.finishBroadcast();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        Notification.Builder builder = new Notification.Builder(this);
//        String content = intent.getStringExtra(KEY_IS_CONTENT);
        builder.setContentText("gfhgfhghgf");
        builder.setContentTitle("this is Content title");
//        builder.setPriority(Notification.);
//        builder.setTicker("this is ticker");
        builder.setSmallIcon(R.drawable.ic_launcher);
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
//        startForeground(NOTIFICATION_ID, new Notification());
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
        Log.e(TAG, "onStartCommand 11: startId=" + startId + " intent=" + intent);
//        Log.d(TAG, "onCreate: ");
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
        builder.setSmallIcon(R.drawable.ic_launcher);
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
//        Intent intent1 = new Intent(this, MessengerService.class);
//        startService(intent1);
//        startForeground(NOTIFICATION_ID, new Notification());
//        stopForeground(true);
//        stopSelf();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.d(TAG, "queueIdle: ");
//                Process.killProcess(Process.myPid());
                stopSelf();
                return false;
            }
        });
//        }
//        try {
//            Thread.currentThread().sleep(22000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int resultCode = super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand end: startId=" + startId + " resultCode=" + resultCode);
        return START_NOT_STICKY;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind 11: intent=" + intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
//        Log.d(TAG, "onHandleIntent: intent=" + intent);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int pid = intent.getIntExtra("pid", -1);
//        Process.killProcess(pid);
//        Exception exception = new Exception("onBind");
//        Log.d(TAG, "onBind 11: intent=" + intent + " iTestbinder=" + iTestbinder, exception);
//        RuntimeException runtimeException = new RuntimeException("onBind");
//        throw runtimeException;
        return iTestbinder;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e(TAG, "onHandleIntent intent=" + intent);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        System.exit(0);
    }
}
