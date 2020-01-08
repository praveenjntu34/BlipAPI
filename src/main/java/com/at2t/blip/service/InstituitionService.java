package com.at2t.blip.service;

import java.util.List;
import java.util.Optional;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.dto.InstitutionAdminDto;
import com.at2t.blip.dto.LoginCredentialDto;

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
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	InstitutionDisplayPictureRepository displayPictureRepository;

	@Autowired
	RelTenantInstitutionRepository relTenantInstitutionRepository;

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
	public void addSection(String sectionName, int branchId) {
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

	@Transactional
	public  Optional<InstitutionDisplayPicture> getPicture(int pictureId) {
		return displayPictureRepository.findById(pictureId);
	}
	@Transactional
	public List<InstitutionResponse> getAlInstitutions() {
		return instituitionRepository.getAllInstitutions();
	}
	@Transactional
	public List<Branch> getBranch(int relTenantInstitutionId) {
		return branchRepository.findById(relTenantInstitutionId);
	}
	
	@Transactional
	public List<Section> getSections(int branchId) {
		return sectionRepository.getSection(branchId);
	}

}
