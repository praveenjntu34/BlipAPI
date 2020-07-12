package com.at2t.blip.controller;

import com.at2t.blip.dao.Banner;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dto.MultipleBannersDto;
import com.at2t.blip.dto.PostRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.service.BannerService;

import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(value = "blip")
public class BannerController {

	@Autowired
	BannerService bannerService;

	@Autowired
	ModelMapper modelMapper;


	@RequestMapping(value = "/post-banner", method = RequestMethod.POST)
	public Banner addBanner(@RequestParam("file") MultipartFile file) {


	Banner banner = bannerService.storeBannerFile(file);
	return  banner;
}
//	@RequestMapping(value = "/banner", method = RequestMethod.POST)
//	public Object addBannerText(@RequestBody BannerDto bannerDto) {
//
//		bannerService.storeBanner(bannerDto, fi);
//		Object object = new Object() {
//			public String response = "Added Banner succesfully";
//		};
//
//		return object;
//	}

	@RequestMapping(value = "/add-multitple-banners", method = RequestMethod.POST)
	public Object addBanners(@RequestParam(value = "banner_file") MultipartFile file, @RequestParam(value = "data") String bannerDto) {

		MultipleBannersDto banners;
		try {
			ObjectMapper mapper = new ObjectMapper();
			banners = mapper.readValue(bannerDto, MultipleBannersDto.class);
			bannerService.storeBanner(banners, file);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println(bannerDto);
		System.out.println(bannerDto);

		return null;
	}


	@RequestMapping(value = "/delete-banner/{bannerId}", method = RequestMethod.DELETE)
	public Object deleteBanner(@PathVariable int bannerId) {

		bannerService.deleteBanner(bannerId);
		Object object = new Object() {
			public String response = "Deleted Banner succesfully";
		};

		return object;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/banner/{relTenantInstitutionId}")
	public List<Banner> getBanners(@PathVariable int relTenantInstitutionId) {

		List<Banner> banners = bannerService.getBanners(relTenantInstitutionId, 0);

		return banners;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/banner/institution/{relTenantInstitutionId}")
	public List<Banner> getBannersForInstitution(@PathVariable int relTenantInstitutionId) {

		List<Banner> banners = bannerService.getBannersForInstitution(relTenantInstitutionId);

		return banners;

	}
}
