package com.at2t.blip.service;

import com.at2t.blip.dao.Tenant;
import com.at2t.blip.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at2t.blip.dao.Institution;
import com.at2t.blip.repository.InstituitionRepository;

import java.util.Optional;

@Service
public class InstituitionService {

	@Autowired
	InstituitionRepository instituitionRepository;

	@Autowired
	TenantRepository tenantRepository;

	@Transactional
	public Institution addInstituition(Institution instituition) {
		return instituitionRepository.save(instituition);
	}

	@Transactional
	public Tenant addTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}

	public Optional<Institution> findInstitution(int institutionId){
		return instituitionRepository.findById(institutionId);
	}

	public Optional<Tenant> findTenant(int tenantId){
		return tenantRepository.findById(tenantId);
	}
}
