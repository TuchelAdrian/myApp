package com.myapp.repository.impl;

import com.myapp.entity.Role;
import com.myapp.repository.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {

    private EntityManager em;
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");

    public RoleRepositoryImpl(){this.em=this.emf.createEntityManager();}

    @Override
    public void persist(Role entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Role entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public void delete(Role entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = em.createQuery("FROM Role", Role.class).getResultList();
        return roles;
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Role").executeUpdate();
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }

}
