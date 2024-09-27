package com.CabPortal.Entities;

import java.util.Date;

public class User {

    private String name;
    private String phone;
    private String email;
    private String govId;
    private UserType type;
    private String userID;
    private Date date;
    private volatile static int n = 0;

    public User(String name, String phone, String email, String govId, UserType type, String userID, Date date) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.govId = govId;
        this.type = type;
        this.userID = this.nextNum();
        this.date = date;
    }

    private synchronized String nextNum(){
        n++;
        return n+"";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGovId() {
        return govId;
    }

    public void setGovId(String govId) {
        this.govId = govId;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
