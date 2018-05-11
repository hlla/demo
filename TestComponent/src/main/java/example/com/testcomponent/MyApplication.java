package example.com.testcomponent;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by chengjian on 18-4-19.
 */

public class MyApplication extends Application {
    private static final String TAG = "TestComponent1_App";

    //    TestStaticA Te=new TestStaticA();
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        Log.d(TAG, "attachBaseContext: start getClassLoader()=" + getClassLoader());
//        try {
////            getClassLoader().loadClass("example.com.testcomponent.statics.TestStaticA");
//            Class.forName("example.com.testcomponent.statics.TestStaticA");
////            Log.d(TAG, "attachBaseContext: " + new TestStaticA());
////            Log.d(TAG, "attachBaseContext: " + TestStaticA.c);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "attachBaseContext: e=" + e);
//        }
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        Log.d(TAG, "attachBaseContext: end");
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "application: onCreate()");
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        boolean isEuro = sharedPreferences.getBoolean("debug.test.euro", false);
        PackageManager pm = getPackageManager();
        isEuro = SystemProperties.getBoolean("debug.test.euro", false);
        if (isEuro) {
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".MyStaticReceiverA"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            LocalBroadcastManager.getInstance(this).registerReceiver(
                    new MyStaticReceiverA(), intentFilter
            );
        } else {
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".MyStaticReceiverA"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        }
    }
}
