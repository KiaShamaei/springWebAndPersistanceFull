package com.webMvc.controller.crudMvc;


import com.webMvc.entity.Product;
import com.webMvc.service.ProductServiceHibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/productHibernate")
public class ProductControllerHibernateMvc {
    private final ProductServiceHibernate productService;

    public ProductControllerHibernateMvc(ProductServiceHibernate productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProduct(Model model){
        var list = productService.getAllProducts();
        model.addAttribute("products" , list);
        return "list-products";
    }
    @GetMapping("/formForAddProduct")
    public String addProduct(Model model){
        var product = new Product();
        model.addAttribute("product" , product);
        return "addProduct";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product)
    {
        productService.savedProduct(product);
        return "redirect:all";
    }
    @GetMapping("/formForUpdate")
    public String updateProduct(@RequestParam("ProductId") Long id ,
                                Model model){
        var product = productService.getProduct(id);
        model.addAttribute("product" , product);
        return "addProduct";

    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("ProductId") Long id){
        productService.deleteProduct(id);
       return  "redirect:all";
    }
}
