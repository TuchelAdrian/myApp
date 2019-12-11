package com.ecenta.controller;

import com.ecenta.entity.TestEntity;
import com.ecenta.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepository tr;
    @GetMapping("/all")
    public List<TestEntity> getAll() {
        return tr.findAll();
    }
    @PutMapping("/put/{id}")
    public void update(@PathVariable Integer id, @RequestBody TestEntity testEntity) {testEntity.setId(id); tr.save(testEntity);}
    @PatchMapping("/patch/{id}")
    public void updateP(@PathVariable Integer id, @RequestParam("nume") String nume ){TestEntity testEntity = tr.findById(id).get(); testEntity.setNume(nume) ;tr.save((testEntity));}
    @PostMapping("/add")
    public void create(@RequestBody TestEntity testEntity){ tr.save(testEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id) {
        tr.deleteById(id);
        return new ResponseEntity<>(id.toString()+ " deleted", HttpStatus.OK);
    }
}
