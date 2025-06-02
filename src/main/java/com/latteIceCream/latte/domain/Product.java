
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;
 import jakarta.persistence.*;

 import java.util.Date;

 @Entity
 public class Product

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 75, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 10)
    private String price;

    @ManyToOne
    private Label label;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public Product() {}

    public Product(String name, String description, String price)

    {

       this.name = name;
       this.description = description;
       this.price = price;
       this.created_at = new Date();

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPrice(){ return price; }
    public void setPrice(String price) { this.price = price; }

    public Label getLabel() { return label; }
    public void setLabel(Label label) { this.label = label; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }
