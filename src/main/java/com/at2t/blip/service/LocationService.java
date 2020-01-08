package com.at2t.blip.service;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dao.City;
import com.at2t.blip.dao.State;
import com.at2t.blip.repository.CityRepository;
import com.at2t.blip.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    StateRepository stateRepository;


    @Transactional
    public Iterable<State> getAllStates() {
        return stateRepository.findAll();
    }


}
