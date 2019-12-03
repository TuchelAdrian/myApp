package com.myapp.service;

import com.myapp.entity.Cart;
import com.myapp.repository.impl.CartRepositoryImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class CartService {
    private CartRepositoryImpl cartRepository;

    public CartService(){ cartRepository = new CartRepositoryImpl();}

    public void persist(Cart entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cart>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Cart> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            cartRepository.persist(entity);
        }
    }

    public void update(Cart entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cart>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Cart> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            cartRepository.update(entity);
        }
    }

    public Cart findById(int id){
        return cartRepository.findById(id);
    }

    public void delete(Cart entity){
        cartRepository.delete(entity);
    }
    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public void deleteAll(){
        cartRepository.deleteAll();
    }

    public void close(){
        cartRepository.close();
    }
}
