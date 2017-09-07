package com.example.testlaunchmodea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityA extends BaseActivity {
    private static final String TAG = "LaunchmodeA_" + ActivityA.class.getName();
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
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String ss = null;
            Log.d(TAG, "" + ss.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        () findViewById(R.id.);
        ButterKnife.bind(this);
        SharedPreferences sp = getSharedPreferences("cj", Context.MODE_PRIVATE);
        String name = sp.getString("name", "ddddd");
        Log.d(TAG, "onCreate name=" + name);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        Log.d(TAG, "onCreate bundle=" + bundle);
//        intent.putExtra("num", 8);
//        setResult(Activity.RESULT_OK, intent);
//        onStartBClicked();
//        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
//        mHandler.sendEmptyMessageDelayed(0,5000);
//        new Thread() {
//            @Override
//            public void run() {
//                String ss = null;
//                Log.d(TAG, "" + ss.toString());
//            }
//        }.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
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

    @OnClick(R.id.start_modeA_main)
    public void onStartModeAMainClicked() {
        startModeActivity("action_main", 0);
    }

    @OnClick(R.id.start_a)
    public void onStartAClicked() {
        startModeActivity("action_a", Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

}
