package com.ecenta.controller;

import com.ecenta.entity.CartEntity;
import com.ecenta.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cr;
    @GetMapping("/all")
    public List<CartEntity> getAll() {
        return cr.findAll();
    }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody CartEntity cartEntity) {cartEntity.setId(id); cr.save(cartEntity);}
    @PatchMapping("/patch/{id}")
    //public void updateP(@PathVariable int id, @RequestParam("name") String name){CartEntity cartEntity = tr.findById(id).get(); cartEntity.setName(name) ;tr.save((cartEntity));}
    @PostMapping("/add")
    public void create(@RequestBody CartEntity cartEntity){ cr.save(cartEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        cr.deleteById(id);
    }
}
