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

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = entityManager.merge(employee);

        return employee1;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
