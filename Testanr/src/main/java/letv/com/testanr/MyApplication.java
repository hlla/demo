package letv.com.testanr;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Process;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

import letv.com.testanr.util.LetvUtils;

/**
 * Created by chengjian on 17/6/2.
 */

public class MyApplication extends MultiDexApplication {
    private static final String TAG = "Testanr_MyApplication";
    private static final String LOAD_DEX_PROCESS_NAME = "letv.com.testanr:loading";

    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        Log.i(TAG, "isBackground appProcesses.size()=" + appProcesses.size());
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            Log.i(TAG, "appProcess.processName=" + appProcess.processName + " appimportace=" +
                    appProcess.importance + " cp=" + appProcess.uid);
            if (appProcess.processName.contains(context.getPackageName())) {
                Log.i(TAG, "此appimportace ="
                        + appProcess.importance
                        + ",context.getClass().getName()="
                        + context.getClass().getName());
                if (appProcess.importance != ActivityManager.RunningAppProcessInfo
                        .IMPORTANCE_FOREGROUND) {
                    Log.i(TAG, "处于后台"
                            + appProcess.processName);
                    return true;
                } else {
                    Log.i(TAG, "处于前台"
                            + appProcess.processName);
                    return false;
                }
            }
        }
        return false;
    }

    private static ComponentName getTopAppPkgNameBelow21(Context appContext) {
        ActivityManager am = (ActivityManager) appContext.getSystemService(Context
                .ACTIVITY_SERVICE);
        if (am == null) {
            return new ComponentName("", "");
        }

        List<ActivityManager.RunningTaskInfo> taskRunnings = null;
        ActivityManager.RunningTaskInfo runningTask = null;
        try {
            taskRunnings = am.getRunningTasks(1);
        } catch (SecurityException e) {
        } catch (NullPointerException e) {
        } catch (NoSuchFieldError e) {
        }

        if (taskRunnings != null && taskRunnings.size() > 0) {
            runningTask = taskRunnings.get(0);
            if (runningTask != null) {
                ComponentName topActivity = runningTask.topActivity;
                return topActivity;
            }
        }

        return new ComponentName("", "");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Exception exception = new Exception("attachBaseContext");
        exception.printStackTrace();
        Log.d(TAG, "attachBaseContext: pid=" + Process.myPid(), exception);
        boolean isLoadDexProcess = isLoadDexProcess();
        Log.d(TAG, "attachBaseContext isLoadDexProcess=" + isLoadDexProcess);
        boolean isFinished = false;
        Log.d(TAG, "attachBaseContext: ddddd=" + getTopAppPkgNameBelow21(this));
        isBackground(this);
//        try {
//            Thread.sleep(500000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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

    private Handler mHandler = new Handler();
    private static MyApplication sMyApplication;

    public static MyApplication getApp() {
        return sMyApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        Exception exception = new Exception("onCreate");
        exception.printStackTrace();
        Log.d(TAG, "onCreate:  pid=" + Process.myPid(), exception);
        final WindowManager windowManager = (WindowManager) this.getApplicationContext()
                .getSystemService(Context
                        .WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;
        final TextView view = new TextView(this.getApplicationContext());
        view.setText("SYSTEM");
        view.setBackgroundColor(Color.BLUE);
        params.width = 100;
        params.height = 100;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                windowManager.addView(view, params);
//            }
//        }, 5000);
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
