package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Banner;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.PostRequestDto;
import com.at2t.blip.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.repository.BannerRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BannerService {

	@Autowired
	BannerRepository bannerRepository;


	public Banner storeBannerFile(MultipartFile file) {
		//Normalizing file
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			Banner banner = new Banner(file.getBytes());


			bannerRepository.save(banner);
			return banner;

		} catch(IOException e) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
		}
	}

	public void storeBanner(BannerDto bannerDto) {

		try {

			Banner banner = new Banner(bannerDto.getRelTenantInstitutionId(), bannerDto.getTitle(), bannerDto.getShortDescription());

			if(bannerDto.getBannerId() == 0) {
				bannerRepository.save(banner);
			} else {
				bannerRepository.updateBanner(bannerDto.getRelTenantInstitutionId(), bannerDto.getTitle(), bannerDto.getShortDescription(), bannerDto.getBannerId());
			}

		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Transactional
	public List<Banner> getBanners(int relTenantInstitutionId) {

		try {
			return bannerRepository.getBanners(relTenantInstitutionId);
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}

	}

	
	@Transactional
	public void deleteBanner(Integer bannerId) {
		bannerRepository.deleteBanner(bannerId);
	}


}
