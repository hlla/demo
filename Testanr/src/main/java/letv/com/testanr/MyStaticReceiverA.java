package letv.com.testanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyStaticReceiverA extends BroadcastReceiver {
    private static final String TAG = "Testanr_MySRA";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
