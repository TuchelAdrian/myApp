package com.myapp.service;

import com.myapp.dao.ProdusDaoImpl;
import com.myapp.entity.Produs;
import org.apache.log4j.Logger;

import java.util.List;


public class ProdusServiceImpl implements ProdusService {
    private final static Logger LOG= Logger.getLogger(ProdusServiceImpl.class.getName());

    private ProdusDaoImpl produsDao;

    public ProdusServiceImpl() {
        produsDao = new ProdusDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(Produs entity) {
        produsDao.openCurrentSessionwithTransaction();
        produsDao.save(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(Produs entity){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.delete(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public Produs findById(Integer id){
        produsDao.openCurrentSession();
        Produs p = produsDao.findById(id);
        produsDao.closeCurrentSession();
        LOG.info("S-a gasit:" + p.toString());
        return p;
    }
    @Override
    public void update(Produs entity){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.update(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<Produs> findAll(){
        List<Produs> produse;
        produsDao.openCurrentSession();
        produse=produsDao.findAll();
        produsDao.closeCurrentSession();
        LOG.info("S-au gasit:" + produse.toString());
        return produse;
    }
    @Override
    public void deleteAll(){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.deleteAll();
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din ProdusService");
    }
}
