package com.springCore.springdemo.components;

import org.springframework.stereotype.Component;

@Component
public class Asus implements Laptop {

    @Override
    public String getLaptop() {
        return "its Asus";
    }

}