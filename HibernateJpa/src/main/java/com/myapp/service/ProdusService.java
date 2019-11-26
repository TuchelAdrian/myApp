package com.myapp.service;

import com.myapp.entity.Produs;
import com.myapp.repository.impl.ProdusRepositoryImpl;

import javax.validation.Valid;
import java.util.List;

public class ProdusService {
    private ProdusRepositoryImpl produsRepository;

    public ProdusService(){ produsRepository = new ProdusRepositoryImpl();}

    public void persist(@Valid Produs entity){
        produsRepository.persist(entity);
    }

    public void update(@Valid Produs entity){
        produsRepository.update(entity);
    }

    public Produs findById(int id){
        return produsRepository.findById(id);
    }

    public void delete(Produs entity){
        produsRepository.delete(entity);
    }
    public List<Produs> findAll(){
        return produsRepository.findAll();
    }

    public void deleteAll(){
        produsRepository.deleteAll();
    }

    public void close(){
        produsRepository.close();
    }
}
