package com.at2t.blip.controller;

import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.SectionDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution/section")
@Api(value = "blip")
public class SectionController {
    @Autowired
    InstituitionService instituitionService;


    @PostMapping
    public Object addSection(@RequestBody SectionDto sectionDto) {
        instituitionService.addSection(sectionDto.getSectionName(), sectionDto.getBranchId());
        Object object = new Object() {
            public String response = "Section Added";
        };
        return object;
    }

    @GetMapping
    public List<Section> getSections(@PathVariable int branchId) {
        return instituitionService.getSections(branchId);
    }

    @DeleteMapping("{sectionId}")
    public ResponseEntity deleteSection(@PathVariable("sectionId") int sectionId){
        instituitionService.deleteSection(sectionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
