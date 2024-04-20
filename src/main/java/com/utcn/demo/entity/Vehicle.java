package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="Vehicles")
public class Vehicle {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String type;

    @Column(name= "last_maintenance")
    private LocalDateTime last_maintenance;

    @Column(name = "registration_number")
    private String registration;
}
