package com.myapp.repository;


import com.myapp.entity.Produs;

import java.util.List;

public interface ProdusRepository {

    void persist(Produs entity);

    void update(Produs entity);

    Produs findById(int id);

    void delete(Produs entity);

    List<Produs> findAll();

    void deleteAll();
}
