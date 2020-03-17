package com.at2t.blip.service;

import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.repository.RelTenantInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionListService {

    @Autowired
    RelTenantInstitutionRepository relTenantInstitutionRepository;


    public List<RelTenantInstitution> getAlInstitutions() {
        return relTenantInstitutionRepository.findAll();
    }
}
