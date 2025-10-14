package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpli implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpli(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //creating Query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);

        //returning Query result
        return query.getResultList() ;
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //creating Query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        //SET Query parameter
        query.setParameter("theData",theLastName);
        //returning Query result
        return query.getResultList() ;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    //using Object
//    @Override
//    @Transactional
//    public void updateAll(Student theStudent) {
//       // entityManager.merge(theStudent);
//                //OR
//        String newLastName = theStudent.getLastName();
//
//        int updatedCount = entityManager.createQuery(
//                        "UPDATE Student s SET s.lastName = :newLastName")
//                .setParameter("newLastName", newLastName)
//                .executeUpdate();
//
//    }
            //using sting
    @Override
    @Transactional
    public void updateAll(String newLastName) {

        int updatedCount = entityManager.createQuery(
                        "UPDATE Student s SET s.lastName = :newLastName")
                .setParameter("newLastName", newLastName)
                .executeUpdate();

        System.out.println("Updated " + updatedCount + " students to last name: " + newLastName);
    }

    @Override
    @Transactional
    public void deleteOne( String lastName) {
        int noOfDelete = entityManager.createQuery("DELETE FROM Student WHERE lastName=:lastName")
                .setParameter("lastName" , lastName)
                .executeUpdate();

        System.out.println("No of Rows Affected : " + noOfDelete);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }
}
