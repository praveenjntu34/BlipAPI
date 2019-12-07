package com.at2t.blip.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dto.InstructorDto;
import com.at2t.blip.service.InstructorService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "blip")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/addInstructor", method = RequestMethod.POST)
	public String addInstructor(@RequestBody InstructorDto instructorDto) {
		instructorService.addInstructor(instructorDto);
		return "Add Instructor";
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
