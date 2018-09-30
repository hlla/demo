package com.example.testmemory;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chengjian on 2017/8/4.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;
}
