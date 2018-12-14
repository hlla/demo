package com.example.test;

import java.util.ArrayList;

public class Student implements Cloneable {
    public ArrayList<String> mlist;
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", mlist="
                + mlist + "]";
    }

    public Object clone() throws CloneNotSupportedException {
        Student newStudent = (Student) super.clone();
        newStudent.mlist = (ArrayList) mlist.clone();
        return newStudent;
    }

}