package com.utcn.demo.controller;

import com.utcn.demo.entity.Product;
import com.utcn.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> retrieveAllProducts(){
        return productService.retrieveProducts();
    }

    @PostMapping("/insertProduct")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @DeleteMapping("/deleteProductById")
    public void deleteProductById(@RequestParam Long id){
        productService.deleteProductById(id);
    }
}
