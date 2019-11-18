package com.myapp.dao;

import com.myapp.entity.User;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao<User, Integer> {
    private final static Logger LOG= Logger.getLogger(UserDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public UserDaoImpl(){
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
    public void save(User entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din UserDaoImpl");
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din UserDaoImpl");
    }

    @Override
    public User findById(Integer id) {
        LOG.info("S-a apelat metoda findById din UserDaoImpl");
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public void delete(User entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din UserDaoImpl");
    }

    @Override
    public List<User> findAll() {
        LOG.info("S-a apelat metoda findAll din UserDaoImpl");
        return (List<User>)getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din UserDaoImpl");
        getCurrentSession().createQuery("DELETE FROM User").executeUpdate();
    }
}
