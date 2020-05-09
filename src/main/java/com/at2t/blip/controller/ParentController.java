package com.at2t.blip.controller;

import com.at2t.blip.dao.Child;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Parent;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.ChildService;
import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.util.RandomPasswordGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.service.ParentService;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "blip")
public class ParentController {

	@Autowired
	ParentService parentService;

	@Autowired
	ChildService childService;

	@Autowired
	InstituitionService instituitionService;
	@Autowired
	RandomPasswordGenerator randomPasswordGenerator;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	@RequestMapping(method = RequestMethod.GET, value = "/parent")
	public List<ParentResponseDto> getInstitutions(@RequestParam(value = "relTenantInstitutionId", required = false) Integer relTenantInstitutionId) {
		List<ParentResponseDto> parents = parentService.getAllParents(1,10, relTenantInstitutionId);
		return parents;
	}


	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	public Child addParent(@RequestBody ParentRequestDto parentDto) {
		Person person = new Person();
		person.setFirstName(parentDto.getParentOneFirstName());
		person.setLastName(parentDto.getParentOneLastName());
		person.setGender('M');
		person.setPersonTypeId(4);

		Person personObj = instituitionService.addPerson(person);
		LoginCredentialDto loginCredentialDto = new LoginCredentialDto();

		loginCredentialDto.setPersonId(personObj.getPersonId());
		loginCredentialDto.setEmail(parentDto.getEmail());
		loginCredentialDto.setPhoneNumber(parentDto.getPhoneNumber());
		loginCredentialDto.setPasscode(randomPasswordGenerator.getAlphaNumericString(12));
		LoginCredential lc = instituitionService.addLoginCredential(loginCredentialDto);

		Parent parent = new Parent();
		parent.setPersonId(personObj);
		parent.setSecondaryPhoneNumber(parentDto.getSecondaryPhoneNumber());
		parent.setRelTenantInstitutionId(parentDto.getRelTenantInstitutionId());

		Parent parentResponse = parentService.addParent(parent);
		Child child = new Child();
		child.setAdmissionId(parentDto.getAdmissionNumber());
		child.setChildrenName(parentDto.getChildrenName());
		child.setSectionId(parentDto.getSectionId());
		child.setParent(parentResponse);
		return childService.addChild(child);

//		return "Add Parent";
	}

	@RequestMapping(value = "/deleteParent", method = RequestMethod.POST)
	public String deleteParent(@RequestBody int parentId) {
		parentService.deleteParent(parentId);
		return "Delete parent";
	}

	@RequestMapping(value = "/update-parent", method = RequestMethod.POST)
	public Child updateParent(@RequestBody ParentRequestDto parentDto) {

		Person person = new Person();
		person.setFirstName(parentDto.getParentOneFirstName());
		person.setLastName(parentDto.getParentOneLastName());
		person.setGender('M');
		person.setPersonTypeId(4);
		person.setPersonId(parentDto.getPersonId());

		Person personObj = instituitionService.addPerson(person);
		LoginCredentialDto loginCredentialDto = new LoginCredentialDto();

		loginCredentialDto.setLoginCredentialId(parentDto.getLoginCredentialId());
		loginCredentialDto.setEmail(parentDto.getEmail());
		loginCredentialDto.setPhoneNumber(parentDto.getPhoneNumber());
		instituitionService.updateLoginCredential(loginCredentialDto);


		Parent parent = new Parent();
		parent.setParentId(parentDto.getParentId());
		parent.setSecondaryPhoneNumber(parentDto.getSecondaryPhoneNumber());
		parent.setRelTenantInstitutionId(parentDto.getRelTenantInstitutionId());

		Parent parentResponse = parentService.addParent(parent);

		Child child = new Child();
		child.setChildId(parentDto.getChildId());
		child.setAdmissionId(parentDto.getAdmissionNumber());
		child.setChildrenName(parentDto.getChildrenName());
		child.setSectionId(parentDto.getSectionId());
		return childService.addChild(child);

//		parentService.updateParent(parentDto);
//		return "Updated Parent";
	}

}
