package com.ecenta.controller;

import com.ecenta.entity.RoleEntity;
import com.ecenta.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository rr;
    @GetMapping("/all")
    public List<RoleEntity> getAll() { return rr.findAll(); }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody RoleEntity roleEntity) {roleEntity.setId(id); rr.save(roleEntity);}
    @PatchMapping("/patch/{id}")
    //public void updateP(@PathVariable int id, @RequestParam("name") String name){roleEntity roleEntity = tr.findById(id).get(); roleEntity.setName(name) ;tr.save((roleEntity));}
    @PostMapping("/add")
    public void create(@RequestBody RoleEntity roleEntity){ rr.save(roleEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        rr.deleteById(id);
    }
}

