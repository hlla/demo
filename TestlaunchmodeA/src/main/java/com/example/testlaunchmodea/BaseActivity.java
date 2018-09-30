package com.example.testlaunchmodea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by chengjian on 2017/7/29.
 */

public class BaseActivity extends Activity {
    private static final String TAG = "LaunchmodeA_" + BaseActivity.class.getName();
    public static final String EXTRA = "extra";
    public static final int REQUEST_CODE = 100;

    public void startModeActivityForResult(String action, int flags, Bundle extra) {
        Intent intent = new Intent(action);
        if (0 != flags) {
            intent.setFlags(flags);
        }
        if (null != extra) {
            intent.putExtra(EXTRA, extra);
        }
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void startModeActivity(String action, int flags, Bundle extra) {
        Intent intent = new Intent(action);
        if (0 != flags) {
            intent.setFlags(flags);
        }
        if (null != extra) {
            intent.putExtra(EXTRA, extra);
        }
        startActivity(intent);
    }

    public void startModeActivity(String action, int flags) {
        startModeActivity(action, flags, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume this=" + this + " class=" + this.getClass().getName() + "  task=" +
                getTaskId() + " flag =" + Integer.toHexString(getIntent().getFlags()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart this=" + this + " class=" + this.getClass().getName() + "  task=" +
                getTaskId() + " flag =" + Integer.toHexString(getIntent().getFlags()));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent this=" + this + " class=" + this.getClass().getName() + "  task=" +
                getTaskId() + " flag =" + Integer.toHexString(getIntent().getFlags()) + "  new" +
                ".flag=" + Integer.toHexString(intent.getFlags()) + "  getIntent()=" + getIntent
                () + "  intent=" +
                intent);
        boolean isFinish = intent.getBooleanExtra("finish", false);
        if(isFinish){
            finish();
            Process.killProcess(Process.myPid());
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate this=" + this + " class=" + this.getClass().getName() + "  task=" +
                getTaskId()
                + " flag =" + Integer.toHexString(getIntent().getFlags()) + " " +
                "packageName=" + getPackageName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState this" + this + " class=" + this.getClass().getName() + " " +
                " task=" +
                getTaskId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState this" + this + " class=" + this.getClass().getName() +
                "  task="
                + getTaskId()
        );
    }
}