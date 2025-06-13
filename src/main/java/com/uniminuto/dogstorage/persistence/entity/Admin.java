package com.uniminuto.dogstorage.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
 public class Admin {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer adminId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;
 }