package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.service.RelTenantInstitutionService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
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

	@RequestMapping(method = RequestMethod.POST, value = "/institution/details")
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
	@RequestMapping(method = RequestMethod.GET, value = "/institution/details")
	public List<InstitutionResponse> getInstitutions(@RequestParam(value = "stateId", required = false) Integer stateId, @RequestParam(value = "cityId", required = false) Integer cityId,
	@RequestParam(value = "pageNumber", required = false) Integer pageNumber , @RequestParam(value = "size", required = false) Integer size) {

		List<InstitutionResponse> response = instituitionService.getAlInstitutions(pageNumber,size, cityId);
		if(response == null){
			List<InstitutionResponse> res = new ArrayList<>();
			InstitutionResponse ins = new InstitutionResponse();
			ins.setCount(0);
			res.add(ins);
			return res;
		} else {
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
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/institution/details")
	public InstitutionDetailsResponse updateInstitution(@RequestBody InstitutionDto institutionDto) {
		Institution institutionObject = convertToInstitutionEntity(institutionDto);
		institutionObject.setInstitutionId(institutionDto.getInstitutionId());


		InstitutionDisplayPicture picture = instituitionService.getPicture(institutionDto.getPictureId()).get();
		institutionObject.setInstitutionDisplayPicture(picture);

		Tenant tenant = new Tenant(institutionDto.getInstitutionName());
		tenant.setTenantId(institutionDto.getInstitutionId());
		instituitionService.addTenant(tenant);

		instituitionService.updateInstituition(institutionObject);

		Address address = convertToAddressEntity(institutionDto);
		address.setAddressId(institutionDto.getAddressId());
		addressService.setAddress(address);


		RelTenantInstitution relTenantInstitution = new RelTenantInstitution(institutionObject, tenant,
				institutionDto.getInstitutionTypeId(), address);
		relTenantInstitution.setRelTenantInstitutionId(institutionDto.getInstitutionId());
		RelTenantInstitution rel = relTenantInstitutionService.getRelTenantInstitution(institutionObject.getInstitutionId());


		InstitutionDetailsResponse response = new InstitutionDetailsResponse(institutionObject.getInstitutionId(), 0,institutionObject.getStatus(), institutionObject.getInstitutionName());
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
