package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findDetailById(int id);

    void deleteDetailById(int id);

    List<Course> findCoursesByInstructorId(int id) ;

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor) ;

    void deleteCourseById(int id);
}
