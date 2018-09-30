package com.example.testlaunchmodea;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private static final String TAG = "LaunchmodeA_" + MainActivity.class.getName();
    @BindView(R.id.start_modeA_main)
    Button startModeAMain;
    @BindView(R.id.start_a)
    Button startA;
    @BindView(R.id.start_b)
    Button startB;
    @BindView(R.id.start_c)
    Button startC;
    @BindView(R.id.start_modeB_x)
    Button startModeBX;
    @BindView(R.id.start_modeB_y)
    Button startModeBY;
    @BindView(R.id.start_modeB_z)
    Button startModeBZ;
    @BindView(R.id.start_documentCentric)
    Button actionDocumentCentric;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            getLauncherForegroundApp(MainActivity.this);
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("letv.com.testanr", "letv.com.testanr" +
//                    ".MyService"));
//            bindService(intent, new TestServiceConnection(), BIND_AUTO_CREATE);
            Cursor cursor = getContentResolver().query(ACCOUNT_URI, null, null, null, null, null);
            Log.d("TestComponent1_op", "handleMessage: start cursor=" + cursor);
            if (null != cursor) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String name = cursor.getString(cursor.getColumnIndex("login_account"));
                    cursor.moveToNext();
                    Log.d("TestComponent1_op", "handleMessage: name=" + name);
                }
            }
            mHandler.sendEmptyMessageDelayed(0, 2000);
        }
    };

    public static boolean getLauncherForegroundApp(Context context) {
        Log.d(TAG, "getLauncherForegroundApp context=" + context);
        ActivityManager am =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> lr = am.getRunningAppProcesses();
        if (lr == null) {
            return false;
        }
        Log.d(TAG, "getLauncherForegroundApp dddd");
        for (ActivityManager.RunningAppProcessInfo ra : lr) {
            Log.d(TAG, "getLauncherForegroundApp ra.processName=" + ra.processName + " " +
                    "importance=" + ra.importance);
            if (ra.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE
                    || ra.importance == ActivityManager.RunningAppProcessInfo
                    .IMPORTANCE_FOREGROUND) {
                Log.d(TAG, "getLauncherForegroundApp ra.processName=" + ra.processName);
                if (ra.processName != null) {
                    return ra.processName.startsWith("letv.com.testanr");
                }
                return false;
            }
        }
        return false;
    }

    class TestServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected =" + name + " service=" + service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected =" + name);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        getContentResolver().registerContentObserver(ACCOUNT_URI, true, new ContentObserver
// (null) {
//            @Override
//            public void onChange(boolean selfChange) {
//                Log.d("TestComponent1_op", "onChange selfChange=" + selfChange);
//            }
//        });
//        mHandler.sendEmptyMessageDelayed(0, 5000);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public static final Uri ACCOUNT_URI = Uri.parse("content://com.huawei.rcsbaseline.database" +
            ".zone/Accout");

    @OnClick(R.id.start_modeA_main)
    public void onStartModeAMainClicked() {
//        startModeActivity("action_main", 0);
        mHandler.sendEmptyMessageDelayed(0, 500);
    }

    private void launchLauncher() {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");

        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        localIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        localIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            localIntent.setPackage(getPackageName());
            startActivity(localIntent);
        } catch (Exception localException) {
        } finally {
            finish();
        }
    }

    @OnClick(R.id.start_a)
    public void onStartAClicked() {
//        SharedPreferences sp = getSharedPreferences("cj", Context.MODE_PRIVATE);
//        sp.edit().putString("name", "lj").apply();
//        Bundle bundle = new Bundle();
//        bundle.putString("name", "cj");
//        startModeActivity("action_a", 0, bundle);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_insert_page_constellation_summary);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.layout_insert_text);
        textView.setText("hfghgh");
//        finish();
//        Intent intent = new Intent("test.service");
//        intent.setClassName("letv.com.testanr11", "letv.com.testanr.MyService");
//        boolean result = bindService(intent, new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        }, BIND_AUTO_CREATE);
//        Log.d(TAG, "onBindServiceClicked: end result=" + result);
//        launchLauncher();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("dgdsg", false);
    }

    @OnClick(R.id.start_b)
    public void onStartBClicked() {
        startModeActivity("action_b", 0);
    }

    @OnClick(R.id.start_c)
    public void onStartCClicked() {
        startModeActivity("action_c", 0);
    }

    @OnClick(R.id.start_modeB_x)
    public void onStartModeBXClicked() {
    }

    @OnClick(R.id.start_modeB_y)
    public void onStartModeBYClicked() {
    }

    @OnClick(R.id.start_modeB_z)
    public void onStartModeBZClicked() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int num = -1;
        if (null != data) {
            num = data.getIntExtra("num", 0);
        }
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + " resultCode=" + resultCode +
                " num=" + num);
    }

    @OnClick(R.id.start_documentCentric)
    public void onStartDocumentCentric() {
        Intent intent = new Intent(this, DocumentCentricActivity.class);
        startActivity(intent);
    }
}
