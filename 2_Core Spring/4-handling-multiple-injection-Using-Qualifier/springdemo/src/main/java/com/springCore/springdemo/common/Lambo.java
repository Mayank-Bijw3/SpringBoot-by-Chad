package com.springCore.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class Lambo implements Cars{

    @Override
    public String getCar(){
        return "Sissor doors are opened, Here comes the lambooooo!";
    }
}
