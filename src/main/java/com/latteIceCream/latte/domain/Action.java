
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;

 import jakarta.persistence.*;

 import java.util.Date;
 import java.util.List;

 @Entity
 public class Action extends Describable

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "actions")
    private List<Role> roles;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public Action() {}

    public Action(String name, String description, List<Role> roles)

    {

       super(name, description);
       this.roles = roles;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }
