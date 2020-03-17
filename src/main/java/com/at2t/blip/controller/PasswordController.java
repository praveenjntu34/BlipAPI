package com.at2t.blip.controller;

import com.at2t.blip.dto.AuthenticationRequest;
import com.at2t.blip.dto.PasswordDto;
import com.at2t.blip.service.LoginCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @Autowired
    LoginCredentialService loginCredentialService;

    @PostMapping("/change-password")
    public Object changePassword(@RequestBody PasswordDto passwordDto) {

        loginCredentialService.changePassword(passwordDto.getEmail(), passwordDto.getPassword());
        Object object = new Object() {
            public String response = "Password changed succesfully";
        };
        return object;
    }

    }
