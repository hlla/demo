package example.com.testcomponent.statics;

import android.util.Log;

/**
 * Created by chengjian on 18-4-19.
 */

public class TestStaticB {
    private static final String TAG = "Static_Test";

    static {
        Log.d(TAG, "static B initializer: ");
        b = 33;
    }

    public static int b = 23;
}
