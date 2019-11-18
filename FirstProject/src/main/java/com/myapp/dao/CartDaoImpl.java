package com.myapp.dao;

import com.myapp.entity.Cart;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CartDaoImpl implements CartDao<Cart, Integer> {

    private final static Logger LOG= Logger.getLogger(CartDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public CartDaoImpl(){
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
    public void save(Cart entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din CartDaoImpl");
    }

    @Override
    public void update(Cart entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din CartDaoImpl");
    }

    @Override
    public Cart findById(Integer id) {
        LOG.info("S-a apelat metoda findById din CartDaoImpl");
        return getCurrentSession().get(Cart.class, id);
    }

    @Override
    public void delete(Cart entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din CartDaoImpl");
    }

    @Override
    public List<Cart> findAll() {
        LOG.info("S-a apelat metoda findAll din CartDaoImpl");
        return (List<Cart>)getCurrentSession().createQuery("FROM Cart").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din CartDaoImpl");
        getCurrentSession().createQuery("DELETE FROM Cart").executeUpdate();
    }
}
