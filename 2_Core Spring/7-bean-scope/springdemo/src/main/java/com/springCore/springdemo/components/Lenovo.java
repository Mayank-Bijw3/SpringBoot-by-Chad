package com.springCore.springdemo.components;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // prototype returns new object for each injection
public class Lenovo implements Laptop{

    public Lenovo(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getLaptop(){
        return "its Lenovo";
    }
}
