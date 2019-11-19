package com.at2t.blip.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at2t.blip.dao.RelTenantInstitutionAddress;
import com.at2t.blip.repository.RelTenantInstitutionAddressRepository;

@Service
public class RelTenantInstitutionAddressService {

	@Autowired
	RelTenantInstitutionAddressRepository relTenantInstitutionAddressRepository;

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public RelTenantInstitutionAddress addRelTenantInstitutionAddress(
			RelTenantInstitutionAddress relTenantInstitutionAddress) {
		return relTenantInstitutionAddressRepository.save(relTenantInstitutionAddress);
	}

	@Transactional
	public void updateRelTenantInstitutionAddress(RelTenantInstitutionAddress relTenantInstitutionAddress) {
		em.merge(relTenantInstitutionAddress);

	}
}
