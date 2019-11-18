package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface UserDao<User, Id extends Serializable> {
    void save(User entity);

    void update(User entity);

    User findById(Id id);

    void delete(User entity);

    List<User> findAll();

    void deleteAll();
}
