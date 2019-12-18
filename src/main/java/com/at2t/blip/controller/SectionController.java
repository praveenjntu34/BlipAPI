package com.at2t.blip.controller;

import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.SectionDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution/section")
@Api(value = "blip")
public class SectionController {
    @Autowired
    InstituitionService instituitionService;


    @PostMapping
    public String addSection(@RequestBody SectionDto sectionDto) {
        instituitionService.addBranch(sectionDto.getSectionName(), sectionDto.getBranchId());
        return "Section Added";
    }

    @GetMapping
    public List<Section> getSections(@PathVariable int branchId) {
        return instituitionService.getSections(branchId);
    }
}
