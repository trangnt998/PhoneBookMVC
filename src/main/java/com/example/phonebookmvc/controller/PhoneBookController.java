package com.example.phonebookmvc.controller;

import com.example.phonebookmvc.model.PhoneBook;
import com.example.phonebookmvc.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhoneBookController {
    @Autowired
    private PhoneBookService phoneBookService;
    @GetMapping("/phone_book")
    public String index(Model model){
        model.addAttribute("phonebooks", phoneBookService.findAll());
        return "list";
    }

    @GetMapping("/phone_book/create")
    public String create(Model model){
        model.addAttribute("phonebook", new PhoneBook());
        return "form";
    }

    @GetMapping("/phone_book/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("phonebook", phoneBookService.findByID(id));
        return "form";
    }

    @PostMapping("/phone_book/save")
    public String save(@Validated PhoneBook phoneBook, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "form";
        }
        phoneBookService.save(phoneBook);
        redirect.addFlashAttribute("success","Save successfully!");
        return "redirect:/phone_book";
    }

    @GetMapping("/phone_book/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect){
        PhoneBook phone = phoneBookService.findByID(id);
        phoneBookService.delete(phone);
        redirect.addFlashAttribute("success","Deleted successfully!");
        return "redirect:/phone_book";
    }

    @GetMapping("/phone_book/search")
    public String search(@RequestParam("s") String s, Model model){
        if(s.equals("")){
            return "redirect:/phone_book";
        }
        model.addAttribute("phonebooks", phoneBookService.search(s));
        return "list";
    }
}
