package com.at2t.blip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dao.Address;
import com.at2t.blip.dao.Institution;
import com.at2t.blip.dao.InstitutionData;
import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.dao.RelTenantInstitutionAddress;
import com.at2t.blip.dao.Tenant;
import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.RelTenantInstitutionAddressService;
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
	RelTenantInstitutionAddressService relTenantInstitutionAddressService;

	@GetMapping("/admin")
	public String admin() {
		return "Hello Admin";
	}

	@GetMapping("/user")
	public String user() {
		return "Hello User";
	}

	@GetMapping("/test")
	public String userTest() {
		return "Hello User test";
	}

	@GetMapping("/save")
	public String createInstituition() {
		Institution instituition = new Institution();
		instituition.setInstitutionName("test");
		instituition.setRemarks("Remarks");

		instituitionService.addInstituition(instituition);
		return "Hello User test";
	}

	@RequestMapping(value = "/createRelTenantInstitution", method = RequestMethod.POST)
	public String createRelTenantInstitution(@RequestBody InstitutionData institutionData) {
		RelTenantInstitution relTenantInstitutionObj = relTenantInstitutionService
				.addInstituition(institutionData.getRelTenantInstitution());
		System.out.println("RelTenantInstitutionId ID --- " + relTenantInstitutionObj.getRelTenantInstitutionId());
		RelTenantInstitutionAddress relTenantInstitutionAddress = new RelTenantInstitutionAddress();
		relTenantInstitutionAddress.setRelTenantInstitutionId(relTenantInstitutionObj.getRelTenantInstitutionId());
		relTenantInstitutionAddress.setAddress(institutionData.getAddress());
		relTenantInstitutionAddressService.addRelTenantInstitutionAddress(relTenantInstitutionAddress);
		return "RelTenantInstitution created";
	}

	@RequestMapping(value = "/updateRelTenantInstitution", method = RequestMethod.POST)
	public String updateRelTenantInstitution(@RequestBody InstitutionData institutionData) {
		RelTenantInstitution relTenantInstitutionObj = relTenantInstitutionService
				.addInstituition(institutionData.getRelTenantInstitution());
		System.out.println("Update RelTenantInstitutionId ID --- " + relTenantInstitutionObj.getRelTenantInstitutionId());
		RelTenantInstitutionAddress relTenantInstitutionAddress = new RelTenantInstitutionAddress();
		relTenantInstitutionAddress.setRelTenantInstitutionId(relTenantInstitutionObj.getRelTenantInstitutionId());
		relTenantInstitutionAddress.setAddress(institutionData.getAddress());
		relTenantInstitutionAddressService.updateRelTenantInstitutionAddress(relTenantInstitutionAddress);
		return "RelTenantInstitution updated";
	}

}
