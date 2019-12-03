package com.myapp.service;

import com.myapp.entity.Produs;
import com.myapp.repository.impl.ProdusRepositoryImpl;

import javax.validation.*;
import java.util.List;
import java.util.Set;

public class ProdusService {
    private ProdusRepositoryImpl produsRepository;

    public ProdusService(){ produsRepository = new ProdusRepositoryImpl();}

    public void persist(@Valid Produs entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Produs>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Produs> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            produsRepository.persist(entity);
        }
    }

    public void update(@Valid Produs entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Produs>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Produs> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            produsRepository.update(entity);
        }
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
