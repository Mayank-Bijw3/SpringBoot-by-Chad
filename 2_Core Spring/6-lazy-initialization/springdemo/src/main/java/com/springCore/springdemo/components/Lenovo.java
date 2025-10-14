package com.springCore.springdemo.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Lenovo implements Laptop{

    public Lenovo(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getLaptop(){
        return "its Lenovo";
    }
}
