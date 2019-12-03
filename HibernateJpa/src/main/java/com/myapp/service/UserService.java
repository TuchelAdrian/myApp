package com.myapp.service;

import com.myapp.entity.User;
import com.myapp.repository.impl.UserRepositoryImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class UserService {
    private UserRepositoryImpl userRepository;

    public UserService(){ userRepository = new UserRepositoryImpl();}

    public void persist(User entity){

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            userRepository.persist(entity);
        }
    }

    public void update(User entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            userRepository.update(entity);
        }
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
