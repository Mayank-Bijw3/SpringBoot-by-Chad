package com.example.SpringBootWeb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testRestController {

@GetMapping("/hello")
    public String hola(){
    return "Hello World";
}
}
