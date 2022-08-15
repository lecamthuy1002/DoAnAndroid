package com.example.doanandroid;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class KhachSan implements Serializable {
    private int id;
    private String tenks;
    private String img;
    private String rating;
    private String describe;
    private String price;
    private String img1;
    private String img2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachSan(int id, String tenks, String img, String rating, String describe, String price, String img1, String img2) {
        this.id = id;
        this.tenks = tenks;
        this.img = img;
        this.rating = rating;
        this.describe = describe;
        this.price = price;
        this.img1 = img1;
        this.img2 = img2;
    }

    public KhachSan(String ten, String img, String rating, String describe, String price, String img1, String img2) {
        this.tenks = ten;
        this.img = img;
        this.rating = rating;
        this.describe = describe;
        this.price = price;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getTenks() {
        return tenks;
    }

    public void setTenks(String tenks) {
        this.tenks = tenks;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
}
