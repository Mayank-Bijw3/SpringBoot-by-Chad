package com.springCore.springdemo.config;

import com.springCore.springdemo.components.Apple;
import com.springCore.springdemo.components.Laptop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaptopConfig {

    @Bean("worst") //giving bean id or same name as provided in @qualifier
    public Laptop apple() { //Laptop is return type
        //method name must be same as mentioned in @Qualified
        return new Apple();
    }
}
