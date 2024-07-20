package com.luv2code.demo.service;

import com.luv2code.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
