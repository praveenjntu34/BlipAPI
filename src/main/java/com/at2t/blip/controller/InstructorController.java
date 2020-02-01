package com.at2t.blip.controller;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.InstructorResponseDto;
import com.at2t.blip.dto.LoginCredentialDto;
import com.at2t.blip.dto.PersonDto;
import com.at2t.blip.service.InstituitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.dto.InstructorDto;
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
		instructorService.addInstructor(instructorDto);
		Object object = new Object() {
			public String response = "Added Instructor succesfully";
		};
		return object;
	}

	@RequestMapping(value = "/instructor/{relTenantInstitutionId}", method = RequestMethod.GET)
	public List<InstructorResponseDto> getInstructors(@PathVariable int relTenantInstitutionId) {

		List<Object[]> instructors = instructorService.getInstructorDetails(relTenantInstitutionId);
		List<InstructorResponseDto> exp = instructors.stream()
				.map(o -> new InstructorResponseDto((int) o[0], (String) o[1], (String) o[2], (String) o[3], (String) o[4],
						(String) o[5], (int) o[6], (int) o[7]))
				.collect(Collectors.toList());


		return exp;
	}

	@RequestMapping(value = "/deleteInstructor", method = RequestMethod.POST)
	public String addInstructor(@RequestBody int instructorId) {
		instructorService.deleteInstructor(instructorId);
		return "Delete Instructor";
	}

	@RequestMapping(value = "/updateInstructor", method = RequestMethod.POST)
	public String updateInstructor(@RequestBody InstructorDto instructorDto) {
		instructorService.updateInstructor(instructorDto);
		return "Updated Instructor";
	}

}
