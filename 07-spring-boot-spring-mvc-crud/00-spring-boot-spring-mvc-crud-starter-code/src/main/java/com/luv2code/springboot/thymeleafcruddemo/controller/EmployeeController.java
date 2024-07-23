package com.luv2code.springboot.thymeleafcruddemo.controller;

import com.luv2code.springboot.thymeleafcruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafcruddemo.entity.Employee;
import com.luv2code.springboot.thymeleafcruddemo.service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for /list
    @GetMapping("/list")
    public String listEmp(Model model) {
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employee";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee" , employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/api/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId" ) int id , Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee" , employee);

        return "employees/employee-form";
    }
}
