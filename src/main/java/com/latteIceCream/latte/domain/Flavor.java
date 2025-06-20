
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;

 import jakarta.persistence.*;

 import java.util.Date;

 @Entity
 public class Flavor

 {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, length = 30, unique = true)
     private String name;

     @Column(nullable = false, columnDefinition = "BIT DEFAULT b'1'")
     private Boolean available;

     @CreationTimestamp
     private Date created_at;

     @UpdateTimestamp
     private Date updated_at;

     public Flavor() {}

     public Flavor(String name) { this.name = name; }

     public Long getId() { return id; }
     public void setId(Long id) { this.id = id; }

     public String getName() { return name; }
     public void setName(String name) { this.name = name; }

     public Boolean getAvailable() { return available; }
     public void setAvailable(Boolean available) { this.available = available; }

     public Date getCreated_at() { return created_at; }
     public void setCreated_at(Date created_at) { this.created_at = created_at; }

     public Date getUpdated_at() { return updated_at; }
     public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }

