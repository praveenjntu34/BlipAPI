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
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public ParentsPagesDto getInstitutions(@RequestParam(value = "relTenantInstitutionId", required = false) Integer relTenantInstitutionId, @RequestParam(value = "pageNumber", required = false) Integer pageNumber , @RequestParam(value = "size", required = false) Integer size) {
		ParentsPagesDto parents = parentService.getAllParents(pageNumber,size, relTenantInstitutionId);
		return parents;
	}

	@GetMapping
	@RequestMapping(method = RequestMethod.GET, value = "/parent/single")
	public List<ParentResponseDto> getSingleParent(@RequestParam(value = "childId", required = false) Integer childId) {
		List<ParentResponseDto> parents = parentService.getSingleParents(1,10 , childId);
		return parents;
	}


	@RequestMapping(value = "/parent", method = RequestMethod.POST)
	public Child addParent(@RequestBody ParentRequestDto parentDto){
		Person person = new Person();
		person.setFirstName(parentDto.getParentOneFirstName());
		person.setLastName(parentDto.getParentOneLastName());
		person.setGender('M');
		person.setPersonTypeId(4);
//		try {
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//			Date dateOfBirth = df.parse(parentDto.getDOB());
//			person.setDateOfBirth(dateOfBirth);
//		}
//		catch(ParseException e){
//			e.getMessage();
//		}

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
		parent.setSecondaryParentName(parentDto.getSecondaryParentName());


		Parent parentResponse = parentService.addParent(parent);
		Child child = new Child();
		child.setAdmissionId(parentDto.getAdmissionNumber());
		child.setChildrenName(parentDto.getChildrenName());
		child.setSectionId(parentDto.getSectionId());
		child.setParent(parentResponse);
		return childService.addChild(child);

//		return "Add Parent";
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
		parent.setPersonId(personObj);
		parent.setParentId(parentDto.getParentId());
		parent.setSecondaryPhoneNumber(parentDto.getSecondaryPhoneNumber());
		parent.setRelTenantInstitutionId(parentDto.getRelTenantInstitutionId());
		parent.setSecondaryParentName(parentDto.getSecondaryParentName());
		Parent parentResponse = parentService.addParent(parent);

		Child child = new Child();
		child.setChildId(parentDto.getChildId());
		child.setEnabled(parentDto.getEnabled());
		child.setParent(parent);
		child.setAdmissionId(parentDto.getAdmissionNumber());
		child.setChildrenName(parentDto.getChildrenName());
		child.setSectionId(parentDto.getSectionId());
		return childService.addChild(child);

//		parentService.updateParent(parentDto);
//		return "Updated Parent";
	}

	@PostMapping("/parent/file")
	public String readParentFromFile(@RequestParam("file")MultipartFile parentsFile) throws Exception {
		boolean result = parentService.addParentsFromFile(parentsFile);
		if(result == false) throw new Exception("Some error occurred");
		return "Parent Details added to the DB";
	}

	@PostMapping("/parent/delete")
	public Object deleteParent(@RequestBody DeleteParentDto deleteParentDto ) throws Exception {

		parentService.deleteParent(deleteParentDto);
		Object object = new Object() {
			public String response = "Parent Details deleted";
		};
		return object;
	}

	@PutMapping("/parent/edit")
	public String editParent(@RequestBody UpdateParentDto updateParentDto){
		parentService.editParent(updateParentDto);
		return "Parent details successfully updated.";
	}

	@GetMapping("/parent/search")
	public List<ParentResponseDto> searchUserByAdmissionId(@RequestParam(value = "admissionId") String admissionId){
		List<ParentResponseDto> res = parentService.searchByAdmissionId(admissionId);
		return res;
	}



}
