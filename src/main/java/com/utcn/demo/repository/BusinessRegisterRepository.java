package com.utcn.demo.repository;

import com.utcn.demo.entity.BusinessRegister;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRegisterRepository extends JpaRepository<BusinessRegister, Integer> {
}
