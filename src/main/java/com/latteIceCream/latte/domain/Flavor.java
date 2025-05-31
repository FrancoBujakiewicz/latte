
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;
 import jakarta.persistence.*;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;

 @Entity
 public class Flavor

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String flavor;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "flavors")
    private Set<IceCream> ice_creams = new HashSet<>();

    public Flavor() {}

    public Flavor(String flavor, Date created_at, Date updated_at, Set<IceCream> ice_creams)

    {

       this.flavor = flavor;
       this.created_at = created_at;
       this.updated_at = updated_at;
       this.ice_creams = ice_creams;

     }

     public Long getId() { return id; }
     public void setId(Long id) { this.id = id; }

     public String getFlavor() { return flavor; }
     public void setFlavor(String flavor) { this.flavor = flavor; }

     public Date getCreated_at() { return created_at; }
     public void setCreated_at(Date created_at) { this.created_at = created_at; }

     public Date getUpdated_at() { return updated_at; }
     public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

     public Set<IceCream> getIce_creams() { return ice_creams; }
     public void setIce_creams(Set<IceCream> ice_creams) { this.ice_creams = ice_creams; }

 }

