package com.example.demo.service;

import com.example.demo.entity.ContactUs;

import java.util.List;

public interface ContactUsService {

    List<ContactUs> getAll();

    ContactUs addContact(ContactUs contactUs);
}
