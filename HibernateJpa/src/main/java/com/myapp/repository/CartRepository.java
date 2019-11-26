package com.myapp.repository;

import com.myapp.entity.Cart;

import java.util.List;

public interface CartRepository{

    void persist(Cart entity);

    void update(Cart entity);

    Cart findById(int id);

    void delete(Cart entity);

    List<Cart> findAll();

    void deleteAll();
}
