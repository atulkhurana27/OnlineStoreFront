package com.CabPortal.DAO;

import com.CabPortal.Entities1.City;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class CityDAO extends AbstractDAO<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
