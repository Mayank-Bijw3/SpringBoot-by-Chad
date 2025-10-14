package com.springCore.springdemo.components;


public class Apple implements Laptop{

    public Apple(){
        System.out.println("In Apple Xd");
    }

    @Override
    public String getLaptop(){
        return "Apple ka chodaaaaaaa XD";
    }
}
