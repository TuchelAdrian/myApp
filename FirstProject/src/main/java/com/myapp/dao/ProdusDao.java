package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface ProdusDao<T, Id extends Serializable> {

    void save(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
