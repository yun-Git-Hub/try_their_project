package com.try_their.try_their_project.entity;

import java.sql.Timestamp;

public class UserInfo {
    private int user_id;
    private String user_name;
    private String user_password;
    private String md5_pwd;
    private String perm;
    private String userName;
    private String userID;
    private String userPhone;
    private String userAddress;
    private Timestamp times;

    public int getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getMd5_pwd() {
        return md5_pwd;
    }

    public void setMd5_pwd(String md5_pwd) {
        this.md5_pwd = md5_pwd;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }
}
