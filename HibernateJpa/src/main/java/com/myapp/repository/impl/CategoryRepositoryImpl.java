package com.myapp.repository.impl;

import com.myapp.entity.Category;
import com.myapp.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private EntityManager em;
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");

    public CategoryRepositoryImpl(){this.em=this.emf.createEntityManager();}


    @Override
    public void persist(Category entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Category entity) {
        em.getTransaction();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Category findById(int id)
    {
        return em.find(Category.class, id);
    }

    @Override
    public void delete(Category entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = em.createQuery("FROM Category", Category.class).getResultList();
        return categories;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Category").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }
}
