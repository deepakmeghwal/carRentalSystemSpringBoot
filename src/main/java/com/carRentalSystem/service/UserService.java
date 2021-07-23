package com.carRentalSystem.service;


import com.carRentalSystem.entity.User;
import com.carRentalSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return  userRepository.save(user);
    }

    public User getUser(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

    public User updateUser(User user){
        User exitUser = userRepository.findById(user.getId()).orElse(null);
        if(exitUser != null){
            return userRepository.save(user);
        }
        return null;
    }
}
