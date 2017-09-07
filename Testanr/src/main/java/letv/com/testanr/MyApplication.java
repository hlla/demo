package letv.com.testanr;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import letv.com.testanr.util.LetvUtils;

/**
 * Created by chengjian on 17/6/2.
 */

public class MyApplication extends Application {
    private static final String TAG = "Testanr_MyApplication";
    private static final String LOAD_DEX_PROCESS_NAME = "letv.com.testanr:loading";

    public static ComponentName getTopAppPkgName(Context appContext) {

        ComponentName topAppComponentName = null;
        if (Build.VERSION.SDK_INT >= 21) {

//            if (PackageUsageStatsUtil.isUsageAccessEnable(appContext)) {
////                OpLog.toFile(TAG, "isUsageAccessEnable true");
//                topAppComponentName = getMoveToFgComponent(appContext);
//            }
//
//            if (topAppComponentName == null || TextUtils.isEmpty(topAppComponentName
//                    .getPackageName())) {
//                topAppComponentName = getTopAppPkgNameAbove21(appContext);
//            }

        } else {
            topAppComponentName = getTopAppPkgNameBelow21(appContext);
        }

        if (null == topAppComponentName)
            topAppComponentName = new ComponentName("", "");

        return topAppComponentName;
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

    private static long sLastEventTime = -1;
    private static UsageEvents.Event sQueryEvent;
    private static final long USAGE_STATS_TIME_CHANGE = (2 * 1000) + 500;

//    @SuppressLint("NewApi")
//    public static ComponentName getMoveToFgComponent(Context ctx) {
//        if (Build.VERSION.SDK_INT < 21) {
//            return null;
//        }
////        long nowTime = System.currentTimeMillis();
////        if (lastQueryTime == 0 || lastUsageTime == 0 || (nowTime - lastQueryTime) > 20000) {
////            lastUsageTime = nowTime - 5000;
////        }
//
//        long end = System.currentTimeMillis();
//        UsageStatsManager usageManager = getUsageManager(ctx);
//        final long begin = (sLastEventTime == -1 || sLastEventTime >= end) ?
//                (end - 60 * 1000) : sLastEventTime - 10;//这里-10的原因是要保证拿到一个【发生了移动到前台的App】，
//        // 如果是准确sLastEventTime，有可能到现在为止都没有应用变化，导致取不到App
//
//        // Add extra 2 seconds to the end since UsageStatsService use SystemClock
// .elaspedRealTime()
//        // instead of System.currentTimeMillis() to calculate the app usage time.
//        // Therefore, its time might shift from the current time we got.
//        final long changedEnd = end + USAGE_STATS_TIME_CHANGE;
//
//        final UsageEvents events;
//        try {
//            events = usageManager.queryEvents(begin, changedEnd);
//        } catch (Throwable t) {
//            return null;
//        }
//
//        String pkgName = null;
//        String clsName = null;
//
//        if (sQueryEvent == null) {
//            sQueryEvent = new UsageEvents.Event();
//        }
//
//        while (events.hasNextEvent()) {
//            events.getNextEvent(sQueryEvent);
//            if (sQueryEvent.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND) {
//                pkgName = sQueryEvent.getPackageName();
//                clsName = sQueryEvent.getClassName();
//                sLastEventTime = sQueryEvent.getTimeStamp();
//            }
//        }
//
//        ComponentName comp = null;
//        if (pkgName != null && clsName != null) {
//            comp = new ComponentName(pkgName, clsName);
//        }
//
//        return comp;
//    }

    public static boolean getLauncherForegroundApp(Context context) {
        Log.d(TAG, "getLauncherForegroundApp context=" + context);
        ActivityManager am =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> lr = am.getRunningAppProcesses();
        if (lr == null) {
            return false;
        }
        Log.d(TAG, "getLauncherForegroundApp dddd");
        for (ActivityManager.RunningAppProcessInfo ra : lr) {
            Log.d(TAG, "getLauncherForegroundApp ra.processName=" + ra.processName + " " +
                    "importance=" + ra.importance);
            if (ra.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE
                    || ra.importance == ActivityManager.RunningAppProcessInfo
                    .IMPORTANCE_FOREGROUND) {
                Log.d(TAG, "getLauncherForegroundApp ra.processName=" + ra.processName);
                if (ra.processName != null) {
                    return ra.processName.startsWith("letv.com.testanr");
                }
                return false;
            }
        }
        return false;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        Exception exception = new Exception("attachBaseContext");
//        exception.printStackTrace();
        Log.d(TAG, "attachBaseContext: pid=" + Process.myPid()/*, exception*/);
        boolean isLoadDexProcess = isLoadDexProcess();
        Log.d(TAG, "attachBaseContext isLoadDexProcess=" + isLoadDexProcess);
        boolean isForegroundApp = getLauncherForegroundApp(this);
        ComponentName pkg = getTopAppPkgName(this);
        Log.d(TAG, "attachBaseContext isForegroundApp=" + isForegroundApp + " pkg=" + pkg);
        while (true) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        boolean isFinished = false;
//        if (!isLoadDexProcess) {
//            SharedPreferences dd = getSharedPreferences(LoadingActivity.SP_FILE_NAME,
//                    MODE_MULTI_PROCESS);
//            isFinished = "1".equals(dd.getString(LoadingActivity.KEY_FINISH, "0"));
//            if (!isFinished) {
//                if (getLauncherForegroundApp(this)) {
//                    Intent intent = new Intent();
//                    ComponentName componentName = new
//                            ComponentName("letv.com.testanr", LoadingActivity.class.getName());
//                    intent.setComponent(componentName);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    base.startActivity(intent);
//                }
//                while (!isFinished) {
//                    Log.d(TAG, "waitiiiiiiiiiiiiii");
//                    dd = getSharedPreferences(LoadingActivity.SP_FILE_NAME,
//                            MODE_MULTI_PROCESS);
//                    isFinished = "1".equals(dd.getString(LoadingActivity.KEY_FINISH, "0"));
////                    Log.d(TAG, "attachBaseContext isFinished=" + isFinished);
//                    try {
//                        Thread.sleep(2500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        Log.d(TAG, "attachBaseContext end");
    }

    public boolean isLoadDexProcess() {
        return TextUtils.equals(LetvUtils.getProcessName(this, android.os.Process.myPid()),
                LOAD_DEX_PROCESS_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Exception exception = new Exception("onCreate");
        exception.printStackTrace();
        Log.d(TAG, "onCreate:  pid=" + Process.myPid(), exception);
    }
}
