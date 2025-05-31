
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;
 import jakarta.persistence.*;
 import java.util.Date;
 import java.util.Set;

 @Entity
 public class IceCream

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @ManyToOne
    @JoinColumn
    private PurchaseOrder order;

    @ManyToOne
    @JoinColumn
    private Size size;

    @ManyToMany
    @JoinTable
    (

      name = "FLAVOR_ICE_CREAM",
      joinColumns = @JoinColumn(name = "ICE_CREAM_ID"),
      inverseJoinColumns = @JoinColumn(name = "FLAVOR_ID")

    )
    private Set<Flavor> flavors;

    @Column
    private float total_price;

    public IceCream() {}

    public IceCream(Date created_at, PurchaseOrder order, Size size, Set<Flavor> flavors)

    {

       this.created_at = created_at;
       this.order = order;
       this.size = size;
       this.flavors = flavors;

    }

     public Long getId() { return id; }
     public void setId(Long id) { this.id = id; }

     public Date getCreated_at() { return created_at; }
     public void setCreated_at(Date created_at) { this.created_at = created_at; }

     public Date getUpdated_at() { return updated_at; }
     public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

     public PurchaseOrder getOrder() { return order; }
     public void setOrder(PurchaseOrder order) { this.order = order; }

     public Size getSize() { return size; }
     public void setSize(Size size) { this.size = size; }

     public float getTotal_price() { return total_price; }
     public void setTotal_price(float total_price) { this.total_price = total_price; }

     public Set<Flavor> getFlavors() { return flavors; }
     public void setFlavors(Set<Flavor> flavors) { this.flavors = flavors; }

 }

