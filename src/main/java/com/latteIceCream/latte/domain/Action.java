
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;
 import jakarta.persistence.ManyToMany;

 import java.util.List;

 @Entity
 public class Action extends DomainEntity

 {

    @Column(nullable = false, length = 30)
    private String name;

    @ManyToMany(mappedBy = "actions")
    private List<Role> roles;

    public Action() {}

    public Action(String name, List<Role> roles)

    {

       this.name = name;
       this.roles = roles;

    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

 }
