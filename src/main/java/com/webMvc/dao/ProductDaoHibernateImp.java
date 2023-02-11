package com.webMvc.dao;

import com.webMvc.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ProductDaoHibernateImp implements ProductDao {
    private final SessionFactory sessionFactory;

    public ProductDaoHibernateImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product order by price desc ")
                .getResultList();
    }

    @Override
    public Product savedProduct(Product p) {
        sessionFactory.getCurrentSession().saveOrUpdate(p);
        return p;
    }

    @Override
    public Product getProduct(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Product.class, id);
    }

    @Override
    public void deleteProduct(Long id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Product where id =:productId")
                .setParameter("productId" , id)
                .executeUpdate();
    }
}
