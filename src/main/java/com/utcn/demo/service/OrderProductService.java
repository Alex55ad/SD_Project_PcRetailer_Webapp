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

    public void deleteOrderProductById(int id) {
        if(this.orderProductRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.orderProductRepository.deleteById(id);
    }

}
