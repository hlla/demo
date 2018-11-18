package example.com.testlib;

import android.util.Log;

/**
 * Created by chengjian on 18-8-7.
 */

public class TestLib_java {
    public static void staticTest() {
        String aa = "dsfdsf";
        Log.d("dgfdgfg", "gdfgfg");
    }

    public void NonStaticTest() {
        String aa = "dsfdsf";
        Log.d("dgfdgfg", "gdfgfg");
    }

    private void privateTest() {
        String aa = "dsfdsf";
        Log.d("dgfdgfg", "gdfgfg");
    }

    final void privateFTest() {
        String aa = "dsfdsf";
        Log.d("dgfdgfg", "gdfgfg");
    }
}
