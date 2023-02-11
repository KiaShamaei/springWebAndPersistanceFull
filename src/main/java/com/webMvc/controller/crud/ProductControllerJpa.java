package com.webMvc.controller.crud;


import com.webMvc.entity.Product;
import com.webMvc.service.ProductServiceJpa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productJpa")
public class ProductControllerJpa {
    private final ProductServiceJpa productServiceJpa;

    public ProductControllerJpa(ProductServiceJpa productServiceJpa) {
        this.productServiceJpa = productServiceJpa;
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAll(){
        return productServiceJpa.getAll();
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id){
        return productServiceJpa.getProduct(id);
    }
    @PostMapping("/addOrEdit")
    @ResponseBody
    public Product editOrUpddate(@RequestBody Product product){
        return productServiceJpa.editOrSaved(product);
    }
    @PostMapping("/delete/{id}")
    @ResponseBody
    public Long delete(@PathVariable("id") Long id){
        productServiceJpa.delete(id);
        return id;
    }
}
