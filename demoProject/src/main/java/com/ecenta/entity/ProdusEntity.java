package com.ecenta.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProdusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @NotNull(message="Name cannot be null")
    private String name;

    @Column
    @DecimalMin(value="0.50", message="Price should not be less than 0.50")
    private Double price;

    @Column
    @Size(min=5, max=300, message="Description must be beteween 5 and 300 characters")
    private String description;

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<CategoryEntity> categories= new HashSet<>();

    @ManyToMany
    private Set<OrderEntity> orders;

    public int getId() { return id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void addCategory(CategoryEntity c) {
        this.categories.add(c);
    }
}