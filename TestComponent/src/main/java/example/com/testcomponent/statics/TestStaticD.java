package example.com.testcomponent.statics;

import android.util.Log;

/**
 * Created by chengjian on 18-4-19.
 */

public class TestStaticD {
    public static TestStaticC testStaticC;
    private static final String TAG = "Static_TestD";

    static {
//        testStaticC.equals("dgfdg");
        Log.d(TAG, "static D initializer: ");
    }


}
