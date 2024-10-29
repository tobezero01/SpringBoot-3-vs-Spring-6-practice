package com.luv2code.cruddemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("http://localhost:3000")
public class StudentAPIController {

    private static List<Student> listStudents = new ArrayList<>();
    private static Integer studentID = 0;

    static {
        listStudents.add(new Student(++studentID, "NHU DINH DUC", 3.8f));
        listStudents.add(new Student(++studentID, "NHU DINH TRI", 3.5f));
        listStudents.add(new Student(++studentID, "NHU DINH THE", 3.6f));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        if (listStudents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(listStudents, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        student.setId(++studentID);
        listStudents.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody Student student) {
        if (listStudents.contains(student) ) {
            int index = listStudents.indexOf(student);
            listStudents.set(index, student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}
