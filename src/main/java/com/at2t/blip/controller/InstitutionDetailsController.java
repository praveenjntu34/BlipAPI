package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.AddressService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.RelTenantInstitutionService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/institution/ins-details")
@Api(value = "blip")
public class InstitutionDetailsController {

    @Autowired
    InstituitionService instituitionService;

    @Autowired
    RelTenantInstitutionService relTenantInstitutionService;

    @Autowired
    AddressService addressService;

    @Autowired
    ModelMapper modelMapper;



    @GetMapping
    public List<InstitutionResponse> getInstitutionsDetails() {
        return instituitionService.getAlInstitutions();
    }

    private Institution convertToInstitutionEntity(InstitutionDto institutionDto) {

        Institution institution = modelMapper.map(institutionDto, Institution.class);
        institution.setInstitutionId(0);
        return institution;
    }

    private Address convertToAddressEntity(InstitutionDto institutionDto) {

        Address address = modelMapper.map(institutionDto, Address.class);
        return address;
    }



}
