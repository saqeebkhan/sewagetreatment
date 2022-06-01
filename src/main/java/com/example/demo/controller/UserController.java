package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/deleteUser")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted";
    }

}
