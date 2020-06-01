package com.at2t.blip.controller;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dto.InstructorLoginResponse;
import com.at2t.blip.dto.InstructorResponseDto;
import com.at2t.blip.service.InstructorLoginService;
import com.at2t.blip.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController


public class InstructorLogin {

    @Autowired
    InstructorLoginService instructorLoginService;
    @RequestMapping(value = "/instructor/login/{phoneNumber}", method = RequestMethod.GET)
    public Object getInstructors(@PathVariable String phoneNumber) {
        return instructorLoginService.loginInstructor(phoneNumber);
    }
}
