package example.com.testcomponent.statics;

import android.util.Log;

import example.com.testlib.TestLib;

/**
 * Created by chengjian on 18-4-19.
 */

public class TestStaticA {
    public static TestStaticD testStaticD = new TestStaticD();
//    public static TestLib sTestLib;
    public static int b = TestStaticB.b;
    //    public static int c = TestStaticC.c;
    private static final String TAG = "Static_TestA";
    public static TestStaticB testStaticB;
    public static TestStaticC testStaticC;

    public static TestLib getTest() {
        return new TestLib();
    }

    public static void getTest(TestLib lib) {
        Log.d(TAG, "getTest: ");
    }

    public void getTest22(TestLib lib) {
        Log.d(TAG, "getTest: ");
    }

    public TestStaticA() {
//        testStaticC.equals("dgfdg");
//        if (null == testStaticC) {
//            throw new OutOfMemoryError();
//        }
    }

    static {
        Log.d(TAG, "static A initializer: testStaticD=" + testStaticD);
//        testStaticC = new TestStaticC();
        c = 100;
//        testStaticC.equals("dgfdg");
//        if (null == testStaticC) {
//            throw new UnsatisfiedLinkError(
//            );
//        }
    }

    public static int c = 10;


}
