package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User existUser = userRepository.findById(id).orElseThrow(()->
                new RuntimeException("User Not Found With This Id"+id)
                );
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        existUser.setPhoneNumber(user.getPhoneNumber());
        existUser.setState(user.getState());
        existUser.setCity(user.getCity());
        existUser.setAddress(user.getAddress());
        existUser.setImage(user.getImage());
        existUser.setDescripton(user.getDescripton());
        userRepository.save(existUser);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
