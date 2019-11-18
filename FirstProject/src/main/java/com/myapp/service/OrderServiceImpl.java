package com.myapp.service;

import com.myapp.dao.OrderDaoImpl;
import com.myapp.entity.OrderO;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final static Logger LOG= Logger.getLogger(OrderServiceImpl.class.getName());

    private OrderDaoImpl OrderODao;

    public OrderServiceImpl() {
        OrderODao = new OrderDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(OrderO entity) {
        OrderODao.openCurrentSessionwithTransaction();
        OrderODao.save(entity);
        OrderODao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(OrderO entity){
        OrderODao.openCurrentSessionwithTransaction();
        OrderODao.delete(entity);
        OrderODao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public OrderO findById(Integer id){
        OrderODao.openCurrentSession();
        OrderO o = OrderODao.findById(id);
        OrderODao.closeCurrentSession();
        LOG.info("S-a gasit:" + o.toString());
        return o;
    }
    @Override
    public void update(OrderO entity){
        OrderODao.openCurrentSessionwithTransaction();
        OrderODao.update(entity);
        OrderODao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<OrderO> findAll(){
        List<OrderO> OrderOs;
        OrderODao.openCurrentSession();
        OrderOs=OrderODao.findAll();
        OrderODao.closeCurrentSession();
        LOG.info("S-au gasit:" + OrderOs.toString());
        return OrderOs;
    }
    @Override
    public void deleteAll(){
        OrderODao.openCurrentSessionwithTransaction();
        OrderODao.deleteAll();
        OrderODao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din OrderOService");
    }
}
