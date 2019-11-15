package com.myapp.dao;

import com.myapp.entity.Produs;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.util.List;

public class ProdusDaoImpl implements ProdusDao<Produs, Integer> {

    private final static Logger LOG= Logger.getLogger(ProdusDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public ProdusDaoImpl(){
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
    public void save(Produs entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din ProdusDaoImpl");
    }

    @Override
    public void update(Produs entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din ProdusDaoImpl");
    }

    @Override
    public Produs findById(Integer id) {
        LOG.info("S-a apelat metoda findById din ProdusDaoImpl");
        return getCurrentSession().get(Produs.class, id);
    }

    @Override
    public void delete(Produs entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din ProdusDaoImpl");
    }

    @Override
    public List<Produs> findAll() {
        LOG.info("S-a apelat metoda findAll din ProdusDaoImpl");
        return (List<Produs>)getCurrentSession().createQuery("FROM Produs").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din ProdusDaoImpl");
        getCurrentSession().createQuery("DELETE FROM Produs").executeUpdate();
    }
}
