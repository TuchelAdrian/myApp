package com.myapp;

import com.myapp.dao.ProdusDaoImpl;
import com.myapp.entity.Produs;
import com.myapp.service.ProdusService;
import org.apache.log4j.Logger;

import java.util.List;

public class App {
    private final static Logger LOG= Logger.getLogger(ProdusDaoImpl.class.getName());

    public static void main (String[] args){

        Produs produs=new Produs();
        Produs produs2=new Produs();
        Produs produs3=new Produs();
        ProdusService service=new ProdusService();

        produs.setName("Mars");
        produs.setMarime("3");
        produs.setMaterial("plastic");
        service.save(produs);

        produs2.setName("Moon");
        produs2.setMarime("2");
        produs2.setMaterial("bronze");
        service.save(produs2);

        produs3.setName("Earth");
        produs3.setMarime("4");
        produs3.setMaterial("silver");
        service.save(produs3);

        LOG.info(service.findById(3).getName());
        produs2.setMarime("5");
        service.update(produs2);
        List<Produs> produse=service.findAll();

        service.deleteAll();
        LOG.info(produse.size());

    }
}