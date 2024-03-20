package com.utcn.demo.service;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.repository.OrderProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> retrieveOrderProducts() {
        return(List<OrderProduct>) this.orderProductRepository.findAll();
    }

    public OrderProduct insertOrderProduct(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    public void deleteOrderProductById(Long id) {
        if(this.orderProductRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.orderProductRepository.deleteById(id);
    }

    @Transactional
    public void createOrderProducts(Order order, Map<Product, Integer> productQuantities) {
        for (Map.Entry<Product, Integer> entry : productQuantities.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            // Check if an order product entry already exists for the given product and order
            OrderProduct existingOrderProduct = orderProductRepository.findByOrderAndProduct(order, product);
            if (existingOrderProduct != null) {
                // If an entry already exists, update the quantity
                existingOrderProduct.setQuantity(existingOrderProduct.getQuantity() + quantity);
                orderProductRepository.save(existingOrderProduct);
            } else {
                // If no entry exists, create a new one
                OrderProduct newOrderProduct = new OrderProduct();
                newOrderProduct.setOrder(order);
                newOrderProduct.setProduct(product);
                newOrderProduct.setQuantity(quantity);
                orderProductRepository.save(newOrderProduct);
            }
        }
    }

}
