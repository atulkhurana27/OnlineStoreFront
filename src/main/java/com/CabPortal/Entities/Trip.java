package com.CabPortal.Entities;

import java.util.Date;

public class Trip {

    private String cabId;
    private String TripID;
    private String bookingId;
    private String status;
    private Date endTime;
    private volatile static int n = 0;

    public Trip(String cabId, String tripID, String bookingId, String status, Date endTime) {
        this.cabId = cabId;
        TripID = this.nextNum();
        this.bookingId = bookingId;
        this.status = status;
        this.endTime = endTime;
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

    public String getTripID() {
        return TripID;
    }

    public void setTripID(String tripID) {
        TripID = tripID;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
