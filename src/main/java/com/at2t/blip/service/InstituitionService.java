package com.at2t.blip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.at2t.blip.dao.Institution;
import com.at2t.blip.repository.InstituitionRepository;

@Service
public class InstituitionService {

	@Autowired
	InstituitionRepository instituitionRepository;

	@Transactional
	public boolean addInstituition(Institution instituition) {
		return instituitionRepository.save(instituition) != null;
	}
}
