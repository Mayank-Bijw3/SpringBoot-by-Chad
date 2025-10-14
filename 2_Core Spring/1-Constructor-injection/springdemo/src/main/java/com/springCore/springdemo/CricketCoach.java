package com.springCore.springdemo;

import org.springframework.stereotype.Component;

//Bean is :A Spring Bean is an object that is instantiated,
// configured, and managed by the Spring Inversion of Control
// (IoC) container. These beans are the fundamental building blocks
// of a Spring application, representing the core components and services

@Component  //marks the class as a spring bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Practice fast boling for 30min daily";
    }
}
