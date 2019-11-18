package com.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface RoleDao<Role, Id extends Serializable> {
    void save(Role entity);

    void update(Role entity);

    Role findById(Id id);

    void delete(Role entity);

    List<Role> findAll();

    void deleteAll();
}
