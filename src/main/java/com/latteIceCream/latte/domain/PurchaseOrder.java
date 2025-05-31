
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import jakarta.persistence.*;
 import java.util.Date;

 public class PurchaseOrder

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column // Can be null if isn't home delivery
    private String address;

    @CreationTimestamp
    private Date created_at;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;

    public PurchaseOrder() {}

    public PurchaseOrder(String address, Date created_at,User user, Ticket ticket)

    {

       this.address = address;
       this.created_at = created_at;
       this.user = user;
       this.ticket = ticket;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Ticket getInvoice() { return ticket; }
    public void setInvoice(Ticket ticket) { this.ticket = ticket; }

 }
