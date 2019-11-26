package com.myapp.service;

import com.myapp.entity.Order;
import com.myapp.repository.impl.OrderRepositoryImpl;

import java.util.List;

public class OrderService {
    private OrderRepositoryImpl orderRepository;

    public OrderService(){ orderRepository = new OrderRepositoryImpl();}

    public void persist(Order entity){
        orderRepository.persist(entity);
    }

    public void update(Order entity){
        orderRepository.update(entity);
    }

    public Order findById(int id){
        return orderRepository.findById(id);
    }

    public void delete(Order entity){
        orderRepository.delete(entity);
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public void deleteAll(){
        orderRepository.deleteAll();
    }

    public void close(){
        orderRepository.close();
    }
}
