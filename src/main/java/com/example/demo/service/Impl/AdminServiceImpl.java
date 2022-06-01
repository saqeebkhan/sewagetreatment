package com.example.demo.service.Impl;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(String username, String password) {
        Admin admin= adminRepository.findByUsernameAndPassword(username,password);
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin, Long id) {
        Admin existAdmin = adminRepository.findById(id).orElseThrow(()->
                new RuntimeException("Admin not found with this id"+id)
                );
        existAdmin.setUsername(admin.getUsername());
        existAdmin.setPassword(admin.getPassword());
        adminRepository.save(existAdmin);
        return admin;
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
