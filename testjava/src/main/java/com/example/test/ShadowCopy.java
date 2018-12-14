package com.example.test;

import java.util.ArrayList;

public class ShadowCopy {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setName("xiao ming");
        s1.setAge(18);
        s1.mlist = new ArrayList<>();
        s1.mlist.add("ssss");
        System.out.println(s1);

        try {
            Student s2 = (Student) s1.clone();
            s2.setAge(999);
            ArrayList<String> ff = new ArrayList<>();
            s2.mlist = ff;
            System.out.println("复制后的：s1 = " + s1);
            System.out.println("复制后的：s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
