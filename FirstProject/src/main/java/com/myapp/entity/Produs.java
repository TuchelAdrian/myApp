package com.myapp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

    @Column
    private String price;

    @Column
    private String description;

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Category> categories= new HashSet<>();

    @ManyToMany
    private Set<OrderO> orders;

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<OrderO> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderO> orders) {
        this.orders = orders;
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
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setMaterial(String description) {
        this.description = description;
    }

    public void addCategory(Category c) {
        this.categories.add(c);
    }
}