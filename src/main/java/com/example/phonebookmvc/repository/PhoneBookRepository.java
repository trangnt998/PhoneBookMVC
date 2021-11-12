package com.example.phonebookmvc.repository;

import com.example.phonebookmvc.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {
    List<PhoneBook> findAllByNameContaining(String q);
}
