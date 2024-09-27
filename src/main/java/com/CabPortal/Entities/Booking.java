package com.CabPortal.Entities;

import java.util.Date;

public class Booking {

    private String userId;
    private String startLocation;
    private String endLocation;
    private Date startTime;

    private String bookingID;
    private Date currentTime;
    private BookingStatus bookingStatus;
    private volatile static int n = 0;

    public Booking(String userId, String startLocation, String endLocation, Date startTime, String bookingID, Date currentTime, BookingStatus bookingStatus) {
        this.userId = userId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.bookingID = this.nextNum();
        this.currentTime = currentTime;
        this.bookingStatus = bookingStatus;
    }

    private synchronized String nextNum(){
        n++;
        return n+"";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
