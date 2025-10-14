package com.springCore.springdemo.rest;

import com.springCore.springdemo.common.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    Cars bugatti;

    @Autowired
    public DemoController(Cars ready){
        bugatti=ready;
    }

    @GetMapping("/mycar")
    public String getCar(){
        return bugatti.getCar();
    }
}
