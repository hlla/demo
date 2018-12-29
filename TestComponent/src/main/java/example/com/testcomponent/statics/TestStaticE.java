package example.com.testcomponent.statics;

import android.util.Log;

/**
 * Created by chengjian on 18-4-19.
 */

public class TestStaticE {
    public static TestStaticD testStaticD = new TestStaticD();
    //    public static TestLib sTestLib;
    private static final String TAG = "Static_TestE";
    public static int e = 10;

    public TestStaticE() {
//        testStaticC.equals("dgfdg");
//        if (null == testStaticC) {
//            throw new OutOfMemoryError();
//        }
    }

    static {
        Log.d(TAG, "static E initializer: ");
    }


}
