package com.myapp.repository;


import com.myapp.entity.Role;

import java.util.List;

public interface RoleRepository {
    void persist(Role entity);

    void update(Role entity);

    Role findById(int id);

    void delete(Role entity);

    List<Role> findAll();

    void deleteAll();
}
