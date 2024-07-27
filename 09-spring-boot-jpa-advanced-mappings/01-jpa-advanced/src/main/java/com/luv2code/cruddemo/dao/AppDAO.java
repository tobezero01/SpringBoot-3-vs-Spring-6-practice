package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findDetailById(int id);

    void deleteDetailById(int id);
}
