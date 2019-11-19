package com.at2t.blip.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodSecurity {

    @GetMapping("parent")
    @Secured("ROLE_USER")
    public String getUsername(){
        return "ddd";
    }
}
