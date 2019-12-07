package com.at2t.blip.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.repository.BannerRepository;

@Service
public class BannerService {

	@Autowired
	BannerRepository bannerRepository;

	@Transactional
	public void addBanner(BannerDto bannerDto) {
		bannerRepository.addBanner(bannerDto.getRelTenantInstitutionId(), bannerDto.getBannerName(),
				bannerDto.getBannerStreamId());
	}
	
	@Transactional
	public void deleteBanner(Integer bannerId) {
		bannerRepository.deleteBanner(bannerId);
	}

	@Transactional
	public void updateBanner(BannerDto bannerDto) {
		bannerRepository.updateBanner(bannerDto.getRelTenantInstitutionId(),bannerDto.getBannerName(),bannerDto.getBannerId());
		
	}

}
