package com.springCore.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class Pagani implements Cars{

    @Override
    public String getCar(){
        return "Paganis Here";
    }

}
