package com.webMvc.service;

import com.webMvc.dao.ProductDaoHibernateImp;
import com.webMvc.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceHibernate {
    private final ProductDaoHibernateImp dao;

    public ProductServiceHibernate(ProductDaoHibernateImp dao) {
        this.dao = dao;
    }
    @Transactional
    public List<Product> getAllProducts(){
        return dao.getAllProducts();
    }
    @Transactional
    public Product savedProduct(Product p){
        return dao.savedProduct(p);
    }
    @Transactional
    public void deleteProduct(Long id){
        dao.deleteProduct(id);
    }
    @Transactional
    public Product getProduct(Long id){
        return  dao.getProduct(id);
    }

}
