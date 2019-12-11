package com.ecenta.controller;

import com.ecenta.entity.CategoryEntity;
import com.ecenta.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository cr;
    @GetMapping("/all")
    public List<CategoryEntity> getAll() {
        return cr.findAll();
    }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryEntity categoryEntity) {categoryEntity.setId(id); cr.save(categoryEntity);}
    @PatchMapping("/patch/{id}")
    //public void updateP(@PathVariable int id, @RequestParam("name") String name){categoryEntity categoryEntity = tr.findById(id).get(); categoryEntity.setName(name) ;tr.save((categoryEntity));}
    @PostMapping("/add")
    public void create(@RequestBody CategoryEntity categoryEntity){ cr.save(categoryEntity);}
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        cr.deleteById(id);
    }
}
