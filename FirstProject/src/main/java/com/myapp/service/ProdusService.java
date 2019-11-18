package com.myapp.service;

import com.myapp.entity.Produs;

import java.util.List;

public interface ProdusService {
    void save(Produs entity);

    void update(Produs entity);

    Produs findById(Integer id);

    void delete(Produs entity);

    List<Produs> findAll();

    void deleteAll();
}
