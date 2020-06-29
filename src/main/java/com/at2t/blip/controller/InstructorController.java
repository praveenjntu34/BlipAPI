package com.at2t.blip.controller;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.InstituitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.service.InstructorService;

import io.swagger.annotations.Api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "blip")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@Autowired
	InstituitionService instituitionService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/instructor", method = RequestMethod.POST)
	public Object addInstructor(@RequestBody InstructorDto instructorDto) {
		Person person = new Person();

		person.setFirstName(instructorDto.getFirstname());
		person.setLastName(instructorDto.getLastname());
		person.setGender('M');
		person.setPersonTypeId(5);


		Person personObj = instituitionService.addPerson(person);
		LoginCredentialDto loginCredentialDto = new LoginCredentialDto();

		loginCredentialDto.setPersonId(personObj.getPersonId());
		loginCredentialDto.setEmail(instructorDto.getEmail());
		loginCredentialDto.setPhoneNumber(instructorDto.getPhoneNumber());
		instituitionService.addLoginCredential(loginCredentialDto);

		instructorDto.setPersonId(personObj.getPersonId());
		int id = instructorService.addInstructor(instructorDto);
		Object object = new Object() {
			public String response = "Added Instructor succesfully";
			public int instructorId = id;
		};
		return object;
	}

	@RequestMapping(value = "/instructor/{relTenantInstitutionId}", method = RequestMethod.GET)
	public InstructorPagesDto getInstructors(@PathVariable int relTenantInstitutionId, @RequestParam(value = "pageNumber", required = false) Integer pageNumber , @RequestParam(value = "size", required = false) Integer size) {

		InstructorPagesDto instructors = instructorService.getInstructorDetails(relTenantInstitutionId, pageNumber,size);
//		List<InstructorResponseDto> exp = instructors.stream()
//				.map(o -> new InstructorResponseDto((int) o[0], (String) o[1], (String) o[2], (String) o[3], (String) o[4],
//						(String) o[5], (int) o[6], (int) o[7]))
//				.collect(Collectors.toList());


		return instructors;
	}

	@RequestMapping(value = "/deleteInstructor/{instructorId}", method = RequestMethod.DELETE)
	public Object deleteInstructor(@PathVariable int instructorId) {
		instructorService.deleteInstructor(instructorId);
		Object object = new Object() {
			public String response = "Deleted instructor";
		};
		return object;
	}

	@RequestMapping(value = "/updateInstructor", method = RequestMethod.POST)
	public String updateInstructor(@RequestBody InstructorDto instructorDto) {
		instructorService.updateInstructor(instructorDto);
		return "Updated Instructor";
	}

	@PutMapping("/editInstructor")
	public Object editInstructor(@RequestBody  InstructorDto instructorDto){
		instructorService.editInstructor(instructorDto);
		Object object = new Object() {
			public String response = "Updated instructor";
		};
		return object;
	}

}
