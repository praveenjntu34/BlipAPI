package com.at2t.blip.controller;

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
	ModelMapper modelMapper;

	@RequestMapping(value = "/addParent", method = RequestMethod.POST)
	public String addParent(@RequestBody ParentDto parentDto) {
		parentService.addParent(parentDto);
		return "Add Parent";
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
