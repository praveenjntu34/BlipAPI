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
	public boolean addInstituition(RelTenantInstitution relTenantInstitution) {
		return relTenantInstitutionRepository.save(relTenantInstitution) != null;
	}
}
