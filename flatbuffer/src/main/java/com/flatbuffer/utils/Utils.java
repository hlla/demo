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

package com.flatbuffer.utils;

import android.content.Context;
import android.util.Log;

import com.flatbuffer.activity.MainActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by amitshekhar on 17/04/16.
 */
public class Utils {

    public static byte[] readRawResource(Context context, int resId) {
        InputStream stream = null;
        byte[] buffer = null;
        try {
            stream = context.getResources().openRawResource(resId);
            buffer = new byte[stream.available()];
            while (stream.read(buffer) != -1) ;
        } catch (IOException e) {
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
        }
        return buffer;
    }


    public static InputStream readRawResourceStream(Context context, int resId) {
        InputStream stream = null;
        stream = context.getResources().openRawResource(resId);
        return stream;
    }

    public static String fileToString(String fileName) {
        File file = new File(fileName);

        BufferedReader bf = null;
        StringBuilder sb = new StringBuilder();
        try {
            bf = new BufferedReader(new FileReader(file));

            String content;
            while ((content = bf.readLine()) != null) {
                sb.append(content.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(MainActivity.TAG, "fileToString e=" + e);
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
                Log.d(MainActivity.TAG, "fileToString11 e=" + e);
            }
        }

        return sb.toString();
    }
}
