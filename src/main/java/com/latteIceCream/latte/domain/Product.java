
 package com.latteIceCream.latte.domain;

 import com.latteIceCream.latte.domain.superclasses.Describable;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;
 import jakarta.persistence.ManyToOne;

 import java.math.BigDecimal;

 @Entity
 public class Product extends Describable

 {

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price; // BigDecimal to JPA let set precision and scale

    @ManyToOne
    private Brand brand;

    @Column(nullable = false, precision = 3)
    private Integer stock;

    public Product() {}

    public Product(String name, String description, BigDecimal price, Integer stock)

    {

       super(name, description);
       this.price = price;
       this.stock = stock;

    }

    public BigDecimal getPrice(){ return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Brand getLabel() { return brand; }
    public void setLabel(Brand brand) { this.brand = brand; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

 }
