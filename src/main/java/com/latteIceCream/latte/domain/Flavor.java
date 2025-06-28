
 package com.latteIceCream.latte.domain;

 import com.latteIceCream.latte.domain.superclass.Describable;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;

 @Entity
 public class Flavor extends Describable

 {

     @Column(nullable = false)
     private Boolean available;

     public Flavor() {}

     public Flavor(String name, String description, Boolean available)

     {

         super(name, description);
         this.available = available;

     }

     public Boolean getAvailable() { return available; }
     public void setAvailable(Boolean available) { this.available = available; }

 }

