package com.example.SpringBootWeb.entity;

public class Student {

    private String firstName;
    private String laststName;

    //default constructor is required by some jackson
    public Student() {
    }

    public Student(String firstName, String laststName) {
        this.firstName = firstName;
        this.laststName = laststName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLaststName() {
        return laststName;
    }

    public void setLaststName(String laststName) {
        this.laststName = laststName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", laststName='" + laststName + '\'' +
                '}';
    }
}
