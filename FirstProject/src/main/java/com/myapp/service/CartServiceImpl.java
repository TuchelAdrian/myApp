package com.myapp.service;

import com.myapp.dao.CartDaoImpl;
import com.myapp.entity.Cart;
import org.apache.log4j.Logger;

import java.util.List;

public class CartServiceImpl implements CartService{
    private final static Logger LOG= Logger.getLogger(CartServiceImpl.class.getName());

    private CartDaoImpl cartDao;

    public CartServiceImpl() {
        cartDao = new CartDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(Cart entity) {
        cartDao.openCurrentSessionwithTransaction();
        cartDao.save(entity);
        cartDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(Cart entity){
        cartDao.openCurrentSessionwithTransaction();
        cartDao.delete(entity);
        cartDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public Cart findById(Integer id){
        cartDao.openCurrentSession();
        Cart c = cartDao.findById(id);
        cartDao.closeCurrentSession();
        LOG.info("S-a gasit:" + c.toString());
        return c;
    }
    @Override
    public void update(Cart entity){
        cartDao.openCurrentSessionwithTransaction();
        cartDao.update(entity);
        cartDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<Cart> findAll(){
        List<Cart> carts;
        cartDao.openCurrentSession();
        carts=cartDao.findAll();
        cartDao.closeCurrentSession();
        LOG.info("S-au gasit:" + carts.toString());
        return carts;
    }
    @Override
    public void deleteAll(){
        cartDao.openCurrentSessionwithTransaction();
        cartDao.deleteAll();
        cartDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din CartService");
    }
}
