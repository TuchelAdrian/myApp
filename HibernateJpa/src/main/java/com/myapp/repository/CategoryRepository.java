package com.myapp.repository;


import com.myapp.entity.Category;

import java.util.List;

public interface CategoryRepository {

    void persist(Category entity);

    void update(Category entity);

    Category findById(int id);

    void delete(Category entity);

    List<Category> findAll();

    void deleteAll();
}
