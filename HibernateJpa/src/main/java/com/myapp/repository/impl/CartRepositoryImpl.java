package com.myapp.repository.impl;

import com.myapp.entity.Cart;
import com.myapp.repository.CartRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CartRepositoryImpl implements CartRepository {

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

    public CartRepositoryImpl() {
        this.em = this.emf.createEntityManager();
    }

    @Override
    public void persist(Cart entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Cart entity) {
        em.getTransaction();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Cart findById(int id)
    {
        return em.find(Cart.class, id);
    }

    @Override
    public void delete(Cart entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> carts = em.createQuery("FROM Cart", Cart.class).getResultList();
        return carts;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Cart").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }
}
