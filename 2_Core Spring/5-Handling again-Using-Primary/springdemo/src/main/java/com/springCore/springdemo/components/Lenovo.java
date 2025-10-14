package com.springCore.springdemo.components;

import org.springframework.stereotype.Component;

@Component
public class Lenovo implements Laptop{
    @Override
    public String getLaptop(){
        return "its Lenovo";
    }
}
