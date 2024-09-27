package com.CabPortal.models;

import java.util.Date;

public class CabRegistrationResponse {

    private String id;
    private Date dateRegistered;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
