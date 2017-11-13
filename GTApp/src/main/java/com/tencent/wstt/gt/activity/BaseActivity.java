package com.tencent.wstt.gt.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ChenGong on 26/10/2017
 */

public abstract class BaseActivity extends Activity {
    protected Context mAppContext;
    protected BaseActivity baseActivity;
    protected final String TAG;

    public BaseActivity() {
        TAG = this.getClass().getSimpleName();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppContext = getApplication();
        baseActivity = this;
    }
}
