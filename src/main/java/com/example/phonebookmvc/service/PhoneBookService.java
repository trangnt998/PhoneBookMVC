package com.example.phonebookmvc.service;

import com.example.phonebookmvc.model.PhoneBook;

import java.util.List;

public interface PhoneBookService {
    Iterable<PhoneBook> findAll();
    List<PhoneBook> search(String name, String address);
    PhoneBook findByID(int id);
    void save(PhoneBook phone);
    void delete (PhoneBook phone);
}
