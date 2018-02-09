package example.com.testapp;

import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.IActivityManager.ContentProviderHolder;
import android.app.IApplicationThread;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    public static final String AUTHORITY = "com.huawei.rcsbaseline.database.zone";
    public static final String TAG = "MainActivity";
    public static final Uri ACCOUNT_URI = Uri.parse("content://" + AUTHORITY
            + "/Accout");

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getContentResolver().query(ACCOUNT_URI, null, null, null, null, null);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        Log.d(TAG, " Process.myUid()=" + Process.myUid());
        ContentProviderHolder cph = getCPH();
        if (null != cph && null != cph.info) {
            String appName = null;
            int versionCode = -1;
            String versionName = "";
            if (null != cph.info.applicationInfo) {
                appName = cph.info.applicationInfo.name;
            }
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(cph.info
                        .packageName, 0);
                if (null != packageInfo) {
                    versionCode = packageInfo.versionCode;
                    versionName = packageInfo.versionName;
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            Log.d(TAG, "packageName: " + cph.info.packageName + " appName=" + appName + " " +
                    "versionCode=" + versionCode + " versionName=" + versionName);
        }
    }

    private ContentProviderHolder getCPH() {
        ContentProviderHolder holder = null;
        try {
            int uid = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Method getUserIdMethod = UserHandle.class.getDeclaredMethod("getUserId", int
                        .class);
                uid = (int) getUserIdMethod.invoke(null, Process.myUid());
            } else {
                uid = uid / 100000;
            }
            holder = ActivityManagerNative.getDefault().getContentProvider
                    (getAT(), AUTHORITY, uid, false);
        } catch (Throwable ex) {
            Log.d(TAG, "getCPH: ex=" + ex);
        }
        return holder;
    }


    private IApplicationThread getAT() {
        IApplicationThread iApplicationThread = null;
        try {
            ActivityThread activityThread = ActivityThread.currentActivityThread();
            iApplicationThread = activityThread.getApplicationThread();
        } catch (Throwable ex) {
            Log.d(TAG, "getAT: ex=" + ex);
        }
        return iApplicationThread;
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
