package com.CabPortal.DAO1;

import com.CabPortal.Entities1.Cab;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class CabDAO extends AbstractDAO<Cab> {
    public CabDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private
}
