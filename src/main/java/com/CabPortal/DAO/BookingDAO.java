package com.CabPortal.DAO;

import com.CabPortal.Entities1.Booking;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class BookingDAO extends AbstractDAO<Booking> {
    public BookingDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


}
