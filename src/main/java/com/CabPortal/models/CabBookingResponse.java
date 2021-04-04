package com.CabPortal.models;

public class CabBookingResponse {

    private String Status;
    private String  cabId;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }
}
