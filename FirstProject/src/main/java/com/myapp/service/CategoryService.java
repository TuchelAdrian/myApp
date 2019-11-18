package com.myapp.service;

import com.myapp.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category entity);

    void update(Category entity);

    Category findById(Integer id);

    void delete(Category entity);

    List<Category> findAll();

    void deleteAll();
}
