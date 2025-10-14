package com.springCore.springdemo.components;

import org.springframework.stereotype.Component;

@Component
public class Dell implements Laptop{

    public String getLaptop(){
        return "its Dell";
    }
}
