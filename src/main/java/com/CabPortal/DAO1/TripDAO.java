package com.CabPortal.DAO1;

import com.CabPortal.Entities1.Trip;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class TripDAO extends AbstractDAO<Trip> {

    public TripDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
