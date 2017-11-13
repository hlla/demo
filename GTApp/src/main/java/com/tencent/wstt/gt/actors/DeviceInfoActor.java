package com.tencent.wstt.gt.actors;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import com.tencent.wstt.gt.api.utils.DeviceUtils;
import com.tencent.wstt.gt.dao.GTPref;
import com.tencent.wstt.gt.utils.Const;
import com.tencent.wstt.gt.utils.FileUtil;

import java.io.File;

/**
 * Created by ChenGong on 26/10/2017
 */

public class DeviceInfoActor extends BaseActor {
    public DeviceInfoActor(Context mContext) {
        super(mContext);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean act() {
        System.out.println("Kyle act in "+TAG );
        mExecutor.submit(() -> {
            int nav_height = DeviceUtils.getNavBarHeight(mContext);
            int width = DeviceUtils.getDisplayWidth(mContext);
            int height = DeviceUtils.getRealScreenHeightIncludeNavBar(mContext);
            StringBuilder sb = new StringBuilder();
            sb.append(assembleKV(Const.NAV_HEIGHT_KEY, nav_height))
                    .append(assembleKV(Const.DISPLAY_SIZE_X, width))
                    .append(assembleKV(Const.DISPLAY_SIZE_Y, height));
            System.out.println("Kyle \n\r" + TAG + sb);
            FileUtil.writeStringToFile(new File(Environment.getExternalStorageDirectory()
                    , Const.INFO_FILE_NAME), sb,false);
            GTPref.getGTPref().edit().putBoolean(Const.KEY_SP_PHONE_INFO_STORED, true).apply();
        });
        return super.act();
    }

    private String assembleKV(Object k, Object v) {
        return k + " = " + v + "\n\r";
    }
}
