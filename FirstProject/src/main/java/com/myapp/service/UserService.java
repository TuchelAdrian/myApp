package com.myapp.service;

import com.myapp.entity.User;

import java.util.List;

public interface UserService {

    void save(User entity);

    void update(User entity);

    User findById(Integer id);

    void delete(User entity);

    List<User> findAll();

    void deleteAll();
}
