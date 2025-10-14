package com.springCore.springdemo.rest;

import com.springCore.springdemo.components.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    Laptop l1;

    @Autowired
    public void hereitis(Laptop lap){ // here is no @Qualifier still running coz primary goives preference to HP
        l1=lap;
    }

    @GetMapping("/mylaptop")
    public String hello(){
        return l1.getLaptop();
    }
}
