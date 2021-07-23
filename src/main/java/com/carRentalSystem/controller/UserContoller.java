package com.carRentalSystem.controller;


import com.carRentalSystem.entity.User;
import com.carRentalSystem.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserContoller {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
//        System.out.println("user controller=>>>>>>>>>>>>>");
//        System.out.println(user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

}
