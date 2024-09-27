package com.CabPortal.Entities1;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserType userType;

    @Column(name = "personalIdentityNo", nullable = false, unique = true)
    private String personalIdentityNo;

    @Column(name = "personalIdentityType", nullable = false)
    private String personalIdentityType;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "creationDate", nullable = false)
    private long creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPersonalIdentityNo() {
        return personalIdentityNo;
    }

    public void setPersonalIdentityNo(String personalIdentityNo) {
        this.personalIdentityNo = personalIdentityNo;
    }

    public String getPersonalIdentityType() {
        return personalIdentityType;
    }

    public void setPersonalIdentityType(String personalIdentityType) {
        this.personalIdentityType = personalIdentityType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }
}
