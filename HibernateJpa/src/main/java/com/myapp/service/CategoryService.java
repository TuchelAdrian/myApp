package com.myapp.service;

import com.myapp.entity.Category;
import com.myapp.repository.impl.CategoryRepositoryImpl;

import javax.validation.*;
import java.util.List;
import java.util.Set;

public class CategoryService {
    private CategoryRepositoryImpl categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepositoryImpl();
    }

    public void persist(@Valid Category entity) {
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Category>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Category> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            categoryRepository.persist(entity);
        }
    }

    public void update(@Valid Category entity) {
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Category>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Category> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            categoryRepository.update(entity);
        }
    }

    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    public void close() {
        categoryRepository.close();
    }
}

