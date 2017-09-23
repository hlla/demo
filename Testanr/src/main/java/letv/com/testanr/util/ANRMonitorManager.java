package letv.com.testanr.util;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import android.os.SystemProperties;
import android.util.Log;

import java.util.List;

/**
 * Created by chengjian on 17-9-23.
 */

public class ANRMonitorManager {
    private static final String TAG = "Testanr_ANRMonitor";
    private static volatile ANRMonitorManager sInstance;
    private Context mContext;
    private ActivityManager mActivityManager;

    public static ANRMonitorManager getInstance(Context context) {
        if (null != sInstance) {
            return sInstance;
        }
        synchronized (ANRMonitorManager.class) {
            if (sInstance == null)
                sInstance = new ANRMonitorManager(context);
        }
        return sInstance;
    }

    private ANRMonitorManager(Context context) {
        mContext = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context
                .ACTIVITY_SERVICE);
    }

    FileObserver observer;

    public void startMonitor() {
        final String tracesPath = SystemProperties.get("dalvik.vm.stack-trace-file", null);
        Log.d(TAG, "startMonitor: tracesPath=" + tracesPath);
        observer = new FileObserver(tracesPath, 2047) {
            @Override
            public synchronized void onEvent(int event, String path) {
                Log.d(TAG, "onEvent: event=" + event);
                List<ProcessErrorStateInfo> processErrorStateInfos = mActivityManager
                        .getProcessesInErrorState();
                Log.d(TAG, "run: processErrorStateInfo=" + processErrorStateInfos);
                if (null == processErrorStateInfos) {
                    return;
                }
                for (ProcessErrorStateInfo processErrorStateInfo : processErrorStateInfos) {
                    Log.d(TAG, "onCreate: processName=" + processErrorStateInfo
                            .processName +
                            " " +
                            "msg=" +
                            processErrorStateInfo.longMsg + "  shortMsg=" +
                            processErrorStateInfo
                                    .shortMsg + " stackTrace" + processErrorStateInfo
                            .stackTrace + " " +
                            " " +
                            "condition=" +
                            processErrorStateInfo.condition);
                }
//                File file = new File(tracesPath);
//                File sleep = new File(Environment.getExternalStorageDirectory() + "/sleep");
//                if (sleep.exists()) {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Log.d(TAG, "onEvent: event=" + event + " path=" + path + " file=" + file.exists()
//                        + " file.canread=" + file.canRead());
//                try {
//                    byte[] content = new byte[1024];
//                    FileInputStream fileInputStream = new FileInputStream(file);
//                    while (fileInputStream.read(content, 0, content.length) > 0) {
//                        Log.d(TAG, "onEvent: content=" + new String(content));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                observer.stopWatching();
//                observer.startWatching();
            }
        };
        observer.startWatching();
        Log.d(TAG, "startMonitor: tracesPath111=" + tracesPath);
//        FileObserver observer1 = new FileObserver("/data/anr/", FileObserver.CLOSE_WRITE) {
//            @Override
//            public synchronized void onEvent(int event, String path) {
//                File file = new File(tracesPath);
//                File sleep = new File(Environment.getExternalStorageDirectory() + "/sleep");
//                if (sleep.exists()) {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Log.d(TAG, "onEvent: event11111=" + event + " path=" + path + " file=" + file
// .exists()
//                        + " file.canread=" + file.canRead());
//            }
//        };
//        observer1.startWatching();
    }
}
