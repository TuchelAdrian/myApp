package com.ecenta.controller;

import com.ecenta.entity.ProdusEntity;
import com.ecenta.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produs")
public class ProdusController {
    @Autowired
    private ProdusRepository pr;
    @GetMapping("/all")
    public List<ProdusEntity> getAll() { return pr.findAll(); }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody ProdusEntity produsEntity) {produsEntity.setId(id); pr.save(produsEntity);}
    @PatchMapping("/patch/{id}")
    //public void updateP(@PathVariable int id, @RequestParam("name") String name){produsEntity produsEntity = tr.findById(id).get(); produsEntity.setName(name) ;tr.save((produsEntity));}
    @PostMapping("/add")
    public void create(@RequestBody ProdusEntity produsEntity){ pr.save(produsEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        pr.deleteById(id);
    }
}
