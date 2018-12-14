package example.com.testcomponent.statics

import android.util.Log

/**
 * Created by chengjian on 18-4-19.
 */

object TestStaticC {
    var c = 23
    private val TAG = "Static_TestC"

    //    public TestStaticC() {
    //
    //    }

//    init {
//        val testStaticC = TestStaticB()
//        Log.d(TAG, "static C initializer: ")
//        c = 11
//    }
    fun testPub(testStaticD: TestStaticD) {
        val testStaticC = TestStaticC()
    }

}
