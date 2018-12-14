package example.com.testreference;

import android.app.Application;
import android.util.Log;

//import com.android.volley.extra.VolleyImageLoader;

/**
 * Created by chengjian on 17-10-25.
 */

public class TestApp extends Application {
    private static final String TAG = "reference_TestApp";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        int angle = 10;
//        VolleyImageLoader.getInstance().setAppContext(this);
//        VolleyImageLoader.getInstance().setBitmapcacheSize(7 * 1024 * 1024);
    }
}
