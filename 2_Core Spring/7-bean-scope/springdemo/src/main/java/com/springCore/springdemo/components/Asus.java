package com.springCore.springdemo.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class Asus implements Laptop {

    public Asus(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    @Override
    public String getLaptop() {
        return "its Asus";
    }

}