package com.example.doanandroid;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String phoneNum;
    private String address;
    private String sex;

    public User(int id, String name, String email, String phoneNum, String address, String sex) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
