package com.myapp;

import com.myapp.dao.ProdusDaoImpl;
import com.myapp.entity.*;
import com.myapp.service.*;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    private final static Logger LOG= Logger.getLogger(ProdusDaoImpl.class.getName());

    public static void main (String[] args){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        Produs produs=new Produs();
        Produs produs2=new Produs();
        Produs produs3=new Produs();
        ProdusServiceImpl service=new ProdusServiceImpl();

        produs.setName("Mars");
        produs.setPrice("30");
        produs.setMaterial("plastic");
        service.save(produs);

        produs2.setName("Moon");
        produs2.setPrice("2");
        produs2.setMaterial("bronze");
        service.save(produs2);

        produs3.setName("Earth");
        produs3.setPrice("4");
        produs3.setMaterial("silver");
        service.save(produs3);

        LOG.info(service.findById(3).getName());
        produs2.setPrice("5");
        service.update(produs2);
        List<Produs> produse=service.findAll();

        //service.deleteAll();
        //LOG.info(produse.size());



        Cart cart=new Cart();
        Category category=new Category();
        OrderO order= new OrderO();
        Role role=new Role();
        User user=new User();

        CartServiceImpl cartService=new CartServiceImpl();
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        OrderServiceImpl orderService=new OrderServiceImpl();
        RoleServiceImpl roleService=new RoleServiceImpl();
        UserServiceImpl userService=new UserServiceImpl();

        cart.setCount(3);
        cart.setTotalAmount("200");

        category.setName("Televizoare");

        order.setCantitate(1);
        order.setConfirmationNumber("5432");
        order.setDateCreated(date);

        role.setName("user");

        user.setName("Mihai");
        user.setAddress("Str Anghel");
        user.setEmail("mihaita@yahoo.com");
        user.setPassword("carmen123");
        user.setPhone("0714523689");

        //cartService.save(cart);
        categoryService.save(category);
        orderService.save(order);
        roleService.save(role);

        user.setCart(cart);
        //cart.setUser(user);
        userService.save(user);
        LOG.info("AFISARE:" + cartService.findById(user.getCart().getId()).getUser().getName());
    }
}