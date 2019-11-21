package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.RelTenantInstitutionService;

import io.swagger.annotations.Api;

@RestController
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

	@GetMapping("/save")
	public String createInstituition() {
		Institution instituition = new Institution();
		instituition.setInstitutionName("test");
		instituition.setRemarks("Remarks");
		instituitionService.addInstituition(instituition);
		return "Hello User test";
	}

	@RequestMapping(value = "/institutions/details", method = RequestMethod.POST)
	public Institution addInstitution(@RequestBody InstitutionDto institutionDto) {

		Institution institution = convertToInstitutionEntity(institutionDto);
		Tenant tenant = new Tenant(institutionDto.getInstitutionName());

		instituitionService.addInstituition(institution);
		instituitionService.addTenant(tenant);
		Address address = addressService.setAddress(convertToAddressEntity(institutionDto));


		RelTenantInstitution relTenantInstitution = new RelTenantInstitution(institution,tenant,institutionDto.getInstitutionTypeId(),address);
        System.out.println(relTenantInstitution);
		relTenantInstitutionService.addInstituition(relTenantInstitution);
		return institution;
	}

	@RequestMapping(value = "institution/poc", method = RequestMethod.POST)
	public void addPOC(){

	}

	@RequestMapping(value = "/createRelTenantInstitution", method = RequestMethod.POST)
	public String createRelTenantInstitution(@RequestBody InstitutionData institutionData) {
//		RelTenantInstitution relTenantInstitutionObj = relTenantInstitutionService
//				.addInstituition(institutionData.getRelTenantInstitution());
//		System.out.println("RelTenantInstitutionId ID --- " + relTenantInstitutionObj.getRelTenantInstitutionId());
//		RelTenantInstitutionAddress relTenantInstitutionAddress = new RelTenantInstitutionAddress();
//		relTenantInstitutionAddress.setRelTenantInstitutionId(relTenantInstitutionObj.getRelTenantInstitutionId());
//		relTenantInstitutionAddress.setAddress(institutionData.getAddress());
//		relTenantInstitutionAddressService.addRelTenantInstitutionAddress(relTenantInstitutionAddress);
		return "RelTenantInstitution created";
	}

	@RequestMapping(value = "/updateRelTenantInstitution", method = RequestMethod.POST)
	public String updateRelTenantInstitution(@RequestBody InstitutionData institutionData) {
//		RelTenantInstitution relTenantInstitutionObj = relTenantInstitutionService
//				.addInstituition(institutionData.getRelTenantInstitution());
//		System.out.println("Update RelTenantInstitutionId ID --- " + relTenantInstitutionObj.getRelTenantInstitutionId());
//		RelTenantInstitutionAddress relTenantInstitutionAddress = new RelTenantInstitutionAddress();
//		relTenantInstitutionAddress.setRelTenantInstitutionId(relTenantInstitutionObj.getRelTenantInstitutionId());
//		relTenantInstitutionAddress.setAddress(institutionData.getAddress());
//		relTenantInstitutionAddressService.updateRelTenantInstitutionAddress(relTenantInstitutionAddress);
		return "RelTenantInstitution updated";
	}

	private Institution convertToInstitutionEntity(InstitutionDto institutionDto){

		Institution institution = modelMapper.map(institutionDto, Institution.class);
		institution.setInstitutionId(0);
		return institution;
	}
	private Address convertToAddressEntity(InstitutionDto institutionDto){

		Address address = institutionDto.getAddress();
		Address addr = new Address(address.getAddress1(),address.getAddress2(),address.getCityId(),address.getStateId(),address.getCountryId(),address.getPincode());
		return addr;
	}

}
