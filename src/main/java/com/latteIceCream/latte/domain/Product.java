
 package com.latteIceCream.latte.domain;

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
    private Label label;

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

    public Label getLabel() { return label; }
    public void setLabel(Label label) { this.label = label; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

 }
