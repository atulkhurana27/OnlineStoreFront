package com.CabPortal.Entities;

import java.util.Date;

public class Cab {

    private String cabRegID;
    private String carType;
    private String location;
    private String ownerName;
    private Date date;
    private String ID;
    private volatile static int n = 0;

    public Cab(String cabRegID, String carType, String location, String ownerName, Date date, String ID) {
        this.cabRegID = cabRegID;
        this.carType = carType;
        this.location = location;
        this.ownerName = ownerName;
        this.date = date;
        this.ID = this.nextNum();
    }

    private synchronized String nextNum(){
        n++;
        return n+"";
    }

    public String getCabRegID() {
        return cabRegID;
    }

    public void setCabRegID(String cabRegID) {
        this.cabRegID = cabRegID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
