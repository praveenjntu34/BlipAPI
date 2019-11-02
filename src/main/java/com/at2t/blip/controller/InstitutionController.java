package com.at2t.blip.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@Api(value = "blip")
public class InstitutionController {

    @GetMapping("/")
    public String home(){
        return "Home screen";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }
    @GetMapping("/user")
    public String user(){
        return "Hello User";
    }

}
