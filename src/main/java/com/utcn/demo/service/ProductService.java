package com.utcn.demo.service;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveProducts() {
        return(List<Product>) this.productRepository.findAll();
    }

    public Product insertProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProductById(int id) {
        if(this.productRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.productRepository.deleteById(id);
    }

}
