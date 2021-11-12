package com.example.phonebookmvc.service;

import com.example.phonebookmvc.model.PhoneBook;
import com.example.phonebookmvc.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookImpl implements PhoneBookService{
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public Iterable<PhoneBook> findAll() {
        return phoneBookRepository.findAll();
    }

    @Override
    public List<PhoneBook> search(String q){
        return phoneBookRepository.findAllByNameContaining(q);
    }

    @Override
    public PhoneBook findByID(int id) {
        return phoneBookRepository.findById(id).get();
    }

    @Override
    public void save(PhoneBook phone) {
        phoneBookRepository.save(phone);
    }

    @Override
    public void delete(PhoneBook phone) {
        phoneBookRepository.delete(phone);
    }
}
