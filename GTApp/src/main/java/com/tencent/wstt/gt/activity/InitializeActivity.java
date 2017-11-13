package com.tencent.wstt.gt.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.tencent.wstt.gt.GTApp;
import com.tencent.wstt.gt.R;
import com.tencent.wstt.gt.actors.DeviceInfoActor;
import com.tencent.wstt.gt.api.utils.Env;
import com.tencent.wstt.gt.dao.GTPref;
import com.tencent.wstt.gt.utils.Const;
import com.tencent.wstt.gt.utils.ToastUtil;

public class InitializeActivity extends BaseActivity {
    boolean infoStored;
    private static final int REQUEST_NEED_PERMISSION = 101;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);

        infoStored = GTPref.getGTPref().getBoolean(Const.KEY_SP_PHONE_INFO_STORED, false);

        boolean hasPermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);

        if (!hasPermission) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_NEED_PERMISSION);
        } else {
            if (!infoStored) parseDeviceInfo(mAppContext);
        }
    }

    private void parseDeviceInfo(Context ctx) {
        DeviceInfoActor actor;
        actor = new DeviceInfoActor(ctx);
        actor.initialize();
        actor.act();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_NEED_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 授权了就可以保存了，do nothing即可
                    Env.init();
                    if (!infoStored) parseDeviceInfo(mAppContext);
                } else {
                    ToastUtil.ShowLongToast(GTApp.getContext(),
                            "Permission not enough. Please consider granting it this permission.");
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
