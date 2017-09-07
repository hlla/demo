package letv.com.testanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyDynamicReceiverB extends BroadcastReceiver {
    private static final String TAG = "Testanr_MyDRB";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:");
    }
}
