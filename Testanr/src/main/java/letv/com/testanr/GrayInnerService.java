package letv.com.testanr;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static letv.com.testanr.MyActivity.ACTION_DYNAMIC;

/**
 * Created by chengjian on 17/5/31.
 */

public class GrayInnerService extends Service {
    private static final String TAG = "Testanr_GrayIS";
    public static final int NOTIFICATION_ID = 11111;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        IntentFilter intentFilter = new IntentFilter(ACTION_DYNAMIC);
        MyDynamicReceiverB myDynamicReceiverB = new MyDynamicReceiverB();
        registerReceiver(myDynamicReceiverB, intentFilter);
//        try {
//            Thread.currentThread().sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onCreate 11: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand 11: startId=" + startId);
        startForeground(NOTIFICATION_ID, new Notification());
        stopForeground(true);
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
