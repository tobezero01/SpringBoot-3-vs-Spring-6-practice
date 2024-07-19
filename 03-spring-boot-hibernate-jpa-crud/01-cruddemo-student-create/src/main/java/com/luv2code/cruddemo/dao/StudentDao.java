package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao  {

    void save(Student student) ;

    Student findbyId(Integer id);

    List<Student> finAllList();

    List<Student> findByLastName(String lastName);

    void update(Student student) ;

    void delete(Integer id);

    int deleteAll();
}
