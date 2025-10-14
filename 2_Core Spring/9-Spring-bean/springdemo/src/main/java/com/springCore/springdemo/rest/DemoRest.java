package com.springCore.springdemo.rest;

import com.springCore.springdemo.components.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    Laptop l1;


    @Autowired
    public void hereItIs(@Qualifier("worst") Laptop lap1) {

        System.out.println("In Constructor " + getClass().getSimpleName());
        l1 = lap1; // default scope is singalton i.e points to same object(bean)
    }


    @GetMapping("/mylaptop")
    public String hello() {
        return "laptop1: " + l1.getLaptop() ;
    }



}
