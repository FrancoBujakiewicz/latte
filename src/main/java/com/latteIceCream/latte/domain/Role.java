
 package com.latteIceCream.latte.domain;

 import com.latteIceCream.latte.domain.superclasses.Describable;

 import jakarta.persistence.Entity;
 import jakarta.persistence.ManyToMany;
 import jakarta.persistence.JoinTable;
 import jakarta.persistence.JoinColumn;

 import java.util.List;

 @Entity
 public class Role extends Describable

 {

    @ManyToMany
    @JoinTable
    (

       name = "role_action",
       joinColumns = @JoinColumn(name = "role_id"),
       inverseJoinColumns = @JoinColumn(name = "action_id")

    )
    private List<Action> actions;

    public Role() {}

    public Role(String name, String description, List<Action> actions)

    {

       super(name, description);
       this.actions = actions;

    }

    public List<Action> getActions() { return actions; }
    public void setActions(List<Action> actions) { this.actions = actions; }

 }
