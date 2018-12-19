/*
 *    Copyright (C) 2016 Amit Shekhar
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.flatbuffer.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.flatbuffer.R.layout.activity_main);
        String appName = getAppName(this);
        Log.d(TAG, "onCreate appName=" + appName);
    }

    public void startJson(View view) {
        Intent intent = new Intent(this, JsonActivity.class);
        startActivity(intent);
    }

    public void startXml(View view) {
        Intent intent = new Intent(this, XmlActivity.class);
        startActivity(intent);
    }

    /**
     * 获取当前应用的名字
     */
    public static String getAppName(Context context) {
        if (null == context) {
            return "";
        }
        PackageManager manager = context.getPackageManager();
        ApplicationInfo info = null;
        try {
            info = manager.getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            String appName = "";
            if (null != info) {
                appName = info.loadLabel(manager).toString();
            }
            return appName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        return "";
    }

}
