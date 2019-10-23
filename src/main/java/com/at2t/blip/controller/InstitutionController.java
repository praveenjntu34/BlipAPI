package com.at2t.blip.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/institution")
@Api(value = "blip")
public class InstitutionController {

    @GetMapping("/list")
    public String getAllInstitutions(){
        return "Returned response";
    }
}
