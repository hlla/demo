
package com.example.testbreakpoint;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestHttp {
    private static final String TAG = "TestHttp";

    public static void download(Context context, File file, String url) {
        Log.d(TAG, "download11 url=" + url);
        if (!file.exists()) {
            try {
                FileOutputStream fo = new FileOutputStream(file);
                InputStream inStream = CommonUtility.getWebDataStream(url);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inStream.read(buffer)) != -1) {
                    fo.write(buffer, 0, len);
                }
                inStream.close();
                fo.close();
            } catch (Exception exception) {
                Log.d(TAG, "download exception=" + exception);
            }
            Log.d(TAG, "download url=" + url);
            PackageInfo packageInfo = CommonUtility.getPackageInfo(context, file
                    .getPath());
            Log.d(TAG, "download packageInfo=" + packageInfo);
            if (null != packageInfo) {
                Log.d(TAG, "download version=" + packageInfo.versionCode);
            }
        }
    }

}
