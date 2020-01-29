package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dao.LoginCredential;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void addInstructor(InstructorDto instructorDto) {
		 instructorRepository.addInstructor(instructorDto.getPersonId(),instructorDto.getDesignation(),instructorDto.getRelTenantInstitutionId(), instructorDto.getSectionId());
	}

	@org.springframework.transaction.annotation.Transactional
	public List<Instructor> getInstructorDetails(int relTenantInstitutionId) {
		return instructorRepository.getInstructorDetails(relTenantInstitutionId);
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
