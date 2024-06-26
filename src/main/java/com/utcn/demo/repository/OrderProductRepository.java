package com.utcn.demo.repository;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    OrderProduct findByOrderAndProduct(Order order, Product product);
}
