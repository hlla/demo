package example.com.testutls;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by chengjian on 17-11-8.
 */

public class MyApp extends Application {
    private static final String TAG = "TestUtil_MyApp";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext: start");
        TestUtilActivity.changeWarningLimit();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "attachBaseContext: end");
    }
}
