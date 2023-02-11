package com.webMvc.controller.crud;

import com.webMvc.entity.Product;
import com.webMvc.service.ProductServiceHibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControllerHibernate {
    private final ProductServiceHibernate service;

    public ProductControllerHibernate(ProductServiceHibernate service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @PostMapping("/save")
    @ResponseBody
    public Product savedProduct(@RequestBody Product product){
        return service.savedProduct(product);
    }
    @PostMapping("delete/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }
}
