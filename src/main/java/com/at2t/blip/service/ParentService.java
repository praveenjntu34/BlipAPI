package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.controller.ParentController;
import com.at2t.blip.dao.Child;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Parent;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.LoginCredentialDto;
import com.at2t.blip.dto.ParentRequestDto;
import com.at2t.blip.util.RandomPasswordGenerator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.ParentDto;
import com.at2t.blip.repository.ParentRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ParentService {

	@Autowired
	ParentRepository parentRepository;
	@Autowired
	ParentController parentController;
	@Autowired
	InstituitionService instituitionService;
	@Autowired
	RandomPasswordGenerator randomPasswordGenerator;
	@Autowired
	ChildService childService;


	@Transactional
	public Parent addParent(Parent parent) {
		return parentRepository.save(parent);
	}

	@Transactional
	public void deleteParent(Integer parentId) {
		parentRepository.deleteParent(parentId);
	}

	@Transactional
	public void updateParent(ParentDto parentDto) {
		parentRepository.updateParent(parentDto.getSecondaryPhoneNumber(), parentDto.getPersonId(),
				parentDto.getRelTenantInstitutionId(), parentDto.getParentId());
	}

	@Transactional
	public boolean addParentsFromFile(MultipartFile file) throws IOException {
		CsvMapper csvMapper = new CsvMapper();
		InputStream stream = file.getInputStream();
		CsvSchema schema = csvMapper.schemaFor(ParentRequestDto.class).withHeader().withColumnReordering(true);
		ObjectReader reader = csvMapper.readerFor(ParentRequestDto.class).with(schema);
		List<ParentRequestDto> allParentsList = reader.<ParentRequestDto>readValues(stream).readAll();
		for(ParentRequestDto temp : allParentsList){

			boolean result = addSingleParentsFromFile(temp);
			if(result == false) return false;
		}
		return true;
	}

	@Transactional
	private boolean addSingleParentsFromFile(ParentRequestDto parentDto)  {
		Person person = new Person();
		person.setFirstName(parentDto.getParentOneFirstName());
		person.setLastName(parentDto.getParentOneLastName());
		person.setGender('M');
		person.setPersonTypeId(4);
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dateOfBirth = df.parse(parentDto.getDOB());
			person.setDateOfBirth(dateOfBirth);
		}
		catch(ParseException e){
			e.getMessage();
		}

		Person personObj = instituitionService.addPerson(person);
		LoginCredentialDto loginCredentialDto = new LoginCredentialDto();

		loginCredentialDto.setPersonId(personObj.getPersonId());
		loginCredentialDto.setEmail(parentDto.getEmail());
		loginCredentialDto.setPhoneNumber(parentDto.getPhoneNumber());
		loginCredentialDto.setPasscode(randomPasswordGenerator.getAlphaNumericString(12));
		LoginCredential lc = instituitionService.addLoginCredential(loginCredentialDto);

		Parent parent = new Parent();
		parent.setPersonId(personObj);
		parent.setSecondaryPhoneNumber(parentDto.getSecondaryPhoneNumber());
		parent.setRelTenantInstitutionId(parentDto.getRelTenantInstitutionId());
		parent.setSecondaryParentName(parentDto.getSecondaryParentName());


		Parent parentResponse = addParent(parent);
		Child child = new Child();
		child.setAdmissionId(parentDto.getAdmissionNumber());
		child.setChildrenName(parentDto.getChildrenName());
		child.setSectionId(parentDto.getSectionId());
		child.setParent(parentResponse);
		childService.addChild(child);
		return true;
	}



}
