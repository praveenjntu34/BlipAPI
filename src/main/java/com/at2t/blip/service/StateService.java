package com.at2t.blip.service;

import com.at2t.blip.dao.City;
import com.at2t.blip.dto.InstitutionResponseDto;
import com.at2t.blip.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StateService {

    @Autowired
    CityRepository cityRepository;

    @Transactional
    public Iterable<City> getAllCities(int stateId) {
        return cityRepository.getAllCitiesByState(stateId);
    }

    @Transactional
    public List<City> getCity(int id) {
        return cityRepository.findCityAndState(2);
    }
}
