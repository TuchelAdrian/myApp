package com.myapp.service;

import com.myapp.entity.User;
import com.myapp.repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserService {
    private UserRepositoryImpl userRepository;

    public UserService(){ userRepository = new UserRepositoryImpl();}

    public void persist(User entity){
        userRepository.persist(entity);
    }

    public void update(User entity){
        userRepository.update(entity);
    }

    public User findById(int id){
        return userRepository.findById(id);
    }

    public void delete(User entity){
        userRepository.delete(entity);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public void close(){
        userRepository.close();
    }
}
