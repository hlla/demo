package letv.com.testanr.util;

import android.util.Log;

import letv.com.testanr.MyService;

/**
 * Created by chengjian on 17-8-30.
 */

public class TestRetrace {
    public void test(String a) {
        Log.d("dddd", "test: a=" + a);
        haha();
    }

    public void haha() {
        TestRetrace dd = null;
        dd.equals(null);
    }
}
