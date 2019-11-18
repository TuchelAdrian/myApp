package com.myapp.dao;

import com.myapp.entity.OrderO;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDaoImpl implements OrderDao<OrderO, Integer> {
    private final static Logger LOG = Logger.getLogger(OrderDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public OrderDaoImpl() {
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
    public void save(OrderO entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din OrderOODaoImpl");
    }

    @Override
    public void update(OrderO entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din OrderOODaoImpl");
    }

    @Override
    public OrderO findById(Integer id) {
        LOG.info("S-a apelat metoda findById din OrderOODaoImpl");
        return getCurrentSession().get(OrderO.class, id);
    }

    @Override
    public void delete(OrderO entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din OrderOODaoImpl");
    }

    @Override
    public List<OrderO> findAll() {
        LOG.info("S-a apelat metoda findAll din OrderOODaoImpl");
        return (List<OrderO>) getCurrentSession().createQuery("FROM OrderOO").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din OrderOODaoImpl");
        getCurrentSession().createQuery("DELETE FROM OrderOO").executeUpdate();
    }
}
