package letv.com.testanr

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemProperties
import android.util.Log

/**
 * Created by chengjian on 17/5/31.
 */

class GrayInnerService : Service() {

    override fun onCreate() {
        super.onCreate()
        SystemProperties.get("gdfg")
        Log.d(TAG, "onCreate: ")
//        val intentFilter = IntentFilter(ACTION_DYNAMIC)
//        val myDynamicReceiverB = MyDynamicReceiverB()
//        registerReceiver(myDynamicReceiverB, intentFilter)
        //        try {
        //            Thread.currentThread().sleep(4000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        Log.d(TAG, "onCreate 11: ")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand 11: startId=$startId")
        //        startForeground(NOTIFICATION_ID, new Notification());
        //        stopForeground(true);
        //        stopSelf();
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private val TAG = "Testanr_GrayIS"
        val NOTIFICATION_ID = 11111
    }
}
