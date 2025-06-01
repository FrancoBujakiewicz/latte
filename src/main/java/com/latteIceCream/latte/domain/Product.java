
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.*;

 @Entity
 public class Product

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    private Label label;

    public Product() {}

    public Product(Long id, String description, int price)

    {

       this.id = id;
       this.description = description;
       this.price = price;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPrice(){ return price; }
    public void setPrice(int price) { this.price = price; }

    public Label getLabel() { return label; }
    public void setLabel(Label label) { this.label = label; }

 }
