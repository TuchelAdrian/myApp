package com.ecenta.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotNull(message="Category can't be null")
    private String name;

    @ManyToMany(mappedBy="categories")
    private Set<ProdusEntity> produse;

    public void setId(int id) {
        this.id = id;
    }

    public Set<ProdusEntity> getProduse() {
        return produse;
    }

    public void setProduse(Set<ProdusEntity> produse) {
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
