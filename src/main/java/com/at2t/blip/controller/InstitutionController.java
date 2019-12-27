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
@RequestMapping("/institution/details")
@Api(value = "blip")
public class InstitutionController {

	@Autowired
	InstituitionService instituitionService;

	@Autowired
	RelTenantInstitutionService relTenantInstitutionService;

	@Autowired
	AddressService addressService;

	@Autowired
	ModelMapper modelMapper;


	@PostMapping
	public Institution addInstitution(@RequestBody InstitutionDto institutionDto) {

		Institution institution = convertToInstitutionEntity(institutionDto);
		Tenant tenant = new Tenant(institutionDto.getInstitutionName());

		instituitionService.addInstituition(institution);
		instituitionService.addTenant(tenant);
		Address address = addressService.setAddress(convertToAddressEntity(institutionDto));

		RelTenantInstitution relTenantInstitution = new RelTenantInstitution(institution, tenant,
				institutionDto.getInstitutionTypeId(), address);
		System.out.println(relTenantInstitution);
		relTenantInstitutionService.addInstituition(relTenantInstitution);
		return institution;
	}

	@GetMapping
	public List<InstitutionResponse> getInstitutions() {
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
