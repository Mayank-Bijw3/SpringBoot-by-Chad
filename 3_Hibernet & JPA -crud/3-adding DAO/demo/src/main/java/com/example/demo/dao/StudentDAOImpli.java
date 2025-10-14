package com.example.demo.dao;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpli implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpli(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement the save method

    @Transactional   //from spring it creates a transaction for us
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}











