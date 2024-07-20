package com.ducnhu.demo.dao;

import com.ducnhu.demo.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> listAll();
}
