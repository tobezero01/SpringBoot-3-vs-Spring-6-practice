package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/listStudents")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("NHU" , "DUC"));
        list.add(new Student("NHU DInh" , "DUC"));
        list.add(new Student("NHU DINH" , "TRI"));
        return list;
    }
}
