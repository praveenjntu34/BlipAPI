package com.at2t.blip.controller;

import com.at2t.blip.dao.InstitutionAdmin;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.PersonType;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.InstitutionAdminService;
import com.at2t.blip.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Api(value = "blip")
public class PointOfContactController {
    @Autowired
    InstituitionService instituitionService;

    @Autowired
    InstitutionAdminService institutionAdminService;
    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.POST, value = "/institution/poc")
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

    @RequestMapping(method = RequestMethod.GET, value = "/institution/poc/{relTenantInstitutionId}")
    public PointOfContactResponseDto getInstitutions(@PathVariable int relTenantInstitutionId) {

        PointOfContactResponseDto poc = new PointOfContactResponseDto();
        InstitutionAdmin ia = institutionAdminService.getAdmin(relTenantInstitutionId).get();
        LoginCredential lc = instituitionService.getPersonDetails(ia.getPerson().getPersonId()).get();

        poc.setPrimaryPOCFirstName(ia.getPerson().getFirstName());
        poc.setPrimaryPOCLastName(ia.getPerson().getLastName());
        poc.setEmail(lc.getEmail());
        poc.setPrimaryPOCPhoneNumber(lc.getPhoneNumber());
        poc.setSecondaryPOCName(ia.getSecondaryPOCName());
        poc.setSecondaryPOCEmail(ia.getSecondaryPOCEmail());
        poc.setSecondaryPOCPhoneNumber(ia.getSecondaryPOCPhoneNumber());

        return poc;
    }

}
