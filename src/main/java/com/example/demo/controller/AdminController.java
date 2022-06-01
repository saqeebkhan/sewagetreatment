package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
private AdminService adminService;



    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin ){
       Admin oauthAdmin = adminService.login(admin.getUsername(), admin.getPassword());
       return "login sucessfully";
    }

    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin,@PathVariable Long id){
        return adminService.updateAdmin(admin,id);
    }

    @DeleteMapping("/deleteAdmin")
    public String deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return "Admin Deleted";
    }
}
