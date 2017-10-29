package com.maresmewebdevelopers.helloworld.controllers;

import com.maresmewebdevelopers.helloworld.domain.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("contact", new Contact());

        return "hello";
    }

    @PostMapping("/hello")
    public String helloPost(@Valid Contact contact, Errors errors, Model model) {
        if (errors.hasErrors())
            return "hello";

        model.addAttribute("contact", new Contact());
        model.addAttribute("contactInfo", contact);
        return "hello";
    }
}
