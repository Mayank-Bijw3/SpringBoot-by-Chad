package com.example.SpringBootWeb.rest;

import com.example.SpringBootWeb.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudnts(){

        //for now just hardcode list of students later we will fetch it from DB
        List<Student> sampleStudent = new ArrayList<>();

        sampleStudent.add(new Student("Mayank","Bijwe"));
        sampleStudent.add(new Student("Manik","Shaw"));
        sampleStudent.add(new Student("D.K.","Tripathi"));
        sampleStudent.add(new Student("spring work with jackson and in baground"," & convert the pojo to json and display on end point"));


        return sampleStudent;

        //spring work with jackson and in baground conver the pojo to json and display on end point
    }

}
