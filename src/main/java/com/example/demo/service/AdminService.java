package com.example.demo.service;

import com.example.demo.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmin();
    Admin addAdmin(Admin admin);

    Admin updateAdmin(Admin admin,Long id);

    void deleteAdmin(Long id);
    public Admin login(String username,String password);
}
