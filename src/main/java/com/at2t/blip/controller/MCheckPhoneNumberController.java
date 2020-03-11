package com.at2t.blip.controller;

import com.at2t.blip.dto.InstitutionDetailsResponse;
import com.at2t.blip.dto.InstitutionDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "blip")
public class MCheckPhoneNumberController {

    @RequestMapping(method = RequestMethod.POST, value = "/check-phone")
    public InstitutionDetailsResponse checkWhetherParentExists(@RequestBody InstitutionDto institutionDto) {

        return null;
    }

    }

