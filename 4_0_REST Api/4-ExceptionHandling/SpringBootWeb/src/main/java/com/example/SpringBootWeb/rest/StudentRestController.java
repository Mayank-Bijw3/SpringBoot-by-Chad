package com.example.SpringBootWeb.rest;

import com.example.SpringBootWeb.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //Load students
    private List<Student> theStudent;
    @PostConstruct //execute only once after object is created
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Mayank","Bijwe"));
        theStudent.add(new Student("Manik","Shaw"));
        theStudent.add(new Student("D.K.","Tripathi"));
        theStudent.add(new Student("spring work with jackson and in baground"," & convert the pojo to json and display on end point"));
    }

    //define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudent;
    }

    //define endpoint for /students/{studentId} -> return student at index
    @GetMapping("/student/{studentId}") //{studentId} is the path variable
    public Student getStudent(@PathVariable int studentId){
        //both path variable and variable should be same name

        //exception logic
        if(studentId>=theStudent.size() || studentId<0){
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }

        //if not then simply as it is retun
        return theStudent.get(studentId);

    }

    //Add an exception handler using @ExceptionHandler
    //it act as Catch block
    @ExceptionHandler  //tells complier this method is an exception handler
    public ResponseEntity<StudentErrResponse> handleException(StudentNotFoundException exc){
                        //Generics                            //input type
        //1.create a studentErrResposne
            StudentErrResponse error = new StudentErrResponse();

            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(exc.getMessage());
            error.setTimestamp(System.currentTimeMillis());

        //2.return ResposnseEntity
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }

}
