package com.example.demo.entity;

import jakarta.persistence.*;

@Entity   // specifing that its an entity
@Table(name = "student")  //specifing table and its name
public class Student {

    //defining fields

    @Id  // it makrs our id as primary key @Id is for any which is primary key also for roll no.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this line gives the db access to create and manage id for each
    @Column(name="id")  //database colum name
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    //defining assigning constructors

    public Student(){

    }

    //constructor for setting values except PK
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    //defining getters/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //defining toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
