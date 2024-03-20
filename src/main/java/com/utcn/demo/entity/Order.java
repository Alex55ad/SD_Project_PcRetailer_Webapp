package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="order")
public class Order {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProductList;

    @Column(name="date")
    private String date;

    @Column(name = "address")
    private int address;

    @Column(name = "contact")
    private String contact;

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public Order(Long id, User user, String date, int address, String contact) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.address = address;
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long oid) {
        this.id = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
