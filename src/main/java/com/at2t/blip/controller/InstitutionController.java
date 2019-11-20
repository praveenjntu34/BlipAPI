package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.service.AddressService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
		instituitionService.addInstituition(institution);


		Tenant tenant = new Tenant(institutionDto.getInstitutionName());
		instituitionService.addTenant(tenant);

		Address address = addressService.setAddress(institutionDto.getAddress());

        Institution inst = instituitionService.findInstitution(institution.getInstitutionId()).get();
        Tenant t = instituitionService.findTenant(tenant.getTenantId()).get();
        Address addr = addressService.findAddress(address.getAddressId()).get();


		RelTenantInstitution relTenantInstitution = new RelTenantInstitution();
		relTenantInstitution.setInstitution(inst);
		relTenantInstitution.setTenant(t);
		relTenantInstitution.setAddress(addr);
		relTenantInstitution.setInstitutionTypeID(institutionDto.getInstitutionTypeId());

		relTenantInstitutionService.addInstituition(relTenantInstitution);
		return institution;
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
//		TypeMap<InstitutionDto, Institution> typeMap = modelMapper.createTypeMap(InstitutionDto.class, Institution.class);
//		typeMap.addMappings(mapper -> {
//			mapper.map(src -> src.getInstitutionName(),Institution::setInstitutionName);
//			mapper.map(src -> src.getEmail(), Institution::setEmail);
//			mapper.map(src -> src.getWebsite(), Institution::setWebsite);
//			mapper.map(src -> src.getAddress().getAddress1(), Institution::);
//		});
	}



}
