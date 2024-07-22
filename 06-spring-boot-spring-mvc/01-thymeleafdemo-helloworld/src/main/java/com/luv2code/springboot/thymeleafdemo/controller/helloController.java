package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloWorld-form"; // return view
    }

    // need a method process form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld"; // return view
    }
}
