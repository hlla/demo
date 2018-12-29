package example.com.testcomponent.statics

import android.util.Log

/**
 * Created by chengjian on 18-4-19.
 */

class TestStaticB {
    init {
        Log.d("Static_", "static B initializer: ")
    }

    var bb = 23;

    //    private static final String TAG = "Static_Test";
    //
    //    static {
    //        Log.d(TAG, "static B initializer: ");
    //        b = 33;
    //    }
    companion object {
        var b = 23;

    }

    private fun test() {
        val dd = TestStaticB()
    }

}
