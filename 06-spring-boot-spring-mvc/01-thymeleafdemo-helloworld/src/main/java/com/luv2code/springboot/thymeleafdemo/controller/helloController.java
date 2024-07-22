package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    // need a controller method to read form data and
    // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request , Model model) {

        // read the request parameter from html
        String name = request.getParameter("studentName");

        //convert the data to all caps
        name = name.toUpperCase();

        // create message
        String res = "Hello " + name;

        model.addAttribute("message" , res);

        return "helloWorld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        //convert the data to all caps
        name = name.toUpperCase();

        // create message
        String res = "Hello My friend" + name;

        model.addAttribute("message" , res);

        return "helloWorld";
    }
}
