package com.example.phonebookmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_book")
public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "phone_number", nullable = false)
    private String phone_number;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "note",nullable = true)
    private String note;

    public PhoneBook(){
    }

    public PhoneBook(String phone_number, String name, String address, String note) {
        this.phone_number = phone_number;
        this.name = name;
        this.address = address;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
