package com.myapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy="categories")
    private Set<Produs> produse;

    public Set<Produs> getProduse() {
        return produse;
    }

    public void setProduse(Set<Produs> produse) {
        this.produse = produse;
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

}
