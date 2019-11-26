package com.myapp.repository.impl;

import com.myapp.entity.Order;
import com.myapp.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private EntityManager em;
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");

    public OrderRepositoryImpl(){this.em=this.emf.createEntityManager();}

    @Override
    public void persist(Order entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Order entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Order findById(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public void delete(Order entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = em.createQuery("FROM Order", Order.class).getResultList();
        return orders;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Order").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }


}
