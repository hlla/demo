package com.tencent.wstt.gt.actors;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.tencent.stat.StatService;
import com.tencent.wstt.gt.api.utils.Env;
import com.tencent.wstt.gt.api.utils.ProcessUtils;
import com.tencent.wstt.gt.manager.AUTManager;
import com.tencent.wstt.gt.manager.ClientFactory;
import com.tencent.wstt.gt.manager.ClientManager;
import com.tencent.wstt.gt.manager.SingleInstanceClientFactory;
import com.tencent.wstt.gt.utils.AppInfo;
import com.tencent.wstt.gt.utils.Const;

import java.util.List;
import java.util.Properties;

/**
 * Created by ChenGong on 23/10/2017
 */

public class PackageActor extends BaseActor {

    AppInfo mApp;
    Runnable finishTask;

    public PackageActor(Context mContext) {
        super(mContext);
    }

    public void setFinishTask(Runnable finishTask) {
        this.finishTask = finishTask;
    }

    @Override
    public boolean act() {
        Thread loginThread = new Thread(new ShowAppHandler(finishTask));
        loginThread.start();
        return super.act();
    }

    class ShowAppHandler implements Runnable {
        Runnable finishTask;

        public ShowAppHandler(Runnable finishTask) {
            this.finishTask = finishTask;
        }

        @Override
        public void run() {
            getInstalledApp();
            if (mApp != null) {
                ProcessUtils.initUidPkgCache();
                refreshSetting();
            }
            toast(mContext, (mApp != null ? "App refreshed:\n" : "No app match package!\n") + Const.PKG_NAME);
            finishTask.run();
        }
    }

    public void getInstalledApp() {
        PackageManager pm = mContext.getPackageManager();
        List<PackageInfo> packages = pm
                .getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(
                    pm).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            tmpInfo.appIcon = packageInfo.applicationInfo
                    .loadIcon(pm);
            if (packageInfo.packageName.equals(Const.PKG_NAME)) {
                mApp = tmpInfo;
            }
        }
        // 系统应用加在列表后面
    }

    private void refreshSetting() {
        AUTManager.pkn = mApp.packageName;
        AUTManager.apn = mApp.appName;
        AUTManager.appic = mApp.appIcon;
        Env.CUR_APP_NAME = mApp.packageName;
        Env.CUR_APP_VER = mApp.versionName;

        // 清除旧的AUT_CLIENT
        ClientManager.getInstance().removeClient(ClientManager.AUT_CLIENT);

        // 创建新的AUT_CLIENT
        ClientFactory cf = new SingleInstanceClientFactory();
        cf.orderClient(
                ClientManager.AUT_CLIENT, ClientManager.AUT_CLIENT.hashCode(), null, null);

        // MTA记录选中的AUT
        Properties prop = new Properties();
        prop.setProperty("pkgName", AUTManager.pkn);
        StatService.trackCustomKVEvent(mContext, "Selected AUT", prop);
    }
}
