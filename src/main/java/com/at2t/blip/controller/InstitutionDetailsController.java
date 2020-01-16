package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.*;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/institution/ins-details/{institutionId}")
@Api(value = "blip")
public class InstitutionDetailsController {

    @Autowired
    InstituitionService instituitionService;

    @Autowired
    InstitutionAdminService institutionAdminService;
    @Autowired
    RelTenantInstitutionService relTenantInstitutionService;

    @Autowired
    AddressService addressService;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    StateService stateService;


    @GetMapping
    public InstitutionResponseDto getInstitutionsDetails(@PathVariable int institutionId) {

        InstitutionResponseDto obj = instituitionService.getInstitutionDetails(institutionId);
        List<City> cities = stateService.getCity(obj.getCityId());
        obj.setCityName(cities.get(0).getCityName());
        obj.setStateName(cities.get(0).getState().getStateName());


        return obj;
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
