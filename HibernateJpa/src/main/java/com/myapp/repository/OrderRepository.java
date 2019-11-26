package com.myapp.repository;


import com.myapp.entity.Order;

import java.util.List;

public interface OrderRepository {
    void persist(Order entity);

    void update(Order entity);

    Order findById(int id);

    void delete(Order entity);

    List<Order> findAll();

    void deleteAll();
}
