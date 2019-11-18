package com.myapp.service;

import com.myapp.entity.Cart;

import java.util.List;

public interface CartService {

    void save(Cart entity);

    void update(Cart entity);

    Cart findById(Integer id);

    void delete(Cart entity);

    List<Cart> findAll();

    void deleteAll();
}
