package com.ducnhu.demo.dao;

import com.ducnhu.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJPAImplement implements EmployeeRepository{

    private EntityManager entityManager;

    @Autowired
    public EmployeeJPAImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> listAll() {

        // query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee " , Employee.class);

        List<Employee> list= query.getResultList();
        return list;
    }
}
