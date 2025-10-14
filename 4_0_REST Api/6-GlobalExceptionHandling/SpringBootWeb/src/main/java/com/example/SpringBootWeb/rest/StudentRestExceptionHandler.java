package com.example.SpringBootWeb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // it marks class as global exception handler for ALL REST CONTROLLERS IN PROJECT NOT ONLY 1
public class StudentRestExceptionHandler {

    //add exception handling code
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

    //Adding another excepton handler
    @ExceptionHandler
    public ResponseEntity<StudentErrResponse> allException(Exception exception){

        //1.create a studentErrResposne
        StudentErrResponse error = new StudentErrResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Please enter Valid and Integer DATA");
        error.setTimestamp(System.currentTimeMillis());

        //2.return ResposnseEntity
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
}
