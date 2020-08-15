package com.at2t.blip.controller;

import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.service.InstructorLoginService;
import com.at2t.blip.service.ParentLoginService;
import com.at2t.blip.util.BlipResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentLogin {

    @Autowired
    ParentLoginService parentLoginService;

    @RequestMapping(value = "/parent/login/{phoneNumber}", method = RequestMethod.GET)
    public BlipResponse getInstructors(@PathVariable String phoneNumber) {
        return parentLoginService.loginParent(phoneNumber);
    }
}
