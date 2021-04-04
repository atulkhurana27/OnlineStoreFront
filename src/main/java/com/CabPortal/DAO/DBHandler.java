package com.CabPortal.DAO;

import com.CabPortal.Entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHandler {

    private HashMap<String, Cab> mapCab=new HashMap<String, Cab>();
    private HashMap<String, City> mapCity=new HashMap<String, City>();
    private HashMap<String, User> mapUser=new HashMap<String, User>();
    private HashMap<String, Booking> mapBooking=new HashMap<String, Booking>();
    private HashMap<String, Trip> mapTrip=new HashMap<String, Trip>();
    List<CabLocationMapping> cabMappingList=new ArrayList<CabLocationMapping>();

    public void populateCab(Cab cab){
            mapCab.put(cab.getID(),cab);
    }

    public Cab getCab(String cabId){
        Cab cabObj=mapCab.get(cabId);
        return cabObj;
    }

    public void populateCity(City city){
        mapCity.put(city.getID(),city);
    }

    public City getCity(String cityId){
        City cityObj=mapCity.get(cityId);
        return cityObj;
    }

    public void populateUser(User user){
        mapUser.put(user.getUserID(),user);
    }

    public User getUser(String userId){
        User userObj=mapUser.get(userId);
        return userObj;
    }

    public void populateBooking(Booking booking){
        mapBooking.put(booking.getBookingID(),booking);
    }

    public Booking getBooking(String bookingId){
        Booking bookingObj=mapBooking.get(bookingId);
        return bookingObj;
    }

    public void populateTrip(Trip trip){
        mapTrip.put(trip.getTripID(),trip);
    }

    public Trip getTrip(String tripId){
        Trip tripObj=mapTrip.get(tripId);
        return tripObj;
    }
}
