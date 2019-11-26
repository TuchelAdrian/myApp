package com.myapp.repository.impl;

import com.myapp.entity.User;
import com.myapp.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private EntityManager em;
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");

    public UserRepositoryImpl(){this.em=this.emf.createEntityManager();}

    @Override
    public void persist(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(User entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(User entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<User> findAll() {
        List<User> users = em.createQuery("FROM User", User.class).getResultList();
        return users;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM User").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }

}
