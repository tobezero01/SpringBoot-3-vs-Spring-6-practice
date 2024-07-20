package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

    // that is it ... no need to code
}
