package com.myapp.repository.impl;

import com.myapp.entity.Produs;
import com.myapp.repository.ProdusRepository;

import javax.persistence.*;
import java.util.List;

public class ProdusRepositoryImpl implements ProdusRepository {

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

    public ProdusRepositoryImpl() {
        this.em = emf.createEntityManager();
    }

    @Override
    public void persist(Produs entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Produs entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Produs findById(int id) {
        return em.find(Produs.class, id);
    }

    @Override
    public void delete(Produs entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Produs> findAll() {
        List<Produs> produse = em.createQuery("FROM Produs", Produs.class).getResultList();
        return produse;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Produs").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }


}
