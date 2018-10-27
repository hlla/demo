package example.com.testcomponent.statics;

import android.util.Log;

/**
 * Created by chengjian on 18-4-19.
 */

public class TestStaticC {
    public static int c = 23;
    private static final String TAG = "Static_TestC";

    static {
        Log.d(TAG, "static C initializer: ");
        c = 11;
    }


}
