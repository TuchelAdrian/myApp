package com.myapp.service;

import com.myapp.entity.Role;
import com.myapp.repository.impl.RoleRepositoryImpl;

import java.util.List;

public class RoleService {
    private RoleRepositoryImpl roleRepository;

    public RoleService(){ roleRepository = new RoleRepositoryImpl();}

    public void persist(Role entity){
        roleRepository.persist(entity);
    }

    public void update(Role entity){
        roleRepository.update(entity);
    }

    public Role findById(int id){
        return roleRepository.findById(id);
    }

    public void delete(Role entity){
        roleRepository.delete(entity);
    }
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void deleteAll(){
        roleRepository.deleteAll();
    }

    public void close(){
        roleRepository.close();
    }
}
