
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;

 @Entity
 public class Brand extends DomainEntity

 {

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    public Brand() {}

    public Brand(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

 }
