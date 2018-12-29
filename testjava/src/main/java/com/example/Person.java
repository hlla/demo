package com.example;

/**
 * Created by chengjian on 16/9/27.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Person extends PersonParent implements Cloneable {
    //    private static final long serialVersionUID = -121111345678102L;
//    private static final long serialVersionUID = 12111134567890L;
    public String id;
    public String age;
    public String sex;
    public Address address;
    public String sss;
    public String ddddd;
    public ArrayList<Address> addressArrayList;
    public HashMap<String, String> hashMap;
    public AdGoodsInfo adGoodsInfo;
    public String name;
    public String gender;

    public static class AdGoodsInfo implements Serializable {
        private static final long serialVersionUID = -1168847566802402822L;
        public String name;
        public String title;
//        public String aa;

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("").append("name=")
                    .append(name).append(",title=").append(title);
            return stringBuffer.toString();
        }

    }

    public class Address implements Serializable {

        private static final long serialVersionUID = 1753038031752199707L;
        String country;
        String province;

        public Address(String country, String province) {
            this.country = country;
            this.province = province;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", province='" + province + '\'' +
                    '}';
        }
    }

    public Person(int id, String name) {
        this.id = id + "";
        this.name = name;
        this.sex = "man";
        ddddd = "ddd";
        address = new Address("china", "beijing");
        addressArrayList = new ArrayList<>();
        Address address1 = new Address("USA", "NewYork");
        addressArrayList.add(address);
        addressArrayList.add(address1);
        hashMap = new HashMap<>();
        adGoodsInfo = new AdGoodsInfo();
        adGoodsInfo.name = "apple";
        adGoodsInfo.title = "hongfushi";
        hashMap.put("A", "B");
        hashMap.put("C", "D");
        parent = "ppppp";
        pt = "ttttt";
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", pt='" + pt + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address +
                ", addressArrayList=" + addressArrayList +
                ", AdGoodsInfo=" + adGoodsInfo +
                ", hashMap=" + hashMap + ", sss=" + sss +", gender=" + gender +
                '}';
    }

    public Person deepClone() {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(this);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteOut
                    .toByteArray()));
            return (Person) in.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = deepClone();
//        if (null != address) {
//            person.address = (Address) address.clone();
//        }
//        if (null != addressArrayList) {
//            ArrayList<Address> arrayList = new ArrayList<>();
//            for (int i = 0; i < arrayList.size(); i++) {
//                Address address = arrayList.get(i);
//                if (null != address) {
//                    arrayList.add((Address) address.clone());
//                }
//            }
//            person.addressArrayList = arrayList;
//        }
//        if (null != hashMap) {
//            person.hashMap = (HashMap<String, String>) hashMap.clone();
//        }
        return person;
    }
}

