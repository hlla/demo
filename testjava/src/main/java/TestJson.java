import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestJson {
    static class SimplePeople implements Serializable {
        private static final long serialVersionUID = -5091230928570026268L;
        public String name0;
        public String name1;
        public String name2;
        public String name3;
        public String name4;
        public String name5;
        public String name6;
        public String name7;
        public String name8;
        public String name9;
        public String name10;

        static SimplePeople fillData() {
            SimplePeople simplePeople = new SimplePeople();

            return fillData("1");
        }

        public static SimplePeople fillData(String i) {
            SimplePeople simplePeople = new SimplePeople();
            simplePeople.name0 = "cheetamobile0" + i + "ssfd" + i;
            simplePeople.name1 = "cheetamobile1" + i + "ssfd" + i;
            simplePeople.name2 = "cheetamobile2" + i + "ssfd" + i;
            simplePeople.name3 = "cheetamobile3" + i + "ssfd" + i;
            simplePeople.name4 = "cheetamobile4" + i + "ssfd" + i;
            simplePeople.name5 = "cheetamobile5" + i + "ssfd" + i;
            simplePeople.name6 = "cheetamobile6" + i + "ssfd" + i;
            simplePeople.name7 = "cheetamobile7" + i + "ssfd" + i;
            simplePeople.name8 = "cheetamobile8" + i + "ssfd" + i;
            simplePeople.name9 = "cheetamobile9" + i + "ssfd" + i;
            simplePeople.name10 = "cheetamobile10" + i + "ssfd" + i;
            return simplePeople;
        }


        @Override
        public String toString() {
            return "SimplePeople{" +
                    ", name0='" + name0 + '\'' +
                    ", name1='" + name1 + '\'' +
                    ", name2='" + name2 + '\'' +
                    ", name3='" + name3 + '\'' +
                    ", name4='" + name4 + '\'' +
                    ", name5='" + name5 + '\'' +
                    ", name6='" + name6 + '\'' +
                    ", name7='" + name7 + '\'' +
                    ", name8='" + name8 + '\'' +
                    ", name9='" + name9 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        int m = 10000;
        List peoples = new ArrayList<SimplePeople>();
        for (int i = 0; i < m; i++) {
            SimplePeople people = SimplePeople.fillData();
            peoples.add(people);
        }
        SimplePeople people = SimplePeople.fillData();
        long time1 = System.currentTimeMillis();
//        Map<String, String> peoples = new HashMap<String, String>();
//        for (int i = 0; i < m; i++) {
//            Date date = new Date();
//            peoples.put(date.toLocaleString() + i, date.toLocaleString());
//        }
        time1 = System.currentTimeMillis();
        String gsonJson = null;
        Gson gson = new Gson();
        for (int i = 0; i < m; i++) {
            gsonJson = gson.toJson(people);
        }
//        gsonJson = new Gson().toJson(peoples);
        System.out.println("gsonJson 单个序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                gsonJson.length());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        people = null;
        Gson gson1 = new Gson();
        for (int i = 0; i < m; i++) {
            people = gson1.fromJson(gsonJson, SimplePeople.class);
        }
        System.out.println("gsonJson 单个反序列化:=" + (System.currentTimeMillis() - time1) + " people=" +
                people);
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        gsonJson = new Gson().toJson(peoples);
        System.out.println("gsonJson 序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                gsonJson.length());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        peoples = new Gson().fromJson(gsonJson, new TypeToken<List<SimplePeople>>() {
        }.getType());
        System.out.println("gsonJson 反序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                peoples.size());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        String json = null;
        for (int i = 0; i < m; i++) {
            json = JSON.toJSONString(people);
        }
        System.out.println("fastjson1 单个序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                json.length());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        people = null;
        for (int i = 0; i < m; i++) {
            people = (SimplePeople) JSON.parseObject(json, SimplePeople.class);
        }
        System.out.println("fastjson 单个反序列化:=" + (System.currentTimeMillis() - time1) + " " +
                "people=" + people);
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        json = JSON.toJSONString(peoples);
//        time1 = System.currentTimeMillis();
//        String json1 = JSONObject.toJSONString(peoples);
        System.out.println("fastjson 序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                json.length());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();
        peoples = JSONObject.parseArray(json, SimplePeople.class);
        System.out.println("fastjson 反序列化:=" + (System.currentTimeMillis() - time1) + " length=" +
                peoples.size());
    }
}
