
 package com.latteIceCream.latte.domain;

 import jakarta.persistence.*;

 import java.util.List;

 @Entity
 public class Role extends DomainEntity

 {

    @Column(nullable = false, length = 30)
    private String name;

    @ManyToMany
    @JoinTable
    (

       name = "role_action",
       joinColumns = @JoinColumn(name = "role_id"),
       inverseJoinColumns = @JoinColumn(name = "action_id")

    )
    private List<Action> actions;

    public Role() {}

    public Role(String name, List<Action> actions)

    {

       this.name = name;
       this.actions = actions;

    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Action> getActions() { return actions; }
    public void setActions(List<Action> actions) { this.actions = actions; }

 }
