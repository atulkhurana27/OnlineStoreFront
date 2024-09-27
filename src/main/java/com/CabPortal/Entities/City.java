package com.CabPortal.Entities;

public class City {

    private String cityName;
    private String state;
    private Integer pin;

    private String ID;
    private volatile static int n = 0;

    public City(String cityName, String state, Integer pin, String ID) {
        this.cityName = cityName;
        this.state = state;
        this.pin = pin;
        this.ID = this.nextNum();
    }

    private synchronized String nextNum(){
        n++;
        return n+"";
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
