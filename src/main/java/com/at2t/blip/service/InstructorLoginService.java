package com.at2t.blip.service;

import com.at2t.blip.dto.InstructorDto;
import com.at2t.blip.dto.InstructorLoginResponse;
import com.at2t.blip.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InstructorLoginService {


    @Autowired
    InstructorRepository instructorRepository;
    @Transactional
    public Object loginInstructor(String phoneNumber) {

        InstructorLoginResponse response = instructorRepository.loginInstructor(phoneNumber);
        if(response != null) {
            return response;
        } else {
            Object object = new Object() {
                public String error = "Mobile number not registered";
            };
            return object;
        }
    }
}
