package letv.com.testanr;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import static letv.com.testanr.MyActivity.ACTION_DYNAMIC;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyService extends Service {
    private static final String TAG = "Testanr_MyService";
    public static final int NOTIFICATION_ID = 11111;

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
            notifyResult("ffff");
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 11111;
        }

        @Override
        public void testCall(List<School> ssss) throws RemoteException {
            Log.d(MyService.TAG, "testCall: ");
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(MyService.TAG, "testCall: end");
        }

        @Override
        public List<School> test(School sc) throws RemoteException {
            Log.d(MyService.TAG, "test: ");
            return null;
        }

        @Override
        public void testSchool(School sc) throws RemoteException {
            Log.d(MyService.TAG, "testSchool: ");
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
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setTicker("ffffff").setSmallIcon(R.mipmap.ic_launcher);
//        startForeground(NOTIFICATION_ID, builder.build());
        IntentFilter intentFilter = new IntentFilter(ACTION_DYNAMIC);
        MyDynamicReceiverB myDynamicReceiverB = new MyDynamicReceiverB();
        registerReceiver(myDynamicReceiverB, intentFilter);
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
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setTicker("ffffff").setSmallIcon(R.mipmap.ic_launcher);
//        Intent innerIntent = new Intent(this, GrayInnerService.class);
//        startService(innerIntent);
//        startForeground(NOTIFICATION_ID, new Notification());
//        try {
//            Thread.currentThread().sleep(22000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int resultCode = super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand end: startId=" + startId + " resultCode=" + resultCode);
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind 11: intent=" + intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind 11: intent=" + intent + " iTestbinder=" + iTestbinder);
        return iTestbinder;
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
}
