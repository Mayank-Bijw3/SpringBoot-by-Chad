package com.springCore.springdemo.components;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Dell implements Laptop{
    public Dell(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    //defining initialization method for bean
    @PostConstruct
    public void creatingPhase(){
        System.out.println("In Creathing phase of " +getClass().getSimpleName());
    }


    //defining destroy method for bean
    @PreDestroy
    public void destroyingPhase(){
        System.out.println("In Destroying phase of " +getClass().getSimpleName());
    }


    @Override
    public String getLaptop(){
        return "its Dell";
    }
}
