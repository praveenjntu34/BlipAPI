package com.at2t.blip.service;

import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.PersonType;
import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.repository.PersonRepository;
import com.at2t.blip.repository.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonTypeRepository personTypeRepository;

    @Transactional
    public Optional<PersonType> getPersonType(int personTypeId) {
        return personTypeRepository.findById(personTypeId);
    }
}
