package com.springCore.springdemo.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Hp implements Laptop{

    public Hp(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getLaptop(){
        return "its Hp";
    }
}
