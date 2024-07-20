package com.ducnhu.demo.service;

import com.ducnhu.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
