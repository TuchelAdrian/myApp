package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface CartDao<Cart, Id extends Serializable> {
    void save(Cart entity);

    void update(Cart entity);

    Cart findById(Id id);

    void delete(Cart entity);

    List<Cart> findAll();

    void deleteAll();
}
