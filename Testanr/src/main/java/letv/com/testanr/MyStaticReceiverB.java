package letv.com.testanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyStaticReceiverB extends BroadcastReceiver {
    private static final String TAG = "Testanr_MySRB";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:=" + intent.getStringExtra("abc"));
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.currentThread().sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
