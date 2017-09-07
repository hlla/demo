package com.example.testlaunchmodea;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityC extends BaseActivity {
    private static final String TAG = "LaunchmodeA_" + ActivityC.class.getName();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
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
        startModeActivity("action_main", Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
    }

    @OnClick(R.id.start_a)
    public void onStartAClicked() {
        startModeActivity("action_a", Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent
                .FLAG_ACTIVITY_NEW_TASK);
//        startModeActivityForResult("action_a", Intent.FLAG_ACTIVITY_MULTIPLE_TASK | Intent
//                .FLAG_ACTIVITY_NEW_TASK, null);
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
        startModeActivity("action_x", 0);
    }

    @OnClick(R.id.start_modeB_y)
    public void onStartModeBYClicked() {
        startModeActivity("action_y", 0);
    }

    @OnClick(R.id.start_modeB_z)
    public void onStartModeBZClicked() {
        startModeActivity("action_z", 0);
    }

}
