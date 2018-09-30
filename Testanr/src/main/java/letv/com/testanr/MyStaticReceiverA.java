package letv.com.testanr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;


/**
 * Created by chengjian on 17/5/31.
 */

public class MyStaticReceiverA extends BroadcastReceiver {
    private static final String TAG = "Testanr_MySRA";
    private Handler mHandler = new Handler();

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG, "onReceive: action=" + intent.getAction());
//        abortBroadcast();
//        try {
//            Thread.sleep(22000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(15000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Log.d(TAG, "run: startService");
                Intent intent1 = new Intent(context, MyService.class);
                intent1.putExtra("abc", "cj");
                context.startForegroundService(intent1);
            }
        }.start();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//        Log.d(TAG, "run: startService");
//        Intent intent1 = new Intent(context, MyService.class);
//        intent1.putExtra("abc", "cj");
//        context.startService(intent1);
//            }
//        }, 10000);
//        try {
//            Thread.sleep(32000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
