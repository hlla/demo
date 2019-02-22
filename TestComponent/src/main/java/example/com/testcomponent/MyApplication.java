package example.com.testcomponent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

//import android.os.SystemProperties;

/**
 * Created by chengjian on 18-4-19.
 */

public class MyApplication extends MultiDexApplication {
    private static final String TAG = "TestComponent1_App";
    public static final String SOCK_NAME = "test_abc";

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
        if (FixDexUtil.isGoingToFix(this)) {
            FixDexUtil.loadFixedDex(this, Environment.getExternalStorageDirectory());
        }
        Log.d(TAG, "application: onCreate()");
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll()
                    .build();
            StrictMode.setThreadPolicy(policy);
        }
        PackageManager pm = getPackageManager();
//        if (getPackageName().equalsIgnoreCase(LetvUtils.getProcessName(this, Process.myPid()))) {
//            SharedPreferences sharedPreferences = getSharedPreferences("abc", Context
//                    .MODE_MULTI_PROCESS);
//            boolean isAgree = sharedPreferences.getBoolean("debug.agree", false);
//
//            if (!isAgree) {
//                Intent intent = new Intent(this, OuterShellActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                LocalServerSocket serverSocket = null;
//                try {
//                    serverSocket = new LocalServerSocket(SOCK_NAME);
//                    Log.d(TAG, "onCreate: accept before");
//                    serverSocket.accept();
//                    Log.d(TAG, "onCreate: accept end");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "application: onCreate() socket=" + e);
//                } finally {
//                    if (null != serverSocket) {
//                        try {
//                            serverSocket.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//            SharedPreferences sp = getSharedPreferences("abc", Context
//                    .MODE_MULTI_PROCESS);
//            boolean isAgreea = sp.getBoolean("debug.agree", false);
//            Log.d(TAG, "onCreate: isAgreea=" + isAgreea);
//        }
//        if (isEuro) {
//            Intent intent = new Intent(this, SplashActivity.class);
//            startActivity(intent);
//        }
//        isEuro = SystemProperties.getBoolean("debug.test.euro", false);
        if (true)

        {
//            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
//                            ".MyStaticReceiverA"),
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager
// .DONT_KILL_APP);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            intentFilter.addAction(TestComponentActivity.MAIN_PROCESS_ACTION);
//            LocalBroadcastManager.getInstance(this).registerReceiver(
//                    new MyStaticReceiverA(), intentFilter
//            );
            registerReceiver(new MyStaticReceiverA(), intentFilter);
        } else

        {
            pm.setComponentEnabledSetting(new ComponentName(this, "example.com.testcomponent" +
                            ".MyStaticReceiverA"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        }
    }
}
