package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface ProdusDao<Produs, Id extends Serializable> {

    void save(Produs entity);

    void update(Produs entity);

    Produs findById(Id id);

    void delete(Produs entity);

    List<Produs> findAll();

    void deleteAll();
}
