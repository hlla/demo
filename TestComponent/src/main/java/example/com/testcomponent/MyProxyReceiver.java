package example.com.testcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyProxyReceiver extends BroadcastReceiver {
    private static final String TAG = "TestComponent1_Proxy";

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Log.d(TAG, "onReceive: action=" + intent.getAction());
        new Thread() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        };
//        abortBroadcast();
//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
