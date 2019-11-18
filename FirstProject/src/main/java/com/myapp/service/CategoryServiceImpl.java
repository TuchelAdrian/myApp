package com.myapp.service;

import com.myapp.dao.CategoryDaoImpl;
import com.myapp.entity.Category;
import org.apache.log4j.Logger;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private final static Logger LOG= Logger.getLogger(CategoryServiceImpl.class.getName());

    private CategoryDaoImpl categoryDao;

    public CategoryServiceImpl() {
        categoryDao = new CategoryDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(Category entity) {
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.save(entity);
        categoryDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(Category entity){
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.delete(entity);
        categoryDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public Category findById(Integer id){
        categoryDao.openCurrentSession();
        Category c = categoryDao.findById(id);
        categoryDao.closeCurrentSession();
        LOG.info("S-a gasit:" + c.toString());
        return c;
    }
    @Override
    public void update(Category entity){
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.update(entity);
        categoryDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<Category> findAll(){
        List<Category> categories;
        categoryDao.openCurrentSession();
        categories=categoryDao.findAll();
        categoryDao.closeCurrentSession();
        LOG.info("S-au gasit:" + categories.toString());
        return categories;
    }
    @Override
    public void deleteAll(){
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.deleteAll();
        categoryDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din CategoryService");
    }
}
