package com.utcn.demo.controller;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/getAllOrderProducts")
    public List<OrderProduct> retrieveAllOrderProducts(){
        return orderProductService.retrieveOrderProducts();
    }

    @PostMapping("/insertOrderProduct")
    public OrderProduct insertOrderProduct(@RequestBody OrderProduct orderProduct){
        return orderProductService.insertOrderProduct(orderProduct);
    }

    @DeleteMapping("/deleteOrderProductById")
    public void deleteOrderProductById(@RequestParam Long id){
        orderProductService.deleteOrderProductById(id);
    }

    @PostMapping("/createOrderProducts")
    public void createOrderProducts(@RequestBody Order order, @RequestBody Map<Product, Integer> productQuantities) {
        orderProductService.createOrderProducts(order, productQuantities);
    }

}
