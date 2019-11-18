package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface OrderDao<OrderO, Id extends Serializable> {
    void save(OrderO entity);

    void update(OrderO entity);

    OrderO findById(Id id);

    void delete(OrderO entity);

    List<OrderO> findAll();

    void deleteAll();
}
