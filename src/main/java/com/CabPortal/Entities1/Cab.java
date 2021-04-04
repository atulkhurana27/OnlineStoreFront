package com.CabPortal.Entities1;

import javax.persistence.*;

@Entity
@Table(name = "cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserType type;

    @Column(name = "cabName", nullable = false)
    private String cabName;

    @Column(name = "personalIdentityType", nullable = false)
    private String personalIdentityType;

    @Column(name = "creationDate", nullable = false)
    private long creationDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id", nullable = false)
    private User owner;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Column(name = "id", nullable = false)
    private City cityId;

    @Column(name = "updationDate", nullable = true)
    private long updationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getPersonalIdentityType() {
        return personalIdentityType;
    }

    public void setPersonalIdentityType(String personalIdentityType) {
        this.personalIdentityType = personalIdentityType;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public long getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(long updationDate) {
        this.updationDate = updationDate;
    }
}
