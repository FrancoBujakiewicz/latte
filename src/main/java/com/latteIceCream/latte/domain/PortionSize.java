
 package com.latteIceCream.latte.domain;

 import com.latteIceCream.latte.domain.superclass.Describable;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;

 import java.math.BigDecimal;

 @Entity
 public class PortionSize extends Describable

 {

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price; // BigDecimal to JPA let set precision and scale

    @Column(nullable = false)
    private Boolean available;

    public PortionSize() {}

    public PortionSize(String name, String description, BigDecimal price, Boolean available)

    {

       super(name, description);
       this.price = price;
       this.available = available;

    }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

 }
