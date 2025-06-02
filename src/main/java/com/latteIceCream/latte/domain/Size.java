
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;
 import jakarta.persistence.*;
 import java.util.Date;

 @Entity
 public class Size

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, unique = true, nullable = false)
    private String size;

    @Column(length = 10, nullable = false)
    private String price;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public Size() {}

    public Size(String size, String price)

    {

       this.size = size;
       this.price = price;
       this.created_at = new Date();

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }
