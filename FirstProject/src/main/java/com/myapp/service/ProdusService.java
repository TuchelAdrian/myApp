package com.myapp.service;

import com.myapp.dao.ProdusDaoImpl;
import com.myapp.entity.Produs;
import org.apache.log4j.Logger;

import java.util.List;


public class ProdusService {
    private final static Logger LOG= Logger.getLogger(ProdusService.class.getName());

    private ProdusDaoImpl produsDao;

    public ProdusService() {
        produsDao = new ProdusDaoImpl();
        LOG.info("S-a apelat constructorul");
    }

    public void save(Produs entity) {
        produsDao.openCurrentSessionwithTransaction();
        produsDao.save(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }

    public void delete(Produs entity){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.delete(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }

    public Produs findById(Integer id){
        Produs test;
        produsDao.openCurrentSession();
        Produs p = produsDao.findById(id);
        produsDao.closeCurrentSession();
        LOG.info("S-a gasit:" + p.toString());
        return p;
    }

    public void update(Produs entity){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.update(entity);
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }

    public List<Produs> findAll(){
        List<Produs> produse;
        produsDao.openCurrentSessionwithTransaction();
        produse=produsDao.findAll();
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-au gasit:" + produse.toString());
        return produse;
    }

    public void deleteAll(){
        produsDao.openCurrentSessionwithTransaction();
        produsDao.deleteAll();
        produsDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din ProdusService");
    }
}
