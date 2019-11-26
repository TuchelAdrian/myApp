package com.myapp.repository;


import com.myapp.entity.User;

import java.util.List;

public interface UserRepository {
    void persist(User entity);

    void update(User entity);

    User findById(int id);

    void delete(User entity);

    List<User> findAll();

    void deleteAll();
}
