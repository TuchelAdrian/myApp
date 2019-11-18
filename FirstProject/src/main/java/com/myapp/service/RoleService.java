package com.myapp.service;

import com.myapp.entity.Role;
import java.util.List;

public interface RoleService {

    void save(Role entity);

    void update(Role entity);

    Role findById(Integer id);

    void delete(Role entity);

    List<Role> findAll();

    void deleteAll();
}
