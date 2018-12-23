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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.flatbuffer.R;
import com.flatbuffer.flatmodel.PeopleList;
import com.flatbuffer.model.PeopleListJson;
import com.flatbuffer.utils.Utils;
import com.google.gson.Gson;

import java.nio.ByteBuffer;

public class JsonActivity extends AppCompatActivity {

    public static final String TAG = JsonActivity.class.getSimpleName();
    private TextView textViewFlat;
    private TextView textViewJson;
    private TextView textViewFastJson;
    private TextView textViewAndroidJson;
    private static ImageView sImageView;
    private String mJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textViewFlat = (TextView) findViewById(R.id.textViewFlat);
        textViewJson = (TextView) findViewById(R.id.textViewJson);
        textViewFastJson = (TextView) findViewById(R.id.textViewFastJson);
        textViewAndroidJson = (TextView) findViewById(R.id.textViewAndroidJson);
        sImageView = new ImageView(this);
        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/sample_json.json");
    }

    public void loadFromFlatBuffer(View view) {
        byte[] buffer = Utils.readRawResource(getApplication(), R.raw
                .sample_flatbuffer);
        long startTime = System.currentTimeMillis();
        ByteBuffer bb = ByteBuffer.wrap(buffer);
        PeopleList peopleList = PeopleList.getRootAsPeopleList(bb);
        long timeTaken = System.currentTimeMillis() - startTime;
        String logText = "FlatBuffer : " + timeTaken + "ms";
        textViewFlat.setText(logText);
        Log.d(TAG, "loadFromFlatBuffer " + logText + " length=" + peopleList.peoplesLength());
    }

    public void loadFromGson(View view) {
        textViewJson.setText("");
        Log.d(TAG, "loadFromJson 1");
//        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw.sample_json));
        Log.d(TAG, "loadFromJson 2 ");
        if (TextUtils.isEmpty(mJson)) {
            return;
        }
        long startTime = System.currentTimeMillis();
        com.flatbuffer.jsonmodel.PeopleListJson peopleList = null;
        int m = 1;
        for (int i = 0; i < m; i++) {
            peopleList = new Gson().fromJson(mJson, com.flatbuffer.jsonmodel.PeopleListJson.class);
        }
        long timeTaken = (System.currentTimeMillis() - startTime) / m;
        String logText = "loadFromGson : " + timeTaken + "ms";
        Log.d(TAG, "loadFromGson " + logText + " peopleList=" + peopleList);
        int count = 0;
        if (null != peopleList) {
            count = peopleList.count();
        }
        textViewJson.setText(logText + "  count.=" + count);
    }

    public void loadFromGsonGet(View view) {
        textViewJson.setText("");
        Log.d(TAG, "loadFromJson 1");
//        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw.sample_json));
        Log.d(TAG, "loadFromJson 2 ");
        if (TextUtils.isEmpty(mJson)) {
            return;
        }
        long startTime = System.currentTimeMillis();
        PeopleListJson peopleList = null;
        int m = 1;
        for (int i = 0; i < m; i++) {
            peopleList = new Gson().fromJson(mJson, PeopleListJson.class);
        }
        long timeTaken = (System.currentTimeMillis() - startTime) / m;
        String logText = "Json : " + timeTaken + "ms";
        Log.d(TAG, "loadFromGsonGet " + logText + " peopleList=" + peopleList);
        int count = 0;
        if (null != peopleList) {
            count = peopleList.count();
        }
        textViewJson.setText(logText + "  count.=" + count);
    }

    public void loadFromFastJson(View view) {
        textViewFastJson.setText("");
        Log.d(TAG, "loadFromFastJson 1 ");
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/sample_json
// .json");
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/arkapsconf
// .json");
        if (TextUtils.isEmpty(mJson)) {
            return;
        }
//        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw.sample_json));
        Log.d(TAG, "loadFromFastJson 2");
        long startTime = System.currentTimeMillis();
//        JSONReader reader = new JSONReader(new BufferedReader(new InputStreamReader(Utils
//                .readRawResourceStream(getApplication(), R.raw.sample_json))));
//        reader.startArray();
//        while(reader.hasNext()) {
//            i++;
//            PeopleJson peopleJson = reader.readObject(PeopleJson.class);
//        }
//        reader.endArray();
//        reader.close();
        PeopleListJson peopleList = null;
        int m = 1;
        for (int i = 0; i < m; i++) {
//            peopleList = JSON.parseObject(mJson, PeopleListJson
//                    .class, Feature.DisableCircularReferenceDetect);
            peopleList = JSON.parseObject(mJson, PeopleListJson.class);
        }
//        AdConfigBean adConfigBean = JSON.parseObject(mJson, AdConfigBean.class);
        long timeTaken = (System.currentTimeMillis() - startTime) / m;
        String logText = "FastJson : " + timeTaken + "ms";
//        textViewFastJson.setText(logText);
//        Log.d(TAG, "loadFromFastJson " + logText + "  value=" + Integer.parseInt(adConfigBean
//                .getClickHandle(), 16));
//        for (PeopleJson peopleJson : peopleList.getPeoples()) {
////            Log.d(TAG, "loadFromFastJson " + peopleJson.company + "," + peopleJson.id);
//            i++;
//        }
        int count = 0;
        if (null != peopleList) {
            count = peopleList.count();
        }
        Log.d(TAG, "loadFromFastJson count =" + count);
        textViewFastJson.setText(logText + "  count=" + count);
    }

    public void loadFromFastJsonGet(View view) {
        textViewFastJson.setText("");
        Log.d(TAG, "loadFromFastJson 1 ");
        if (TextUtils.isEmpty(mJson)) {
            return;
        }
        Log.d(TAG, "loadFromFastJson 2");
        long startTime = System.currentTimeMillis();
        com.flatbuffer.jsonmodel.PeopleListJson peopleList = null;
        int m = 1;
        for (int i = 0; i < m; i++) {
            peopleList = JSON.parseObject(mJson, com.flatbuffer.jsonmodel.PeopleListJson.class);
        }
        long timeTaken = (System.currentTimeMillis() - startTime) / m;
        String logText = "FastJson : " + timeTaken + "ms";
        int count = 0;
        if (null != peopleList) {
            count = peopleList.count();
        }
        Log.d(TAG, "loadFromFastJsonGet count =" + count);
        textViewFastJson.setText(logText + "  count=" + count);
    }

    public void loadFromAndroidJson(View view) {
        textViewAndroidJson.setText("");
        Log.d(TAG, "loadFromAndroidJson 1 ");
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/sample_json
// .json");
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/arkapsconf
// .json");
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/sample_json
// .json");
//        if (TextUtils.isEmpty(mJson)) {
//            return;
//        }
////        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw
// .sample_json));
//        Log.d(TAG, "loadFromAndroidJson 2");
//        long startTime = System.currentTimeMillis();
//        JSONObject jsonObject = null;
//        PeopleListJson peopleList = new PeopleListJson();
//        try {
//            jsonObject = new JSONObject(mJson);
//            JSONArray elements = jsonObject.getJSONArray("peoples");
//            int length = elements.length();
//            ArrayList peoples = new ArrayList<>();
//            for (int i = 0; i < length; i++) {
//                JSONObject peopleJson = elements.getJSONObject(i);
//                PeopleJson people = new PeopleJson();
//                people.setCompany(peopleJson.optString("company"));
//                people.setId(peopleJson.optString("id"));
//                people.setIndex(peopleJson.optInt("index"));
//                people.setGuid(peopleJson.optString("guid"));
//                people.setName(peopleJson.optString("name"));
//                people.setEmail(peopleJson.optString("email"));
//                JSONArray friendsArray = peopleJson.getJSONArray("friends");
//                ArrayList friends = new ArrayList<FriendJson>();
//                int friendLength = friendsArray.length();
//                for (int m = 0; m < friendLength; m++) {
//                    JSONObject friendJson = elements.getJSONObject(m);
//                    FriendJson friend = new FriendJson();
//                    friend.setId(friendJson.optInt("id"));
//                    friends.add(friend);
//                }
//                peoples.add(people);
//                people.setFriends(friends);
//            }
//            peopleList.setPeoples(peoples);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
////        String version = jsonObject.optString("version", "0");
////        String apptype = jsonObject.optString("APPTYPE", "0");
////        String appname = jsonObject.optString("APPNAME", "0");
////        String libName = jsonObject.optString("libName", "0");
////        int clickHandle = jsonObject.optInt("clickHandle", 0);
////        Log.d(TAG, "loadFromAndroidJson version=" + version + " apptype=" + apptype + "  " +
////                "appname=" + appname + "  libName=" + libName + "  clickHandle=" + clickHandle);
//        int count = 0;
//        if (null != peopleList && null != peopleList.getPeoples()) {
//            count = peopleList.peoples.size();
//        }
//        long timeTaken = (System.currentTimeMillis() - startTime);
//        String logText = "AndroidJson : " + timeTaken + "ms";
////        Log.d(TAG, "loadFromFastJson " + logText + "  value=" + Integer.parseInt(adConfigBean
////                .getClickHandle(), 16));
//        textViewAndroidJson.setText(logText + "  count=" + count);
    }

}
