package com.springCore.springdemo.rest;

import com.springCore.springdemo.components.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    Laptop l1;
    Laptop l2;
    Laptop l3;
    Laptop l4;

    @Autowired
    public void hereItIs(@Qualifier("dell") Laptop lap1, @Qualifier("dell") Laptop lap2){

        System.out.println("In Constructor " + getClass().getSimpleName());
        l1=lap1;
        l2=lap2;  // default scope is singalton i.e points to same object(bean)
    }

    @Autowired
    public void againHereItIs(@Qualifier("lenovo") Laptop lap3, @Qualifier("lenovo") Laptop lap4){  //check lenovo

        System.out.println("In Constructor " + getClass().getSimpleName());
        l3=lap3;
        l4=lap4;  // prototype scope creates object for each refrance for 1st for l3 and 2nd obj for l4


    }

    @GetMapping("/mylaptop")
    public String hello(){
        return "laptop1: "+l1.getLaptop() +"_______"+" laptop2: "+l2.getLaptop();
    }

    @GetMapping("/check")
    public String compare(){
        return "Comparing Beans: laptop1 == laptop2 :-" + (l1==l2);
        //if same beans return true i.e singalton
        //false if they are prototype its a type of scope as well
    }

    @GetMapping("/check2")
    public String compare2(){
        return "Again Comparing Beans: laptop3 == laptop4 :-" + (l3==l4);
    }
}
