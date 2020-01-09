package com.at2t.blip.controller;

import com.at2t.blip.dao.InstitutionAdmin;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.PersonType;
import com.at2t.blip.dto.InstitutionAdminDto;
import com.at2t.blip.dto.LoginCredentialDto;
import com.at2t.blip.dto.PersonDto;
import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/institution/poc")
@Api(value = "blip")
public class PointOfContactController {
    @Autowired
    InstituitionService instituitionService;

    @Autowired
    PersonService personService;

    @PostMapping
    public Object addPOCDetails(@RequestBody InstitutionAdminDto institutionAdminDto) {

        PersonDto personDto = institutionAdminDto.getPersonDto();
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setGender(personDto.getGender());
        person.setPersonTypeId(institutionAdminDto.getPersonDto().getPersonTypeId());

        Person personObj = instituitionService.addPerson(person);
        LoginCredentialDto loginCredentialDto = new LoginCredentialDto();

        loginCredentialDto.setPersonId(personObj.getPersonId());
        instituitionService.addLoginCredential(loginCredentialDto);

        institutionAdminDto.setPersonId(personObj.getPersonId());
         instituitionService.addPOCDetail(institutionAdminDto);

        Object object = new Object() {
            public String response = "Added POC succesfully\"";
        };
        return object;

    }

}
