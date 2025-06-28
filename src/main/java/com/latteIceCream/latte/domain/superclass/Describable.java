
 package com.latteIceCream.latte.domain.superclass;

 import jakarta.persistence.Column;
 import jakarta.persistence.MappedSuperclass;

 @MappedSuperclass
 public class Describable extends DomainEntity

 {

     @Column(nullable = false, length = 75, unique = true)
     protected String name;

     @Column(nullable = false)
     protected String description;

     public Describable() {}

     public Describable(String name, String description)

     {

         this.name = name;
         this.description = description;

     }

     public String getName() { return name; }
     public void setName(String name) { this.name = name; }

     public String getDescription() { return description; }
     public void setDescription(String description) { this.description = description; }

 }
