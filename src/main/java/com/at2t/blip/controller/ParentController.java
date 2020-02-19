package com.at2t.blip.controller;

import com.at2t.blip.dao.Child;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Parent;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.LoginCredentialDto;
import com.at2t.blip.dto.ParentRequestDto;
import com.at2t.blip.service.ChildService;
import com.at2t.blip.service.InstituitionService;
import com.at2t.blip.util.RandomPasswordGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.dto.ParentDto;
import com.at2t.blip.service.ParentService;

import io.swagger.annotations.Api;

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

	@RequestMapping(value = "/updateParent", method = RequestMethod.POST)
	public String updateParent(@RequestBody ParentDto parentDto) {
		parentService.updateParent(parentDto);
		return "Updated Parent";
	}

}
