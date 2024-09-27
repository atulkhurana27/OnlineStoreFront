package com.CabPortal.models;

public class CabRegistrationRequest {

    private String cabRegID;
    private String carType;
    private String location;
    private String ownerName;

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
}
