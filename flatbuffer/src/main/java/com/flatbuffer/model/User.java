package com.flatbuffer.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String sid;
    @SerializedName("tid")
    private int id;
    private String account;

    @SerializedName(value = "password", alternate = {"code", "xxx", "yyy", "zzz"})
    private String password;

    private String name;

    private int age;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        return "User [account=" + account + ", password=" + password + ", name=" + name + ", " +
                "age=" + age + "]";
    }

}