package letv.com.testanr;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import letv.com.testanr.util.LetvUtils;

/**
 * Created by chengjian on 17/6/2.
 */

public class MyApplication extends Application {
    private static final String TAG = "Testanr_MyApplication";
    private static final String LOAD_DEX_PROCESS_NAME = "letv.com.testanr:loading";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Exception exception = new Exception("attachBaseContext");
        exception.printStackTrace();
        Log.d(TAG, "attachBaseContext: pid=" + Process.myPid(), exception);
        boolean isLoadDexProcess = isLoadDexProcess();
        Log.d(TAG, "attachBaseContext isLoadDexProcess=" + isLoadDexProcess);
        boolean isFinished = false;
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isLoadDexProcess) {
//            Intent intent = new Intent();
//            ComponentName componentName = new
//                    ComponentName("letv.com.testanr", LoadingActivity.class.getName());
//            intent.setComponent(componentName);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            base.startActivity(intent);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            SharedPreferences dd = getSharedPreferences(LoadingActivity.SP_FILE_NAME,
//                    MODE_MULTI_PROCESS);
//            isFinished = "1".equals(dd.getString(LoadingActivity.KEY_FINISH, "0"));
            if (!isFinished) {
//                Intent intent = new Intent();
//                ComponentName componentName = new
//                        ComponentName("letv.com.testanr", LoadingActivity.class.getName());
//                intent.setComponent(componentName);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                base.startActivity(intent);
//                Process.killProcess(Process.myPid());
//                System.exit(0);
//                while (!isFinished) {
//                    dd = getSharedPreferences(LoadingActivity.SP_FILE_NAME,
//                            MODE_MULTI_PROCESS);
//                    isFinished = "1".equals(dd.getString(LoadingActivity.KEY_FINISH, "0"));
////                    Log.d(TAG, "attachBaseContext isFinished=" + isFinished);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }
        Log.d(TAG, "attachBaseContext end");
    }

    public boolean isLoadDexProcess() {
        return TextUtils.equals(LetvUtils.getProcessName(this, Process.myPid()),
                LOAD_DEX_PROCESS_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Exception exception = new Exception("onCreate");
        exception.printStackTrace();
        Log.d(TAG, "onCreate:  pid=" + Process.myPid(), exception);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
