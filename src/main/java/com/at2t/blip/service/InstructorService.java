package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Instructor;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.Section;
import com.at2t.blip.repository.LoginCredentialRepository;
import com.at2t.blip.repository.PersonRepository;
import com.at2t.blip.repository.SectionRepository;
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

	@Autowired
	PersonRepository personRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	LoginCredentialRepository loginCredentialRepository;



	@Transactional
	public int addInstructor(InstructorDto instructorDto) {
		 return instructorRepository.addInstructor(instructorDto.getPersonId(),instructorDto.getDesignation(),instructorDto.getRelTenantInstitutionId(), instructorDto.getSectionId());
	}

	@Transactional
	public List<Object[]> getInstructorDetails(int relTenantInstitutionId) {
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

	@Transactional
	public void editInstructor(InstructorDto instructorDto) {

		LoginCredential loginCredential = loginCredentialRepository.
				findById(instructorDto.getLoginCredentialId()).get();
		loginCredential.setEmail(instructorDto.getEmail());
		loginCredential.setPhoneNumber(instructorDto.getPhoneNumber());
		Person person = personRepository.findById(instructorDto.getPersonId()).get();
		person.setFirstName(instructorDto.getFirstname());
		person.setLastName(instructorDto.getLastname());
		person.setLoginCredential(loginCredential);
		loginCredential.setPerson(person);
		Instructor instructor = instructorRepository.findById(instructorDto.getInstructorId()).get();
		instructor.setDesignation(instructorDto.getDesignation());
		instructor.setInstructorId(instructorDto.getInstructorId());
		Section section = sectionRepository.findById(instructorDto.getSectionId()).get();
		instructor.setSection(section);
		instructor.setPerson(person);
		instructorRepository.save(instructor);
		personRepository.save(person);
		loginCredentialRepository.save(loginCredential);

	}
}
