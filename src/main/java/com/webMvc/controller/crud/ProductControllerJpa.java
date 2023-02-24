package com.webMvc.controller.crud;


import com.webMvc.entity.Product;
import com.webMvc.service.ProductServiceJpa;
import com.webMvc.service.model.ProductDto;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerJpa {
    private final ProductServiceJpa productServiceJpa;

    public ProductControllerJpa(ProductServiceJpa productServiceJpa) {
        this.productServiceJpa = productServiceJpa;
    }
    @GetMapping()
    public List<Product> getAll(){
        return productServiceJpa.getAll();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){

        return productServiceJpa.getProduct(id);
    }
    //add validation for this
    @PostMapping()
    public Product editOrUpddate(@Validated @RequestBody ProductDto product){

        return productServiceJpa.editOrSaved(product);
    }
    @DeleteMapping ("/{id}")
    public Long delete(@PathVariable("id") Long id){
        productServiceJpa.delete(id);
        return id;
    }
    //add init binder for all request call
    @InitBinder
    public void initBinder(@NotNull WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}
