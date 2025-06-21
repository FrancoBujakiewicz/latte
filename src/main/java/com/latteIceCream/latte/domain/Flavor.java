
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;

 @Entity
 public class Flavor extends DomainEntity

 {

     @Column(nullable = false, length = 30, unique = true)
     private String name;

     @Column(nullable = false, columnDefinition = "BIT DEFAULT b'1'")
     private Boolean available;

     public Flavor() {}

     public Flavor(String name, Boolean available)

     {

         this.name = name;
         this.available = available;

     }

     public String getName() { return name; }
     public void setName(String name) { this.name = name; }

     public Boolean getAvailable() { return available; }
     public void setAvailable(Boolean available) { this.available = available; }

 }

