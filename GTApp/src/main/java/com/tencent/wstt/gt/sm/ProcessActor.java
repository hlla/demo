package com.tencent.wstt.gt.sm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.tencent.wstt.gt.actors.BaseActor;
import com.tencent.wstt.gt.api.utils.ProcessUtils;
import com.tencent.wstt.gt.plugin.smtools.SMServiceHelper;
import com.tencent.wstt.gt.utils.Const;

import java.util.List;

/**
 * Created by ChenGong on 23/10/2017
 */

public class ProcessActor extends BaseActor {
    String processName;
    int pid;

    public ProcessActor(Context mContext) {
        super(mContext);
    }

    @Override
    public boolean act() {
        super.act();
        toggleSMServiceStatus(!isSMStarted());
        return false;
    }

    public void toggleSMServiceStatus(boolean start) {
        if (!start) {
            if (isSMStarted()) {
                SMServiceHelper.getInstance().stopBackgroundServiceIfRunning(mContext);
                toast(mContext, "SM stopped!");
            }
        } else {
            Log.d("chengjian", "toggleSMServiceStatus: before processFound pn=" + Const
                    .PROCESS_NAME);
            boolean processFound = refreshData();
            Log.d("chengjian", "toggleSMServiceStatus: after processFound=" + processFound + " " +
                    "pid=" + pid);
            if (processFound) {
                SMServiceHelper.getInstance().startBackgroundService(mContext, pid, processName);
            }
        }
    }

    public boolean isSMStarted() {
        return SMServiceHelper.getInstance().isStarted();
    }

    private boolean refreshData() {
        boolean processFound = isProcessRunning();
        if (!processFound && (Const.WAIT_PROCESS_TO_LAUNCH || processInWhiteList(Const
                .PROCESS_NAME))) {
            Log.d("chengjian", "waiting for process to start : " + Const.PROCESS_NAME);
//            for (int i = 0; i < 3; i++) {
//                toast(mContext, "Process in watch dog mode list" +
//                        ", waiting for process to start::\n" + Const.PROCESS_NAME);
//            }
            while (true) {
                processFound = isProcessRunning();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (processFound || isDisposed()) {
                    Log.d("chengjian", "Process starts to run:" + Const.PROCESS_NAME);
//                    toast(mContext, "Process starts to run::\n" + Const.PROCESS_NAME);
                    break;
                }
            }
        }

        toast(mContext, TextUtils.isEmpty(processName)
                ? "No match process found!!!\n" + Const.PROCESS_NAME : "Inspecting::  " + Const
                .PROCESS_NAME);
        return processFound;
    }

    private boolean isProcessRunning() {
        List<ProcessUtils.ProcessInfo> rp = ProcessUtils.getAllRunningAppProcessInfo();
        for (ProcessUtils.ProcessInfo i : rp) {
            if (i.name.equals(Const.PROCESS_NAME)) {
                processName = i.name;
                pid = i.pid;
                return true;
            }
        }
        return false;
    }

    private boolean processInWhiteList(String processName) {
        for (int i = 0; i < Const.WATCH_DOG_ENABLED_LIST.length; i++) {
            if (Const.WATCH_DOG_ENABLED_LIST[i].equals(processName)) {
                return true;
            }
        }
        return false;
    }
}
