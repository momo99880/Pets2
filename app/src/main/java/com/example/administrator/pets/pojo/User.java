package com.example.administrator.pets.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class User implements Serializable{
    private int id;
    private String u_name;
    private String pwd;
    private String city;
    private String tel;
    private String email;
    private String sex;
    private String head_photo;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", city='" + city + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", head_photo='" + head_photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHead_photo() {
        return head_photo;
    }

    public void setHead_photo(String head_photo) {
        this.head_photo = head_photo;
    }


}
