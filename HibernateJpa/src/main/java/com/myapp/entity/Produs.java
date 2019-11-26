package com.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @NotNull(message="Name cannot be null")
    private String name;

    @Column
    @DecimalMin(value="5.00", message="Price should not be less than 1")
    private BigDecimal price;

    @Column
    @Size(min=2, max=200, message="Description must be beteween 2 and 200 characters")
    private String description;

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Category> categories= new HashSet<>();

    @ManyToMany
    private Set<Order> orders;

    public int getId() { return id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void addCategory(Category c) {
        this.categories.add(c);
    }
}