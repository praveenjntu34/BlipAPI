package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dto.InstructorPagesDto;
import com.at2t.blip.dto.InstructorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.dto.InstructorDto;
import com.at2t.blip.repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

	@Autowired
	InstructorRepository instructorRepository;

	@Transactional
	public int addInstructor(InstructorDto instructorDto) {
		 return instructorRepository.addInstructor(instructorDto.getPersonId(),instructorDto.getDesignation(),instructorDto.getRelTenantInstitutionId(), instructorDto.getSectionId());
	}

	@Transactional
	public InstructorPagesDto getInstructorDetails(int relTenantInstitutionId, int pageNumber, int size) {
		Page<InstructorResponseDto> res = instructorRepository.getInstructorDetails(relTenantInstitutionId, PageRequest.of(pageNumber,size));
		InstructorPagesDto instructorPagesDto = new InstructorPagesDto();
		instructorPagesDto.setInstructors(res.getContent());
		instructorPagesDto.setPages(res.getTotalPages());

		return instructorPagesDto;

	}
	@Transactional
	public void deleteInstructor(Integer instructorId) {
		instructorRepository.deleteInstructor(instructorId);
	}

	@Transactional
	public void updateInstructor(InstructorDto instructorDto) {
		instructorRepository.updateInstructor(instructorDto.getPersonId(), instructorDto.getSectionId(),
				instructorDto.getInstructorId());

	}

}
