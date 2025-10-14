package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //can denote in class

    @Value("${programmer.name}")
    private String name;

    @Value("${propertieslocated.in}")
    private String location;

    //accessing usnig endpoints

    @GetMapping("/myinfo")
        public String information(){
        return "my Name : "+ name + " And Location: " + location;
    }

    @GetMapping("/")
    public String getHello(){

        return  "Hello";
    }
}
