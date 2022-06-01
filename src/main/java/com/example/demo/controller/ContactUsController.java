package com.example.demo.controller;

import com.example.demo.entity.ContactUs;
import com.example.demo.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "*")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/allContact")
    @CrossOrigin(origins = "http://localhost:3000/")
    public List<ContactUs> allContact(){
        return contactUsService.getAll();
    }

    @PostMapping("/addContact")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ContactUs addContact(@RequestBody ContactUs contactUs){
        return contactUsService.addContact(contactUs);
    }

}
