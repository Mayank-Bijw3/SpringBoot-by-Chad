package com.springCore.springdemo.components;

import org.springframework.stereotype.Component;

@Component
public class Dell implements Laptop{
    public Dell(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    @Override
    public String getLaptop(){
        return "its Dell";
    }
}
