package com.webMvc.service;

import com.webMvc.dao.ProductDaoJpaImp;
import com.webMvc.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceJpa {
    private final ProductDaoJpaImp productDaoJpaImp;

    public ProductServiceJpa(ProductDaoJpaImp productDaoJpaImp) {
        this.productDaoJpaImp = productDaoJpaImp;
    }
    @Transactional
    public List<Product> getAll(){
       return productDaoJpaImp.getAllProducts();
    }
    @Transactional
    public Product getProduct(Long id){
        return productDaoJpaImp.getProduct(id);
    }
    @Transactional
    public Product editOrSaved(Product p){
        return productDaoJpaImp.savedProduct(p);
    }
    @Transactional
    public void delete(Long id){
        productDaoJpaImp.deleteProduct(id);
    }
}
