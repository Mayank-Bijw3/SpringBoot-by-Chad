package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

public interface StudentDAO {
    void save(Student theStudent);
}
