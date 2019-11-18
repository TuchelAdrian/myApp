package com.myapp.dao;

import com.myapp.entity.Category;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao<Category, Integer> {

    private final static Logger LOG= Logger.getLogger(CategoryDaoImpl.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public CategoryDaoImpl(){
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
    public void save(Category entity) {
        getCurrentSession().save(entity);
        LOG.info("S-a apelat metoda save din CategoryDaoImpl");
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
        LOG.info("S-a apelat metoda update din CategoryDaoImpl");
    }

    @Override
    public Category findById(Integer id) {
        LOG.info("S-a apelat metoda findById din CategoryDaoImpl");
        return getCurrentSession().get(Category.class, id);
    }

    @Override
    public void delete(Category entity) {
        getCurrentSession().delete(entity);
        LOG.info("S-a apelat metoda delete din CategoryDaoImpl");
    }

    @Override
    public List<Category> findAll() {
        LOG.info("S-a apelat metoda findAll din CategoryDaoImpl");
        return (List<Category>)getCurrentSession().createQuery("FROM Category").list();
    }

    @Override
    public void deleteAll() {
        LOG.info("S-a apelat metoda deleteAll din CategoryDaoImpl");
        getCurrentSession().createQuery("DELETE FROM Category").executeUpdate();
    }
}
