package com.webMvc.dao;

import com.webMvc.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDaoJpaImp implements ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Product> getAllProducts() {
        return entityManager.createQuery(" from Product order by price desc ", Product.class)
                .getResultList();
    }

    @Override
    public Product savedProduct(Product p) {
         entityManager.merge(p);
         return p;
    }

    @Override
    public Product getProduct(Long id) {
        return entityManager.find(Product.class , id);
    }

    @Override
    public void deleteProduct(Long id) {
        entityManager.createQuery("delete from Product where id=:productId")
                .setParameter("productId" , id)
                .executeUpdate();
    }
}
