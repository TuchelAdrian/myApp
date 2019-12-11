package com.ecenta.controller;

import com.ecenta.entity.OrderEntity;
import com.ecenta.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository or;
    @GetMapping("/all")
    public List<OrderEntity> getAll() { return or.findAll(); }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody OrderEntity orderEntity) {orderEntity.setId(id); or.save(orderEntity);}
    @PatchMapping("/patch/{id}")
    //public void updateP(@PathVariable int id, @RequestParam("name") String name){orderEntity orderEntity = tr.findById(id).get(); orderEntity.setName(name) ;tr.save((orderEntity));}
    @PostMapping("/add")
    public void create(@RequestBody OrderEntity orderEntity){ or.save(orderEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        or.deleteById(id);
    }
}
