package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.AddressService;

import java.util.List;
import java.util.stream.Collectors;

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
	public InstitutionDetailsResponse addInstitution(@RequestBody InstitutionDto institutionDto) {

		Institution institution = convertToInstitutionEntity(institutionDto);
		Tenant tenant = new Tenant(institutionDto.getInstitutionName());

		InstitutionDisplayPicture picture = instituitionService.getPicture(institutionDto.getPictureId()).get();
		institution.setInstitutionDisplayPicture(picture);

		instituitionService.addInstituition(institution);
		instituitionService.addTenant(tenant);
		Address address = addressService.setAddress(convertToAddressEntity(institutionDto));

		RelTenantInstitution relTenantInstitution = new RelTenantInstitution(institution, tenant,
				institutionDto.getInstitutionTypeId(), address);
		System.out.println(relTenantInstitution);
		relTenantInstitutionService.addInstituition(relTenantInstitution);
		RelTenantInstitution rel = relTenantInstitutionService.getRelTenantInstitution(institution.getInstitutionId());
		InstitutionDetailsResponse response = new InstitutionDetailsResponse(institution.getInstitutionId(), rel.getRelTenantInstitutionId(),institution.getStatus(), institution.getInstitutionName());
		return response;
	}

	@GetMapping
	public List<InstitutionResponse> getInstitutions() {
		List<InstitutionResponse> response = instituitionService.getAlInstitutions();
		for(int i = 0; i < response.size(); i++) {
			List<Object[]> instructors = addressService.getAddressDetails(response.get(i).getAddressId());
			List<AddressSetDto> exp = instructors.stream()
					.map(o -> new AddressSetDto((String) o[0], (String) o[1]))
					.collect(Collectors.toList());
			response.get(i).setStateName(exp.get(0).getStateName());
			response.get(i).setCityName(exp.get(0).getCityName());

		}

		return response;

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
