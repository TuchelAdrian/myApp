package com.ecenta.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class OrderEntity {


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
    private CartEntity cart;

    @ManyToOne
    private UserEntity user;

    @ManyToMany(mappedBy = "orders")
    private Set<ProdusEntity> produse;

    public void setId(int id) {
        this.id = id;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public Set<ProdusEntity> getProduse() {
        return produse;
    }

    public void setProduse(Set<ProdusEntity> produse) {
        this.produse = produse;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
