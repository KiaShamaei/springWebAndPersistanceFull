package com.webMvc.dao;

import com.webMvc.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    Product savedProduct(Product p);
    Product getProduct(Long id);
    void deleteProduct(Long id);


}
