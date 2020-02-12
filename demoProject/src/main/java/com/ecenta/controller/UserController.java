package com.ecenta.controller;

import com.ecenta.data.UserData;
import com.ecenta.entity.UserEntity;
import com.ecenta.repository.UserRepository;
import com.ecenta.response.ApiGetAllUsersResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//@PreAuthorize("hasAnyRole('USER')")
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository ur;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/all")
    public String getAll() {
        ApiGetAllUsersResponse apiGetAllUsersResponse = new ApiGetAllUsersResponse();
        List<UserData> userDataList=new ArrayList<>();
        for (UserEntity user : ur.findAll()) {
            UserData userData=new UserData(user.getId(), user.getName(), user.getPhone(), user.getEmail(), user.getAddress());
            userDataList.add(userData);
        }

        apiGetAllUsersResponse.setCode("200");
        apiGetAllUsersResponse.setUsers(userDataList);
        apiGetAllUsersResponse.setMessage("Ok");
        Gson gson=new Gson();
        return gson.toJson(apiGetAllUsersResponse);
    }
    @PutMapping("/put/{id}")
    public void update(@PathVariable int id, @RequestBody UserEntity userEntity) {userEntity.setId(id); ur.save(userEntity);}
    @PatchMapping("/patch/{id}")
    public void updateP(@PathVariable int id, @RequestParam("name") String name){UserEntity userEntity = ur.findById(id).get(); userEntity.setName(name) ;ur.save((userEntity));}
    @PostMapping("/add")
    public void create(@RequestBody UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        ur.save(userEntity);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable int id) {
        ur.deleteById(id);
    }
}
