package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/app")
public class ApplicationController {

    @GetMapping
    public String securedLogin(){
        return "Hello ! Jwt Secured ";
    }
}
