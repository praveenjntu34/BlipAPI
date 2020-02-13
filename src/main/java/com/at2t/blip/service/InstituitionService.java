package com.at2t.blip.service;

import java.util.List;
import java.util.Optional;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.*;
import com.at2t.blip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Institution updateInstituition(Institution instituition) {
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

		System.out.println(institutionAdminDto.toString());
		institutionAdminRepository.addInstitutionData(institutionAdminDto.getSecondaryPOCName(),
				institutionAdminDto.getRelInstitutionId(), institutionAdminDto.getPersonId(),
				institutionAdminDto.getSecondaryPOCEmail(), institutionAdminDto.getSecondaryPOCPhoneNumber());
	}
	@Transactional
	public void addPOCDetail(POCRequestDto pocRequestDto) {

		institutionAdminRepository.updateAdmin(pocRequestDto.getSecondaryPOCFirstName() + " " + pocRequestDto.getSecondaryPOCLastName(),
				pocRequestDto.getSecondaryPOCEmail(), pocRequestDto.getSecondaryPOCPhoneNumber(), pocRequestDto.getInstitutionAdminId());
	}

	@Transactional
	public int addBranch(BranchDto branchDto) {
		return institutionAdminRepository.addBranch(branchDto.getBranchName(), branchDto.getRelTenantInstitutionId());
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
	public LoginCredential addLoginCredential(LoginCredentialDto loginCredentialDto) {
//		return loginResponse;

		int id = loginCredentialRepository.addLoginCrendentials(loginCredentialDto.getPersonId(), loginCredentialDto.getEmail(),
				loginCredentialDto.getPasscode(),loginCredentialDto.getPhoneNumber());
		LoginCredential lc = loginCredentialRepository.findById(id).get();
		return lc;
	}

	@Transactional
	public void updateLoginCredential(LoginCredentialDto loginCredential) {
		loginCredentialRepository.updateLoginCrendentials(loginCredential.getEmail(), loginCredential.getPhoneNumber(), loginCredential.getLoginCredentialId());

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
	public InstitutionResponseDto getInstitutionDetails(int id) {
		return instituitionRepository.getInstitutionalDetails(id);
	}


	@Transactional
	public Optional<LoginCredential> getPersonDetails(int personId) {
		return loginCredentialRepository.getPersonDetails(personId);
	}

	@Transactional
	public List<InstitutionResponse> getAlInstitutionsDetails() {
		return instituitionRepository.getAllInstitutions();
	}

	@Transactional
	public List<Branch> getBranch(int relTenantInstitutionId) {
//		return branchRepository.findAll();
		return branchRepository.findBranches(relTenantInstitutionId);
	}

	
	@Transactional
	public List<Section> getSections(int branchId) {
		return sectionRepository.getSection(branchId);
	}

	@Transactional
	public Optional<RelTenantInstitution> getReltenantInstitution(int relTenantInstitutionId){
		return relTenantInstitutionRepository.findById(relTenantInstitutionId);
	}
}
