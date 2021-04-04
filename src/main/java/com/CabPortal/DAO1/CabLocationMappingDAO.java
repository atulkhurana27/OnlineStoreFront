package com.CabPortal.DAO1;

import com.CabPortal.Entities1.CabLocationMapping;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class CabLocationMappingDAO  extends AbstractDAO<CabLocationMapping> {
    public CabLocationMappingDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
