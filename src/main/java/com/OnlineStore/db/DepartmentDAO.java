package com.OnlineStore.db;

import com.OnlineStore.models.Department;
import com.OnlineStore.models.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class DepartmentDAO extends AbstractDAO<Product> {

    public DepartmentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Department findByName(String name) {
        Criteria criteria = currentSession().createCriteria(Department.class);

            criteria.add(Restrictions.eq("name", name));
            Object department = criteria.uniqueResult();
            if (department != null) {
                return (Department) department;
            }
        return null;
    }
}
