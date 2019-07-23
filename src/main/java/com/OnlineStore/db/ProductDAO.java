package com.OnlineStore.db;

import com.OnlineStore.models.Department;
import com.OnlineStore.models.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Optional;

public class ProductDAO extends AbstractDAO<Product> {

    private  final  DepartmentDAO departmentDAO;

    public ProductDAO(SessionFactory sessionFactory, DepartmentDAO departmentDAO) {
        super(sessionFactory);
        this.departmentDAO = departmentDAO;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Product create(Product product) throws  Exception
    {
        product = updateDepartmentValidateObject(product);
        product = persist(product);
        return product;
    }

    public Product update(Product product) throws  Exception {
        product = updateDepartmentValidateObject(product);
        return persist(product);
        }

    public void delete(Long id) {
        Product product = findById(id).get();
        if(product!=null){
            product.setDepartment(null);
            currentSession().delete(product);
        }
    }

    public List<Product> searchByField(String searchParam, String value)  throws  Exception {
        Criteria criteria = currentSession().createCriteria(Product.class);
        if(searchParam!=null && value!=null) {
            if(searchParam.equalsIgnoreCase("department")) {
                criteria.createAlias("department", "department");
                criteria.add(Restrictions.eq("department.name", value));
                return criteria.list();
            }
            else if(!searchParam.equalsIgnoreCase("active") && !searchParam.equalsIgnoreCase("lifecycleStart")
                    && !searchParam.equalsIgnoreCase("lifecycleEnd")) {
                criteria.add(Restrictions.eq(searchParam, value.toString()));
                return criteria.list();
            } else {
                throw new Exception("Unsupported format");
            }
        } else {
            return criteria.list();
        }
    }

    public Product updateDepartmentValidateObject(Product product) throws  Exception{
        Department department = departmentDAO.findByName(product.getDepartment());
        if(department!=null)
            product.setDepartment(department);
        checkValidLikeProducts(product);
        return product;
    }

    public void checkValidLikeProducts(Product product)  throws  Exception{
        boolean valid =true;
        for (Long val:product.getLikeProducts()) {
            Optional<Product> product1 = findById(val);
            if(!product1.isPresent()){
                throw new Exception("Unsupported format");
            }
        }
    }
}
