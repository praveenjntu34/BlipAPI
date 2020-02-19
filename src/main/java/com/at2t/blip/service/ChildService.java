package com.at2t.blip.service;

import javax.transaction.Transactional;

import com.at2t.blip.dao.Child;
import com.at2t.blip.dao.Parent;
import com.at2t.blip.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.ParentDto;
import com.at2t.blip.repository.ParentRepository;

@Service
public class ChildService {

    @Autowired
    ChildRepository childRepository;

    @Transactional
    public Child addChild(Child child) {
        return childRepository.save(child);
    }


}
