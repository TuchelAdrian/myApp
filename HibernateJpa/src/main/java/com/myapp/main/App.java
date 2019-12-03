package com.myapp.main;

import com.myapp.entity.Produs;
import com.myapp.entity.User;
import com.myapp.service.ProdusService;
import com.myapp.service.UserService;

public class App {

    public static Produs addProdus(ProdusService service, String name, Double price, String description){
        Produs p=new Produs();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        service.persist(p);
        return p;
    }

    public static User addUser(UserService service, String name, String password, String address, String phone, String mail){
        User u=new User();
        u.setName(name);
        u.setPassword(password);
        u.setAddress(address);
        u.setPhone(phone);
        u.setEmail(mail);
        service.persist(u);
        return u;
    }

    public static void main(String[] args) {
        ProdusService produsService = new ProdusService();
        UserService userService=new UserService();
        try {
            Produs produs = addProdus(produsService, "Earth", 0.50, "ddsadas");
            User user=addUser(userService, "Motanu", "motanu123", "Str. Zapodie", "0714785236", "adi@ecenta.com");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (produsService != null)
                produsService.close();
        }



//            System.out.println(produsService.findById(1).getName());
//
//            for (Produs produs3 : produsService.findAll()) {
//                System.out.println(produs3.getName());
//            }
//
//            produsService.deleteAll();

    }
}
