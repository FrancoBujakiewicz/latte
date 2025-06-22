
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.Entity;
 import jakarta.persistence.ManyToMany;

 import java.util.List;

 @Entity
 public class Action extends Describable

 {

    @ManyToMany(mappedBy = "actions")
    private List<Role> roles;

    public Action() {}

    public Action(String name, String description, List<Role> roles)

    {

       super(name, description);
       this.roles = roles;

    }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

 }
