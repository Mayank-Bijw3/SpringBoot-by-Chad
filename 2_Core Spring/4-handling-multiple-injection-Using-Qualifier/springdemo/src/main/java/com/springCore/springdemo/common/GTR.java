package com.springCore.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class GTR implements Cars{
    @Override
    public String getCar(){
        return "Beat me if you can GTR'S Here";
    }
}
