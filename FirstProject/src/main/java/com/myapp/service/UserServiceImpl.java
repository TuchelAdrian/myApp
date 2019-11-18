package com.myapp.service;

import com.myapp.dao.UserDaoImpl;
import com.myapp.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final static Logger LOG= Logger.getLogger(UserServiceImpl.class.getName());

    private UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.save(entity);
        userDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(User entity){
        userDao.openCurrentSessionwithTransaction();
        userDao.delete(entity);
        userDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public User findById(Integer id){
        userDao.openCurrentSession();
        User u = userDao.findById(id);
        userDao.closeCurrentSession();
        LOG.info("S-a gasit:" + u.toString());
        return u;
    }
    @Override
    public void update(User entity){
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<User> findAll(){
        List<User> users;
        userDao.openCurrentSession();
        users=userDao.findAll();
        userDao.closeCurrentSession();
        LOG.info("S-au gasit:" + users.toString());
        return users;
    }
    @Override
    public void deleteAll(){
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din UserService");
    }
}
