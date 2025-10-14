package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
public class TempRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello ji!";
    }
}
