package com.myapp.service;

import com.myapp.entity.Cart;
import com.myapp.repository.impl.CartRepositoryImpl;

import java.util.List;

public class CartService {
    private CartRepositoryImpl cartRepository;

    public CartService(){ cartRepository = new CartRepositoryImpl();}

    public void persist(Cart entity){
        cartRepository.persist(entity);
    }

    public void update(Cart entity){
        cartRepository.update(entity);
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
