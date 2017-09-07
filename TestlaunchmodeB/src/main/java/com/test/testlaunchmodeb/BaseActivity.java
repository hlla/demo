package com.test.testlaunchmodeb;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by chengjian on 2017/7/29.
 */

public class BaseActivity extends Activity {
    public void startModeActivity(String action, int flags) {
        Intent intent = new Intent(action);
        if (0 != flags) {
            intent.setFlags(flags);
        }
        startActivity(intent);
    }
}
