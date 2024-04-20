package com.utcn.demo.service;

import com.utcn.demo.entity.Order;
import com.utcn.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> retrieveOrder(){
        return (List<Order>) this.orderRepository.findAll();
    }

    public Order insertOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public void deleteOrderById(int id) {
        if(this.orderRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.orderRepository.deleteById(id);
    }
}
