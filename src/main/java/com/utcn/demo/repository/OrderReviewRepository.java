package com.utcn.demo.repository;

import com.utcn.demo.entity.OrderReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReviewRepository extends JpaRepository<OrderReview, Integer> {
}
