package com.CabPortal.Entities;

public class CabLocationMapping {

    private String cabId;
    private String cityId;
    private CabState cabState;
    private String currentTripId;
    private String previousTripId;
    private volatile static int n = 0;

    public CabLocationMapping(String cabId, String cityId, CabState cabState, String currentTripId, String previousTripId) {

        this.cabId = this.nextNum();
        this.cityId = cityId;
        this.cabState = cabState;
        this.currentTripId = currentTripId;
        this.previousTripId = previousTripId;
    }

    private synchronized String nextNum(){
        n++;
        return n+"";
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public CabState getCabState() {
        return cabState;
    }

    public void setCabState(CabState cabState) {
        this.cabState = cabState;
    }

    public String getCurrentTripId() {
        return currentTripId;
    }

    public void setCurrentTripId(String currentTripId) {
        this.currentTripId = currentTripId;
    }

    public String getPreviousTripId() {
        return previousTripId;
    }

    public void setPreviousTripId(String previousTripId) {
        this.previousTripId = previousTripId;
    }
}
