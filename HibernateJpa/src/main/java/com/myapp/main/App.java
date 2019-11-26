package com.myapp.main;

import com.myapp.entity.Produs;
import com.myapp.service.ProdusService;

import java.math.BigDecimal;

public class App {

    public static Produs addProdus(ProdusService service, String name, BigDecimal price, String description){
        Produs p=new Produs();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        service.persist(p);
        return p;
    }

    public static void main(String[] args) {
        ProdusService produsService = new ProdusService();
        try {
            Produs produs = addProdus(produsService, "Earth", BigDecimal.valueOf(0.0), "d");
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
