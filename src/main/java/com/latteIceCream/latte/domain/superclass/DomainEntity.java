
 package com.latteIceCream.latte.domain.superclass;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;

 import jakarta.persistence.*;

 import java.util.Date;

 // Class to inherit the common fields between all domain classes

 @MappedSuperclass
 public class DomainEntity

 {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     protected Long id;

     @CreationTimestamp
     protected Date created_at;

     @UpdateTimestamp
     protected Date updated_at;

     public Long getId() { return id; }
     public void setId(Long id) { this.id = id; }

     public Date getCreated_at() { return created_at; }
     public void setCreated_at(Date created_at) { this.created_at = created_at; }

     public Date getUpdated_at() { return updated_at; }
     public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }
