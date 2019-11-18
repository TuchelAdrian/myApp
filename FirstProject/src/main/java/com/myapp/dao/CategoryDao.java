package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface CategoryDao<Category, Id extends Serializable> {
    void save(Category entity);

    void update(Category entity);

    Category findById(Id id);

    void delete(Category entity);

    List<Category> findAll();

    void deleteAll();
}
