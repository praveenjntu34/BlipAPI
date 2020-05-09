package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Parent;
import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.dto.ParentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.ParentDto;
import com.at2t.blip.repository.ParentRepository;

import java.util.List;

@Service
public class ParentService {

	@Autowired
	ParentRepository parentRepository;

	@Transactional
	public Parent addParent(Parent parent) {
		return parentRepository.save(parent);
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

	public List<ParentResponseDto> getAllParents(Integer pageNo, Integer size, int relTenantInstitutionId) {
		List<ParentResponseDto> res = parentRepository.getAllParents(relTenantInstitutionId);
		return res;
	}

}
