package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = findInstructorById(id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    public void deleteDetailById(int id) {
        InstructorDetail instructorDetail = findDetailById(id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        // break bi-directional
        entityManager.remove(instructorDetail);
    }
}







