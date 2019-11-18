package com.myapp.service;

import com.myapp.dao.RoleDaoImpl;
import com.myapp.entity.Role;
import org.apache.log4j.Logger;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final static Logger LOG= Logger.getLogger(RoleServiceImpl.class.getName());

    private RoleDaoImpl roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
        LOG.info("S-a apelat constructorul");
    }
    @Override
    public void save(Role entity) {
        roleDao.openCurrentSessionwithTransaction();
        roleDao.save(entity);
        roleDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat:"+ entity.toString());
    }
    @Override
    public void delete(Role entity){
        roleDao.openCurrentSessionwithTransaction();
        roleDao.delete(entity);
        roleDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters:"+ entity.toString());

    }
    @Override
    public Role findById(Integer id){
        roleDao.openCurrentSession();
        Role p = roleDao.findById(id);
        roleDao.closeCurrentSession();
        LOG.info("S-a gasit:" + p.toString());
        return p;
    }
    @Override
    public void update(Role entity){
        roleDao.openCurrentSessionwithTransaction();
        roleDao.update(entity);
        roleDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat:" + entity.toString());
    }
    @Override
    public List<Role> findAll(){
        List<Role> roles;
        roleDao.openCurrentSession();
        roles=roleDao.findAll();
        roleDao.closeCurrentSession();
        LOG.info("S-au gasit:" + roles.toString());
        return roles;
    }
    @Override
    public void deleteAll(){
        roleDao.openCurrentSessionwithTransaction();
        roleDao.deleteAll();
        roleDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a apelat metoda de deletaAll din RoleService");
    }
}
