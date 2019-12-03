package com.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotNull(message="Order's cantity can't be null")
    private int cantitate;

    @Column
    @Temporal(TemporalType.DATE)
    @NotNull(message="Date can't be null")
    private Date dateCreated;

    @Column
    @NotBlank(message = "Confirmation number can't be null")
    private String confirmationNumber;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "orders")
    private Set<Produs> produse;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Produs> getProduse() {
        return produse;
    }

    public void setProduse(Set<Produs> produse) {
        this.produse = produse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public int getCantitate() {
        return cantitate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
