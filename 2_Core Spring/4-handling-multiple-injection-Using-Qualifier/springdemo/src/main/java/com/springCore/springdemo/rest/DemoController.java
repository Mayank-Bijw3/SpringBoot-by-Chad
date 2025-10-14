package com.springCore.springdemo.rest;

import com.springCore.springdemo.common.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    Cars myCarIs;

    @Autowired
    public DemoController(@Qualifier("pagani") Cars ready){ //this specifies recommended class to create object
                                //same name as class but 1st letter small
        myCarIs=ready;
    }


    @GetMapping("/mycar")
    public String getCar(){
        return myCarIs.getCar();
    }
}
