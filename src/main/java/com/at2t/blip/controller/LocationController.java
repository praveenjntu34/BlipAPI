package com.at2t.blip.controller;

import com.at2t.blip.dao.*;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.service.LocationService;
import com.at2t.blip.service.StateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
@Api(value = "blip")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    StateService stateService;

    @GetMapping
    public Iterable<State> getLocation() {
        return locationService.getAllStates();
    }

    @PostMapping
    public Iterable<City> getCities(@RequestParam int stateId) {
       return stateService.getAllCities(stateId);
    }
}
