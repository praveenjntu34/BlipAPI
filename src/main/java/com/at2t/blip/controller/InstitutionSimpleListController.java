package com.at2t.blip.controller;


import com.at2t.blip.dto.InstitutionDetailsResponse;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.dto.SimpleListDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "blip")
public class InstitutionSimpleListController {


    @Autowired
    InstituitionService instituitionService;


    @RequestMapping(method = RequestMethod.GET, value = "/institution/simple/list")
    public List<SimpleListDto> getAllInstitutionList() {
        return instituitionService.getSimpleList();
    }
}
