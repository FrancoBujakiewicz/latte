
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.MappedSuperclass;
 import jakarta.persistence.Column;

 // Class to inherit coincident fields between Role, Action and Product classes.

 @MappedSuperclass
 public class Describable

 {

    @Column(nullable = false, length = 50)
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
