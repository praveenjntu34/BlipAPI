package com.at2t.blip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.repository.RelTenantInstitutionRepository;

@Service
public class RelTenantInstitutionService {

	@Autowired
	RelTenantInstitutionRepository relTenantInstitutionRepository;

	@Transactional
	public void addInstituition(RelTenantInstitution relTenantInstitution) {

		 relTenantInstitutionRepository.insertData(relTenantInstitution.getTenant().getTenantId(), relTenantInstitution.getInstitutionTypeID(), relTenantInstitution.getAddress().getAddressId(), relTenantInstitution.getInstitution().getInstitutionId());
	}

	@Transactional
	public RelTenantInstitution getRelTenantInstitution(int institutionId) {
		return relTenantInstitutionRepository.findByTenantId(institutionId);
	}
}
