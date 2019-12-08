package com.at2t.blip.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.ParentDto;
import com.at2t.blip.repository.ParentRepository;

@Service
public class ParentService {

	@Autowired
	ParentRepository parentRepository;

	@Transactional
	public void addParent(ParentDto parentDto) {
		parentRepository.addParent(parentDto.getSecondaryPhoneNumber(), parentDto.getPersonId(),
				parentDto.getRelTenantInstitutionId());
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

}
