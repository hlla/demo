package example.com.testcomponent.statics

import android.util.Log

/**
 * Created by chengjian on 18-4-19.
 */

class TestStaticD {

    fun testPub(testStaticD: TestStaticD?): TestStaticD {
        if (testStaticD != null) {
            testStaticD.testPri(testStaticD)
        }
        return this
    }

    private fun testPri(testStaticD: TestStaticD?) {

    }

    protected fun testpro(testStaticD: TestStaticD) {
        testStaticD.testPri(testStaticD)
    }

    companion object {
        var testStaticC: TestStaticC? = null
        private val TAG = "Static_TestD"

        init {
            //        testStaticC.equals("dgfdg");
            Log.d(TAG, "static D initializer: ")
        }
    }
}
