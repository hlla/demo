package com.example;

import com.alibaba.fastjson.JSON;

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
            return simplePeople;
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
        int m = 50000;
        List peoples = new ArrayList<SimplePeople>();
        for (int i = 0; i < m; i++) {
            SimplePeople people = SimplePeople.fillData();
            peoples.add(people);
        }
        long time1 = System.currentTimeMillis();
        JSON.toJSONString(peoples);
        System.out.println(time1 - time1);
    }
}
