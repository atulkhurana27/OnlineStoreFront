package com.CabPortal.Entities1;

import javax.persistence.*;

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus bookingStatus;

    @Column(name = "userId", nullable = false)
    private String userId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "name", nullable = false)
    private City startLocation;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "name", nullable = false)
    private City endLocation;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "name", nullable = false)
    private Trip tripId;

    @Column(name = "bookingDate", nullable = false)
    private long bookingDate;

    @Column(name = "startDate", nullable = false)
    private long startDate;
}
