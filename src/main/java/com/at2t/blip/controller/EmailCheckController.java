package com.at2t.blip.controller;

import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dto.AddressSetDto;
import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.service.InstitutionAdminService;
import com.at2t.blip.service.LoginCredentialService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/check-email")
@Api(value = "blip")
public class EmailCheckController {

    @Autowired
    LoginCredentialService loginCredentialService;


    @GetMapping
    public Object checkEmail(@RequestParam("data") String email) {

        LoginCredential loginCredential = loginCredentialService.checkEmail(email);
        if(loginCredential == null) {

            Object object = new Object() {
                public boolean emailExists = false;
            };

            return object;
        } else {
            Object object = new Object() {
                public boolean emailExists = true;
            };
            return object;
        }
    }
}
