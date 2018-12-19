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

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.flatbuffer.R;
import com.flatbuffer.model.MMAConfig;
import com.flatbuffer.parse.xml.Dom;
import com.flatbuffer.parse.xml.Pull;
import com.flatbuffer.parse.xml.Sax;
import com.flatbuffer.service.ParseService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlActivity extends AppCompatActivity {

    public static final String TAG = XmlActivity.class.getSimpleName();
    private FileInputStream fis = null;
    private TextView textViewDom;
    private TextView textViewPull;
    private TextView textViewSax;
    private String mJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        textViewDom = (TextView) findViewById(R.id.textViewDom);
        textViewPull = (TextView) findViewById(R.id.textViewPull);
        textViewSax = (TextView) findViewById(R.id.textViewSax);
    }

    public void loadFromDom(View view) {
        File newFile = new File(Environment.getExternalStorageDirectory(), "sdkconfig.xml");
        try {
            fis = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        ParseService ps = new Dom();
        ArrayList<MMAConfig> mmaConfigs = (ArrayList<MMAConfig>) ps.doParse(fis);
        long timeTaken = System.currentTimeMillis() - startTime;
        String logText = "Dom : " + timeTaken + "ms";
        textViewDom.setText(logText);
        if (null != mmaConfigs) {
            for (MMAConfig mmaConfig : mmaConfigs) {
                Log.d(TAG, "loadFromDom mmaConfig version=" + mmaConfig.version + "  plat=" +
                        mmaConfig.plat);
            }
        }
        Log.d(TAG, "loadFromDom " + logText);
    }

    public void loadFromPull(View view) {
        Log.d(TAG, "loadFromPull " + 1);
        File newFile = new File(Environment.getExternalStorageDirectory(), "sdkconfig.xml");
        try {
            fis = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "loadFromPull " + 2);
        textViewPull.setText("");
        long startTime = System.currentTimeMillis();
        ParseService ps = new Pull();
        ArrayList<MMAConfig> mmaConfigs = (ArrayList<MMAConfig>) ps.doParse(fis);
        long timeTaken = (System.currentTimeMillis() - startTime);
        String logText = "Pull : " + timeTaken + "ms";
        Log.d(TAG, "loadFromPull " + logText);
        if (null != mmaConfigs) {
            for (MMAConfig mmaConfig : mmaConfigs) {
                Log.d(TAG, "loadFromPull mmaConfig version=" + mmaConfig.version + "  plat=" +
                        mmaConfig.plat);
            }
        }
        textViewPull.setText(logText);
    }

    public void loadFromSax(View view) {
        File newFile = new File(Environment.getExternalStorageDirectory(), "sdkconfig.xml");
        try {
            fis = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        textViewSax.setText("");
        ParseService ps = new Sax();
        long startTime = System.currentTimeMillis();
        ArrayList<MMAConfig> mmaConfigs = (ArrayList<MMAConfig>) ps.doParse(fis);
        long timeTaken = (System.currentTimeMillis() - startTime);
        String logText = "Sax : " + timeTaken + "ms";
        Log.d(TAG, "loadFromSax " + logText);
        if (null != mmaConfigs) {
            for (MMAConfig mmaConfig : mmaConfigs) {
                Log.d(TAG, "loadFromSax mmaConfig version=" + mmaConfig.version + "  plat=" +
                        mmaConfig.plat);
            }
        }
        textViewSax.setText(logText);
    }
}
