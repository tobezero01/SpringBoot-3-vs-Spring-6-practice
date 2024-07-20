package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getALls() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {

        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee is not found");
        }
        return employee;
    }

    // add mapping for Post/emp - add new emp
    @PostMapping("/employees")
    public Employee addNewEmp(@RequestBody Employee employee) {
        employee.setId(0);

        Employee employee1 = employeeService.save(employee);

        return employee1;
    }

    // update emp
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee) ;

        return employee1;
    }

    @DeleteMapping("/employees/{id}")
    public List<Employee> delete(@PathVariable int id) {

        Employee employee = employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("Employee is not found");
        }
        employeeService.delete(id);
        return getALls();
    }
}
