package com.at2t.blip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dao.Institution;
import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.dao.Tenant;
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
	public String createRelTenantInstitution(@RequestBody RelTenantInstitution relTenantInstitution) {
		/*
		 * Institution instituition = new Institution();
		 * instituition.setInstitutionName("test"); instituition.setRemarks("Remarks");
		 * instituition.setStatus("s");
		 * 
		 * Tenant tenant=new Tenant(); tenant.setTenantName("Tenant test");
		 * RelTenantInstitution relTenantInstitution=new RelTenantInstitution();
		 * relTenantInstitution.setInstitution(instituition);
		 * relTenantInstitution.setTenant(tenant);
		 */
		relTenantInstitutionService.addInstituition(relTenantInstitution);
		return "RelTenantInstitution created";
	}

}
