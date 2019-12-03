package com.at2t.blip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.at2t.blip.dao.Institution;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.Tenant;
import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.dto.InstitutionAdminDto;
import com.at2t.blip.dto.LoginCredentialDto;
import com.at2t.blip.dto.SectionDto;
import com.at2t.blip.repository.InstituitionRepository;
import com.at2t.blip.repository.InstitutionAdminRepository;
import com.at2t.blip.repository.LoginCredentialRepository;
import com.at2t.blip.repository.PersonRepository;
import com.at2t.blip.repository.TenantRepository;

@Service
public class InstituitionService {

	@Autowired
	InstituitionRepository instituitionRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	TenantRepository tenantRepository;
	@Autowired
	InstitutionAdminRepository institutionAdminRepository;
	@Autowired
	LoginCredentialRepository loginCredentialRepository;

	@Transactional
	public Institution addInstituition(Institution instituition) {
		return instituitionRepository.save(instituition);
	}

	@Transactional
	public Tenant addTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}

	public Optional<Institution> findInstitution(int institutionId) {
		return instituitionRepository.findById(institutionId);
	}

	public Optional<Tenant> findTenant(int tenantId) {
		return tenantRepository.findById(tenantId);
	}

	@Transactional
	public void addPOCDetail(InstitutionAdminDto institutionAdminDto) {
		institutionAdminRepository.addInstitutionData(institutionAdminDto.getSecondaryPOCName(),
				institutionAdminDto.getRelInstitutionId(), institutionAdminDto.getPersonId(),
				institutionAdminDto.getSecondaryPOCEmail(), institutionAdminDto.getSecondaryPOCPhoneNumber());
	}

	@Transactional
	public void addBranch(BranchDto branchDto) {
		institutionAdminRepository.addBranch(branchDto.getBranchName(), branchDto.getRelTenantInstitutionId());
	}

	@Transactional
	public void addBranch(String sectionName, int branchId) {
		institutionAdminRepository.addSection(sectionName, branchId);
	}
	@Transactional
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	@Transactional
	public void addLoginCredential(LoginCredentialDto loginCredentialDto) {
		 loginCredentialRepository.addLoginCrendentials(loginCredentialDto.getPersonId(), loginCredentialDto.getEmail(),
				loginCredentialDto.getPhoneNumber());
	}
	
	
}
