package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudents;

    @PostConstruct
    public void loadData() {
        listStudents = new ArrayList<>();
        listStudents.add(new Student("NHU" , "DUC"));
        listStudents.add(new Student("NHU DInh" , "DUC"));
        listStudents.add(new Student("NHU DINH" , "TRI"));
    }

    @GetMapping("/listStudents")
    public List<Student> getStudents() {
        return listStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= listStudents.size()) {
            throw new StudentNotFoundException("Student is not found - " + studentId);
        }
        return listStudents.get(studentId);
    }


    // Add an exception handler

}
