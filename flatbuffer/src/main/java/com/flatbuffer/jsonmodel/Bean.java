package com.flatbuffer.jsonmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bean {

    public String key;
    public String title;
    public String defaultValue;
    public String name;
    public String gender;
    public String email;

    public static Bean fromJsonString(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Bean bean = new Bean();
            bean.key = jsonObject.optString("key");
            bean.title = jsonObject.optString("title");
            bean.defaultValue = jsonObject.optString("defaultValue");
            bean.name = jsonObject.optString("name");
            bean.gender = jsonObject.optString("gender");
            bean.email = jsonObject.optString("email");

            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toJsonString(Bean bean) {
        if (bean == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key", bean.key);
            jsonObject.put("title", bean.title);
            jsonObject.put("defaultValue", bean.defaultValue);
            jsonObject.put("name", bean.name);
            jsonObject.put("gender", bean.gender);
            jsonObject.put("email", bean.email);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
