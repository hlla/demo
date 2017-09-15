package letv.com.testanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyDynamicReceiverA extends BroadcastReceiver {
    private static final String TAG = "Testanr_MyDRA";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:");
//        try {
//            Thread.currentThread().sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onReceive 1:");
    }
}
