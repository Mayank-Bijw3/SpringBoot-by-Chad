package com.springCore.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class Bugatti implements Cars {

    @Override
    public String getCar(){
        return  "Hers your Bugatti";
    }
}
