package com.example.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class projectController {

    @GetMapping("/test")
    public String testController(){
        return "test Page";
    }
}