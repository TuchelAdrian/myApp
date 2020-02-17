package com.ecenta.controller;

import com.ecenta.data.UserData;
import com.ecenta.entity.UserEntity;
import com.ecenta.repository.UserRepository;
import com.ecenta.request.CreateUserRequest;
import com.ecenta.response.ApiGetAllUsersResponse;
import com.ecenta.response.ApiGetUser;
import com.ecenta.response.SimpleResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//@PreAuthorize("hasAnyRole('USER')")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/all")
    public String getAll() {
        ApiGetAllUsersResponse apiGetAllUsersResponse = new ApiGetAllUsersResponse();
        List<UserData> userDataList=new ArrayList<>();
        for (UserEntity user : userRepository.findAll()) {
            UserData userData=new UserData(user.getId(), user.getName(), user.getPassword(), user.getPhone(), user.getEmail(), user.getAddress());
            userDataList.add(userData);
        }
        apiGetAllUsersResponse.setCode("200");
        apiGetAllUsersResponse.setUsers(userDataList);
        apiGetAllUsersResponse.setMessage("Ok");
        Gson gson=new Gson();
        return gson.toJson(apiGetAllUsersResponse);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody UserEntity user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setName(user.getName());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
        Gson gson=new Gson();
        return gson.toJson(new SimpleResponse("200", "User update"));
    }
    @PatchMapping("/patch/{id}")
    public void updateP(@PathVariable int id, @RequestParam("name") String name){UserEntity userEntity = userRepository.findById(id).get();userEntity.setName(name); userRepository.save((userEntity));}
    @PostMapping("/add")
    public String create(@RequestBody CreateUserRequest createUserRequest){
        UserEntity userEntity = new UserEntity(createUserRequest.getName(), createUserRequest.getPassword(),
                createUserRequest.getEmail(), createUserRequest.getPhone(), createUserRequest.getAddress());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        Gson gson=new Gson();
        return gson.toJson(new SimpleResponse("200", "User created"));
    }
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        userRepository.deleteById(id);
        Gson gson=new Gson();
        return gson.toJson(new SimpleResponse("200", "User delete"));
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id){
        UserEntity userEntity=userRepository.findById(id).get();
        UserData createUserRequest = new UserData();
        createUserRequest.setId(userEntity.getId());
        createUserRequest.setName(userEntity.getName());
        createUserRequest.setPassword(userEntity.getPassword());
        createUserRequest.setEmail(userEntity.getEmail());
        createUserRequest.setPhone(userEntity.getPhone());
        createUserRequest.setAddress(userEntity.getAddress());
        Gson gson = new Gson();
        return gson.toJson(new ApiGetUser("200", "User returned", createUserRequest));
    }
}
