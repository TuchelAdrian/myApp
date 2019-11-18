package com.myapp.service;

import com.myapp.entity.OrderO;

import java.util.List;

public interface OrderService {

    void save(OrderO entity);

    void update(OrderO entity);

    OrderO findById(Integer id);

    void delete(OrderO entity);

    List<OrderO> findAll();

    void deleteAll();
}
