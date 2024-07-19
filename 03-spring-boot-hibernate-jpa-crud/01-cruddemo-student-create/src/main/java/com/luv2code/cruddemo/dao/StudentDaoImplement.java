package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImplement implements StudentDao{

    //define field for entity constructor injection
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findbyId(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> finAllList() {
        // create query get all
        TypedQuery<Student> query = entityManager.createQuery("From Student order by lastName", Student.class);

        // return query results

        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theData", Student.class);

        // set query
        query.setParameter("theData" , lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numsRowsDelete = entityManager.createQuery("Delete from Student").executeUpdate();
        return numsRowsDelete;
    }


}
