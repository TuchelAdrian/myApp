package com.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotBlank(message = "UserName can't be null")
    private String name;

    @Column
    @NotBlank(message = "Email can't be null")
    @Email(message= "This email address is not valid")
    private String email;

    @Column
    @Size(min=10, max=10, message = "Phone number must have 10 digits")
    private String phone;

    @Column
    @NotBlank(message = "The address can't be blank")
    private String address;

    @Column
    @NotNull(message = "The password can't be null")
    @Size(min=5, message="The password should have at least 5 characters")
    private String password;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private Set<Order> orders;

    @ManyToMany(mappedBy="users")
    private Set<Role> roles;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
