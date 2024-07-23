package com.springdemo.mvc.validationDemo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer );

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }
}