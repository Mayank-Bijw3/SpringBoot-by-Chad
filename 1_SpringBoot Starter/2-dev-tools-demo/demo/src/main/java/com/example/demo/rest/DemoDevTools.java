package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoDevTools {
    @GetMapping("/")
    public String sayGreeting(){
        return "Hello";
    }

    @GetMapping("/first")
    public String sayfirst(){
        return "Mayank";
    }

    @GetMapping("/last")
    public String sayLast(){
        return "Bijwe";
    }


}
