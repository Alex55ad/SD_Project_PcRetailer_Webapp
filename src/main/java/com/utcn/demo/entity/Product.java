package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="product")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList;

    @Column(name="price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "specifications")  // New column for specifications
    private String specifications;

    public Product() {
    }

    public Product(Long id, String name, double price, int stock, String specifications) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.specifications = specifications;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
