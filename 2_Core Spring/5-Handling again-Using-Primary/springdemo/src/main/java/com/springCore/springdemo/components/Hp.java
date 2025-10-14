package com.springCore.springdemo.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Hp implements Laptop{
    @Override
    public String getLaptop(){
        return "its Hp";
    }
}
