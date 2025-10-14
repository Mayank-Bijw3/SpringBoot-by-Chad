package com.example.SpringBootWeb.rest;

public class StudentNotFoundException extends RuntimeException{

    //constructor of super class all 3
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
