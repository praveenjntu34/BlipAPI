package com.at2t.blip.service;

import com.at2t.blip.dao.InstitutionAdmin;
import com.at2t.blip.repository.InstitutionAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InstitutionAdminService {

    @Autowired
    InstitutionAdminRepository institutionAdminRepository;

    @Transactional
    public Optional<InstitutionAdmin> getAdmin(int relTenantInstitutionId) {
        return institutionAdminRepository.findByRelTenantInstitutionId(relTenantInstitutionId);
    }

}
