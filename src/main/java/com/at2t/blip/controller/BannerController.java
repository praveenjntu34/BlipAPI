package com.at2t.blip.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.service.BannerService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "blip")
public class BannerController {

	@Autowired
	BannerService bannerService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/addBanner", method = RequestMethod.POST)
	public String addBanner(@RequestBody BannerDto bannerDto) {
		bannerService.addBanner(bannerDto);
		return "Add Banner";
	}
	
	@RequestMapping(value = "/deleteBanner", method = RequestMethod.POST)
	public String addBanner(@RequestBody int bannerid) {
		bannerService.deleteBanner(bannerid);
		return "Delete Banner";
	}
	
	@RequestMapping(value = "/updateBanner", method = RequestMethod.POST)
	public String updateBanner(@RequestBody BannerDto bannerDto) {
		bannerService.updateBanner(bannerDto);
		return "Updated Banner";
	}


}
