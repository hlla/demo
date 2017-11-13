/*
 * Tencent is pleased to support the open source community by making
 * Tencent GT (Version 2.4 and subsequent versions) available.
 *
 * Notwithstanding anything to the contrary herein, any previous version
 * of Tencent GT shall not be subject to the license hereunder.
 * All right, title, and interest, including all intellectual property rights,
 * in and to the previous version of Tencent GT (including any and all copies thereof)
 * shall be owned and retained by Tencent and subject to the license under the
 * Tencent GT End User License Agreement (http://gt.qq.com/wp-content/EULA_EN.html).
 * 
 * Copyright (C) 2015 THL A29 Limited, a Tencent company. All rights reserved.
 * 
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://opensource.org/licenses/MIT
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.tencent.wstt.gt.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.tencent.wstt.gt.GTApp;
import com.tencent.wstt.gt.GTBinder;
import com.tencent.wstt.gt.GTConfig;
import com.tencent.wstt.gt.R;
import com.tencent.wstt.gt.activity.GTMainActivity;
import com.tencent.wstt.gt.sm.SMMaster;
import com.tencent.wstt.gt.utils.Const;
import com.tencent.wstt.gt.utils.NotificationHelper;

/**
 * GT对外的服务,同时声明为前台服务
 */
public class GTService extends Service {
    SMMaster smMaster;

    public void onCreate() {
        super.onCreate();
        smMaster = new SMMaster(getApplicationContext());

        smSwitchReceiver = new SMSwitchReceiver(smMaster);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Const.TURN_ON_SM);
        filter.addAction(Const.TURN_OFF_SM);
        registerReceiver(smSwitchReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smSwitchReceiver);
        smMaster.dispose();
    }

    /*
     * 远程调用使用
     */
    private final IBinder binder = new GTBinder();
    private SMSwitchReceiver smSwitchReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) return START_STICKY_COMPATIBILITY;
        String version_type = "Release";
        if (1 == GTConfig.VERSION_TYPE) {
            version_type = "Develop";
        }
        GTMainActivity.notification = NotificationHelper.genNotification(
                GTApp.getContext(), 0, R.drawable.gt_entrlogo, "GT", 1,
                "Version: " + version_type + " " + GTConfig.VERSION,
                "GT is running", GTMainActivity.class,
                true, false, 0);
        startForeground(10, GTMainActivity.notification);
        return super.onStartCommand(intent, flags, startId);
    }

    static class SMSwitchReceiver extends BroadcastReceiver {
        SMMaster smMaster;
        private boolean mIsStart = false;

        public SMSwitchReceiver(SMMaster smMaster) {
            this.smMaster = smMaster;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("chengjian", "onReceive: action=" + intent.getAction() + " this=" + this);
            switch (intent.getAction()) {
                case Const.TURN_ON_SM:
//                    if (mIsStart) {
//                        return;
//                    }
                    mIsStart = true;
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        Const.PKG_NAME = bundle.getString(Const.KEY_PKG, Const.LAUNCHER_PKG_NAME);
                        Const.PROCESS_NAME = bundle.getString(Const.KEY_PRO, Const
                                .LAUNCHER_PROCESS_NAME);
                        Const.FILE_TAG = bundle.getString(Const.KEY_TAG, "");
                        Const.WAIT_PROCESS_TO_LAUNCH = bundle.getBoolean(Const
                                .KEY_WAIT_PROCESS_LAUNCH, false);
                        Const.FOLDER_TAG = bundle.getString(Const.KEY_FOLDER_TAG, "");
                    } else {
                        Const.PKG_NAME = Const.LAUNCHER_PKG_NAME;
                        Const.PROCESS_NAME = Const.LAUNCHER_PROCESS_NAME;
                        Const.FILE_TAG = "";
                    }
                    smMaster.toggleSMServiceStatus(true);
                    break;
                case Const.TURN_OFF_SM:
                    mIsStart = false;
                    smMaster.toggleSMServiceStatus(false);
                    break;
                default:
                    break;
            }
        }
    }
}