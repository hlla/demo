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

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.example.tutorial.AddressBookProtos;
import com.flatbuffer.AddressBookProtobuf;
import com.flatbuffer.R;
import com.flatbuffer.flatmodel.PeopleList;
import com.flatbuffer.jsonmodel.Bean;
import com.flatbuffer.model.AddressBook;
import com.flatbuffer.model.PeopleListJson;
import com.flatbuffer.model.SimplePeople;
import com.flatbuffer.model.User;
import com.flatbuffer.utils.DeviceInfoUtils;
import com.flatbuffer.utils.Utils;
import com.flatbuffer.utils.XmlUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonActivity extends AppCompatActivity {
    private static final int TEST_NUM = 100;
    public static final String TAG = JsonActivity.class.getSimpleName();
    private TextView textViewFlat;
    private TextView textViewJson;
    private TextView textViewFastJson;
    private TextView textViewAndroidJson;
    private static ImageView sImageView;
    private String mJson;
    private String mJsonData = "";
    private String[] mNames = null;
    private SharedPreferences mSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textViewFlat = (TextView) findViewById(R.id.textViewFlat);
        textViewJson = (TextView) findViewById(R.id.textViewJson);
        textViewFastJson = (TextView) findViewById(R.id.textViewFastJson);
        textViewAndroidJson = (TextView) findViewById(R.id.textViewAndroidJson);
        sImageView = new ImageView(this);
//        mJson = Utils.fileToString(Environment.getExternalStorageDirectory() + "/sample_json
// .json");
        mSP = getSharedPreferences("abc", 0);
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
//        textViewJson.setText("");
//        Log.d(TAG, "loadFromJson 1");
////        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw
// .sample_json));
//        Log.d(TAG, "loadFromJson 2 ");
//        if (TextUtils.isEmpty(mJson)) {
//            return;
//        }
//        long startTime = System.currentTimeMillis();
//        com.flatbuffer.jsonmodel.PeopleListJson peopleList = null;
//        int m = 1;
//        for (int i = 0; i < m; i++) {
//            peopleList = new Gson().fromJson(mJson, com.flatbuffer.jsonmodel.PeopleListJson
// .class);
//        }
//        long timeTaken = (System.currentTimeMillis() - startTime) / m;
//        String logText = "loadFromGson : " + timeTaken + "ms";
//        Log.d(TAG, "loadFromGson " + logText + " peopleList=" + peopleList);
//        int count = 0;
//        if (null != peopleList) {
//            count = peopleList.count();
//        }
//        textViewJson.setText(logText + "  count.=" + count);
        List<SimplePeople> peoples = new ArrayList<>();
        int m = 50000;
        mNames = new String[m];
        for (int i = 0; i < m; i++) {
            SimplePeople people = SimplePeople.fillData();
            peoples.add(people);
            mNames[i] = String.valueOf("i");

        }
        mJsonData = JSON.toJSONString(peoples);
    }

    public void loadFromGsonGet(View view) {
        Gson gson = new Gson();

        String userStr = "{\"id\":\"111dfdsff11\",\"account\":\"admin\",\"password\":\"123456\"," +
                "\"age\":30,\"code\":\"000000\"}";
        User user = gson.fromJson(userStr, User.class);

        userStr = "{\"account\":\"admin1\",\"code\":\"000000\",\"xxx\":\"aaaaaa\",\"age\":20}";
        user = gson.fromJson(userStr, User.class);

        userStr = "{\"account\":\"adminX\",\"xxx\":\"aaaaaa\",\"age\":40}";
        user = gson.fromJson(userStr, User.class);

        userStr = "{\"account\":\"adminY\",\"yyy\":\"bbbbbb\",\"age\":45}";
        user = gson.fromJson(userStr, User.class);

        userStr = "{\"account\":\"adminZ\",\"zzz\":\"cccccc\",\"age\":50}";
        user = gson.fromJson(userStr, User.class);
//        textViewJson.setText("");
//        Log.d(TAG, "loadFromJson 1");
////        String jsonText = new String(Utils.readRawResource(getApplication(), R.raw
// .sample_json));
//        Log.d(TAG, "loadFromJson 2 ");
//        if (TextUtils.isEmpty(mJson)) {
//            return;
//        }
//        long startTime = System.currentTimeMillis();
//        PeopleListJson peopleList = null;
//        int m = 1;
//        for (int i = 0; i < m; i++) {
//            peopleList = new Gson().fromJson(mJson, PeopleListJson.class);
//        }
//        long timeTaken = (System.currentTimeMillis() - startTime) / m;
//        String logText = "Json : " + timeTaken + "ms";
//        Log.d(TAG, "loadFromGsonGet " + logText + " peopleList=" + peopleList);
//        int count = 0;
//        if (null != peopleList) {
//            count = peopleList.count();
//        }
//        textViewJson.setText(logText + "  count.=" + count);
    }

    public void loadFromGsonGetSimpleObject(View view) {
        String string = DeviceInfoUtils.getLanguage3();
        Log.d(TAG, "loadFromGsonGetSimpleObject: string=" + string);
//        textViewJson.setText("");
//        PeopleListJson peopleList = null;
        StringBuffer logText = new StringBuffer();
        long timeTaken = 0;
        long startTime = 0;
        ArrayList<SimplePeople> peoples = new ArrayList<SimplePeople>();
        SimplePeople people1 = SimplePeople.fillData(String.valueOf(1));
        String jsonData = "";
        for (int i = 0; i < TEST_NUM; i++) {
            SimplePeople people = SimplePeople.fillData(String.valueOf(i));
            peoples.add(people);

        }
//        HashMap<String, String> map = new HashMap<>();
//        for (int i = 0; i < TEST_NUM; i++) {
//            map.put("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i);
////            mSP.edit().putString("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i)
////                    .apply();
//        }
//        Type type = new TypeToken<HashMap<String, String>>() {
//        }.getType();
        Type type = new TypeToken<List<SimplePeople>>() {
        }.getType();
        startTime = System.currentTimeMillis();
        Gson gson1 = new Gson();
        byte[] datas = null;
//        jsonData = gson1.toJson(peoples);
        jsonData = gson1.toJson(people1);
        datas = jsonData.getBytes();
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "gsonjson");
        try {
//            int num = datas.length / 10240;
            FileOutputStream fos = new FileOutputStream(file.getPath());
//            for (int i = 0; i < num; i++) {
//                fos.write(datas, i * 10240, 10240);
            fos.write(datas, 0, datas.length);
//            }
            fos.close();

//            FileWriter fileWriter = new FileWriter(file);
//            Gson gson = new GsonBuilder().create();
////            gson.toJson(map, type, gson.newJsonWriter(fileWriter));
//            gson.toJson(peoples, peoples.getClass(), gson.newJsonWriter(fileWriter));
//            fileWriter.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        timeTaken = (System.currentTimeMillis() - startTime);
        logText = new StringBuffer("gson SO 序列化 : " + timeTaken + "ms  length=" + file.length());
        startTime = System.currentTimeMillis();
//        map = new HashMap<>();
//        peoples = null;
        Gson gson = new GsonBuilder().create();
        try {
//            map = gson.fromJson(gson.newJsonReader(new FileReader(file)), type);
//            peoples = gson.fromJson(gson.newJsonReader(new FileReader(file)), type);
            people1 = gson.fromJson(gson.newJsonReader(new FileReader(file)), people1.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        timeTaken = (System.currentTimeMillis() - startTime);
//        int count = 0;
////        peoples = new Gson().fromJson(jsonData, new TypeToken<List<SimplePeople>>() {
////        }.getType());s
////        peoples = new Gson().fromJson(jsonData, type);
////        if (null != peoples) {
////            count = peoples.size();
////        }
////        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append(",").append("gson SO 反序列化 : " + timeTaken + "ms");
//        startTime = System.currentTimeMillis();
//        SimplePeople people = SimplePeople.fillData("1");
//        peoples.add(people);
//        jsonData = gson1.toJson(people);
////        datas = jsonData.getBytes();
//        FileOutputStream fos = null;
//        RandomAccessFile raf = null;
//        try {
//            raf = new RandomAccessFile(file, "rw");
//            raf.seek(raf.length() - 1);
//            raf.writeBytes("," + jsonData + "]");
//            raf.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            fos = new FileOutputStream(file.getPath());
//            fos.write(datas, 0, datas.length);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        timeTaken = (System.currentTimeMillis() - startTime);
//        logText.append(",").append("gson SO 序列化 : " + timeTaken + "ms");
//        textViewJson.setText(logText + "  count.=" + count + " length=" + datas.length);
//        textViewJson.setText(logText + "  count.=" + map.size() + " length=" + file.length());
        textViewJson.setText(logText + "  count.=" + peoples.size() + " length=" + file.length());
//        Log.d(TAG, "loadFromGsonGet " + logText + " peoples=" + peoples.get(0));
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
            peopleList = JSON.parseObject(mJson, PeopleListJson.class, Feature
                    .DisableCircularReferenceDetect);
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

//        textViewFastJson.setText("");
//        Log.d(TAG, "loadFromFastJson 1 ");
//        if (TextUtils.isEmpty(mJson)) {
//            return;
//        }
//        Log.d(TAG, "loadFromFastJson 2");
//        long startTime = System.currentTimeMillis();
//        com.flatbuffer.jsonmodel.PeopleListJson peopleList = null;
//        int m = 1;
//        for (int i = 0; i < m; i++) {
//            peopleList = JSON.parseObject(mJson, com.flatbuffer.jsonmodel.PeopleListJson.class);
//        }
//        long timeTaken = (System.currentTimeMillis() - startTime) / m;
//        String logText = "FastJson : " + timeTaken + "ms";
//        int count = 0;
//        if (null != peopleList) {
//            count = peopleList.count();
//        }
//        Log.d(TAG, "loadFromFastJsonGet count =" + count);
//        textViewFastJson.setText(logText + "  count=" + count);
    }

    public void loadFromFastJsonSimpleObject(View view) {
        textViewJson.setText("");
//        long startTime = System.currentTimeMillis();
//        PeopleListJson peopleList = null;
        List peoples = new ArrayList<SimplePeople>();
        String jsonData = "";
        int m = 50000;
        for (int i = 0; i < m; i++) {
            SimplePeople people = SimplePeople.fillData();
            peoples.add(people);

        }
        long startTime = System.currentTimeMillis();
        jsonData = JSON.toJSONString(peoples);
        byte[] datas = jsonData.getBytes();
        try {
            File dir = Environment.getExternalStorageDirectory();
            File file = new File(dir, "fastjson");
            FileOutputStream fos = new FileOutputStream(file.getPath());
            fos.write(datas);
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long timeTaken = (System.currentTimeMillis() - startTime);
//        StringBuffer logText = new StringBuffer();
        StringBuffer logText = new StringBuffer("fastjson SO 序列化 : " + timeTaken + "ms");
        int count = 0;
        startTime = System.currentTimeMillis();
        peoples = JSON.parseArray(jsonData, SimplePeople.class);
        if (null != peoples) {
            count = peoples.size();
        }

        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append(",").append("fastjson SO 反序列化 : " + timeTaken + "ms");
        textViewJson.setText(logText + "  count.=" + count + " length=" + datas.length);
        Log.d(TAG, "loadFromFastJsonSimpleObject " + logText + " peoples=" + peoples.get(0));
    }

    public void loadFromAndroidJsonSO(View view) {
        textViewJson.setText("");
        long startTime = System.currentTimeMillis();
        PeopleListJson peopleList = null;
        ArrayList peoples = new ArrayList<SimplePeople>();
        String jsonData = "";
        int m = 50000;
        for (int i = 0; i < m; i++) {
            SimplePeople people = SimplePeople.fillData();
            peoples.add(people);

        }
        jsonData = toJsonString(peoples);
        byte[] datas = jsonData.getBytes();
        try {
            File dir = Environment.getExternalStorageDirectory();
            File file = new File(dir, "android_json");
            FileOutputStream fos = new FileOutputStream(file.getPath());
            fos.write(datas);
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long timeTaken = (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        StringBuffer logText = new StringBuffer("org json SO 序列化 : " + timeTaken + "ms");
        int count = 0;
        peoples.clear();
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonData);
            org.json.JSONArray jsonArray = jsonObject.getJSONArray("simplePeoples");
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                SimplePeople people = new SimplePeople();
                org.json.JSONObject peopleJson = jsonArray.getJSONObject(i);
//                people.setName(peopleJson.optString("name"));
//                people.setId(peopleJson.optString("id"));
//                people.setIndex(peopleJson.optInt("index"));
//                people.setGuid(peopleJson.optString("guid"));
////                people.setName(peopleJson.optString("name"));
                people.setEmail0(peopleJson.optString("email"));
                peoples.add(people);
            }
        } catch (Exception e) {

        }
        if (null != peoples) {
            count = peoples.size();
        }
        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append(",").append("org json SO 反序列化 : " + timeTaken + "ms");
        textViewJson.setText(logText + "  count.=" + count + " length=" + jsonData.length() + " " +
                "datas=" + datas.length);
        Log.d(TAG, "loadFromAndroidJsonSO " + logText + " peoples=" + peoples.get(0));
    }

    private void test() {
        String a = "{\"key\":\"123\", \"title\":\"asd\", \"values\":[\"a\", \"b\", \"c\", \"d\"]," +
                " \"defaultValue\":\"a\"}";
        List peoples = new ArrayList<SimplePeople>();
        Gson Gson = new Gson();
        Bean testBean = Gson.fromJson(a, Bean.class);
        long now = System.currentTimeMillis();
        for (int i = 0; i < 50000; ++i) {
            Bean.fromJsonString(a);
        }
        Log.d(TAG, "jsonobject parse use time=" + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        for (int i = 0; i < 50000; ++i) {
            peoples.add(Gson.fromJson(a, Bean.class));
        }
        Log.d(TAG, "Gson parse use time=" + (System.currentTimeMillis() - now) + " people=" +
                peoples.get(0));


        now = System.currentTimeMillis();
        for (int i = 0; i < 50000; ++i) {
            Bean.toJsonString(testBean);
        }
        Log.d(TAG, "jsonobject tojson use time=" + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        for (int i = 0; i < 50000; ++i) {
            Gson.toJson(testBean);
        }
        Log.d(TAG, "Gson tojson use time=" + (System.currentTimeMillis() - now));
    }

    public void loadFromAndroidJson(View view) {

//        textViewAndroidJson.setText("");
//        Log.d(TAG, "loadFromAndroidJson 1 ");
//        test();
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
//                people.setName(peopleJson.optString("company"));
//                people.setId(peopleJson.optString("id"));
//                people.setIndex(peopleJson.optInt("index"));
//                people.setGuid(peopleJson.optString("guid"));
//                people.setName(peopleJson.optString("name"));
//                people.setEmail0(peopleJson.optString("email"));
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

    public void loadFromPBSO(View view) {
        StringBuffer logText = new StringBuffer();
        long startTime = System.currentTimeMillis();
        long timeTaken = 0;
        File file = AddressBookProtobuf.encodeTest(50000);
        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append("protobuf SO 序列化 : " + timeTaken + "ms");
        startTime = System.currentTimeMillis();
        AddressBookProtos.AddressBook addressBook = AddressBookProtobuf.decodeTest();
        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append(",").append("pb SO 反序列化 : " + timeTaken + "ms");
//        Log.d(TAG, "loadFromFastJson " + logText + "  value=" + Integer.parseInt(adConfigBean
//                .getClickHandle(), 16));
        textViewAndroidJson.setText(logText + "  count=" + addressBook.getPersonList().size() + "" +
                " size=" + file.length());
    }

    public void serializeSO(View view) {
        SimplePeople people1 = SimplePeople.fillData(String.valueOf(1));
        StringBuffer logText = new StringBuffer();
        long timeTaken = 0;
//        AddressBook addressBook = new AddressBook();
        ArrayList<SimplePeople> peoples = new ArrayList<SimplePeople>();
        for (int i = 0; i < TEST_NUM; i++) {
            SimplePeople people = SimplePeople.fillData(String.valueOf(i));
            peoples.add(people);
        }
        long startTime = System.currentTimeMillis();
//        HashMap<String, String> map = new HashMap<>();
//        for (int i = 0; i < TEST_NUM; i++) {
//            map.put("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i);
////            mSP.edit().putString("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i)
////                    .apply();
//        }
        File file = new File(Environment.getExternalStorageDirectory(), "serialize.txt");
//        addressBook.simplePeoples = peoples;
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//            oos.writeObject(peoples);
            oos.writeObject(people1);
            oos.close();
            outputStream.close();
        } catch (IOException e) {
        }
//        map = new HashMap<>();
        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append("serialize SO 序列化 : " + timeTaken + "ms");
//        peoples = null;
        startTime = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//            map = (HashMap) ois.readObject();
//            peoples = (ArrayList) ois.readObject();
            people1 = (SimplePeople) ois.readObject();
            ois.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        timeTaken = (System.currentTimeMillis() - startTime);
        logText.append(",").append("serialize SO 反序列化 : " + timeTaken + "ms");
//        Log.d(TAG, "loadFromFastJson " + logText + "  value=" + Integer.parseInt(adConfigBean
//                .getClickHandle(), 16));
//        textViewAndroidJson.setText(logText + "  count=" + addressBook.simplePeoples.size() + "" +
//                " size=" + file.length());
        textViewAndroidJson.setText(logText + "  count=" + peoples.size() + " length=" + file
                .length());
//        textViewAndroidJson.setText(logText + "  size=" + file.length() + " map.size=" + map.size
//                ());
    }

    public void testsp(View view) {
        StringBuffer logText = new StringBuffer();
        long startTime;
        startTime = System.currentTimeMillis();
        int count = 1;
        for (int i = 0; i < TEST_NUM; i++) {
            String key = "name" + i;
            String value = "value" + i;
            mSP.edit().putString(key, value).commit();
        }
        long cost = System.currentTimeMillis() - startTime;
        logText.append("插入sp的个数:").append(count).append(" 花费时间:").append(cost);
        textViewAndroidJson.setText(logText);
    }

    public void testInitSp(View view) {
        HashMap<String, String> map = new HashMap<>();
        long startTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            map.put("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i);
//            mSP.edit().putString("name_test_abcde_fdsfdsggfdg" + i, "value_kk_fdsfdggfdg" + i)
//                    .apply();
        }
        StringBuffer logText = new StringBuffer();
        File file = new File(Environment.getExternalStorageDirectory(), "test.xml");
        FileOutputStream str = null;
        File backupFile = new File(Environment.getExternalStorageDirectory(), "test_bk.xml");
        file.renameTo(backupFile);
        Log.d(TAG, "testInitSp: exist=" + file.exists());
        try {
            str = new FileOutputStream(file);
            XmlUtils.writeMapXml(map, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            str.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - startTime;
        logText.append("初始化sp的花费时间:").append(cost);
        textViewAndroidJson.setText(logText);
    }

    public static String toJsonString(ArrayList<SimplePeople> peopleList) {
        if (peopleList == null) {
            return null;
        }
        AddressBook addressBook = new AddressBook();
        addressBook.simplePeoples = peopleList;
//        org.json.JSONArray jsonArray = new org.json.JSONArray();
//        org.json.JSONObject jsonObject = new org.json.JSONObject();
//        int length = peopleList.size();
//        for (int i = 0; i < length; i++) {
//            SimplePeople people = peopleList.get(i);
//            try {
////                jsonObject.put("id", people.getId());
////                jsonObject.put("index", people.getIndex());
////                jsonObject.put("email", people.getEmail0());
////                jsonObject.put("company", people.getName());
////                jsonObject.put("guid", people.getGuid());
////                jsonObject.put("gender", people.getGender());
////                jsonObject.put("name", people.getName());
//                jsonObject.put("company", people.getName());
//                jsonObject.put("email", people.getEmail0());
//                jsonArray.put(jsonObject);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }

//        return jsonArray.toString();
        return JSON.toJSONString(addressBook);
    }
}
