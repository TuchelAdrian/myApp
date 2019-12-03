package com.myapp.service;

import com.myapp.entity.Role;
import com.myapp.repository.impl.RoleRepositoryImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class RoleService {
    private RoleRepositoryImpl roleRepository;

    public RoleService(){ roleRepository = new RoleRepositoryImpl();}

    public void persist(Role entity) {

        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Role>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Role> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            roleRepository.persist(entity);
        }
    }

    public void update(Role entity){
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Role>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Role> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            roleRepository.update(entity);
        }
    }

    public Role findById(int id){
        return roleRepository.findById(id);
    }

    public void delete(Role entity){
        roleRepository.delete(entity);
    }
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void deleteAll(){
        roleRepository.deleteAll();
    }

    public void close(){
        roleRepository.close();
    }
}
