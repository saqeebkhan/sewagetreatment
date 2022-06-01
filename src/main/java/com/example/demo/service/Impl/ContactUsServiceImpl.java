package com.example.demo.service.Impl;

import com.example.demo.entity.ContactUs;
import com.example.demo.repository.ContactUsRepository;
import com.example.demo.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public List<ContactUs> getAll() {
        return contactUsRepository.findAll();
    }

    @Override
    public ContactUs addContact(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }
}
