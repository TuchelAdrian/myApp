package com.myapp.dao;

import com.myapp.entity.Role;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDaoImpl implements RoleDao<Role, Integer> {
    private final static Logger LOG= Logger.getLogger(RoleDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public RoleDaoImpl(){
        //Constructor
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }


    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void save(Role entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din RoleDaoImpl");
    }

    @Override
    public void update(Role entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din RoleDaoImpl");
    }

    @Override
    public Role findById(Integer id) {
        LOG.info("S-a apelat metoda findById din RoleDaoImpl");
        return getCurrentSession().get(Role.class, id);
    }

    @Override
    public void delete(Role entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din RoleDaoImpl");
    }

    @Override
    public List<Role> findAll() {
        LOG.info("S-a apelat metoda findAll din RoleDaoImpl");
        return (List<Role>)getCurrentSession().createQuery("FROM Role").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din RoleDaoImpl");
        getCurrentSession().createQuery("DELETE FROM Role").executeUpdate();
    }
}
