package letv.com.testanr;

import android.content.Intent;

/**
 * Created by chengjian on 18-4-1.
 */
public class TestAA<DATA_TYPE, CALLBACK> {
    Intent dataType;

    public void aa(DATA_TYPE ss, CALLBACK aa) {
        dataType = (Intent) ss;
    }
}
