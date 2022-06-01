package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User addUser(User user);
    User updateUser(User user,Long id);
    void deleteUser(Long id);
}
