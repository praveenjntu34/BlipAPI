package com.at2t.blip.controller;

import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.dao.Section;
import com.at2t.blip.service.InstitutionListService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/institution")
@Api(value = "blip")
public class InstitutionListController {

    @Autowired
    InstitutionListService institutionListService;

    @GetMapping
    public List<RelTenantInstitution> getSections() {
        return institutionListService.getAlInstitutions();
    }
}
