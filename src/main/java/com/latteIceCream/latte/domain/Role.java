
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;

 import jakarta.persistence.*;

 import java.util.Date;
 import java.util.List;

 @Entity
 public class Role extends Describable

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable
    (

       name = "role_action",
       joinColumns = @JoinColumn(name = "role_id"),
       inverseJoinColumns = @JoinColumn(name = "action_id")

    )
    private List<Action> actions;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public Role() {}

    public Role(String name, String description, List<Action> actions)

    {

       super(name, description);
       this.actions = actions;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<Action> getActions() { return actions; }
    public void setActions(List<Action> actions) { this.actions = actions; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

 }
