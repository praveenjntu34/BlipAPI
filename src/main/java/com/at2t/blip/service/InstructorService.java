package com.at2t.blip.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.BannerDto;
import com.at2t.blip.dto.InstructorDto;
import com.at2t.blip.repository.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	InstructorRepository instructorRepository;

	@Transactional
	public void addInstructor(InstructorDto instructorDto) {
		instructorRepository.addInstructor(instructorDto.getPersonId(), instructorDto.getSectionId());
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
