
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;

 import java.math.BigDecimal;

 @Entity
 public class Size extends DomainEntity

 {

    @Column(nullable = false, length = 10, unique = true)
    private String value;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price; // BigDecimal to JPA let set precision and scale

    @Column(nullable = false, columnDefinition = "BIT DEFAULT b'1'")
    private Boolean available;

    public Size() {}

    public Size(String value, BigDecimal price)

    {

       this.value = value;
       this.price = price;

    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

 }
