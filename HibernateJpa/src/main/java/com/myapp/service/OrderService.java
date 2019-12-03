package com.myapp.service;

import com.myapp.entity.Order;
import com.myapp.repository.impl.OrderRepositoryImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class OrderService {
    private OrderRepositoryImpl orderRepository;

    public OrderService() {
        orderRepository = new OrderRepositoryImpl();
    }

    public void persist(Order entity) {

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Order> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            orderRepository.persist(entity);
        }
    }

    public void update(Order entity) {
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Order> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            orderRepository.update(entity);
        }
    }

    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public void close() {
        orderRepository.close();
    }
}
