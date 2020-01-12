package com.at2t.blip.controller;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution/branch")
@Api(value = "blip")
public class BranchController {
    @Autowired
    InstituitionService instituitionService;


    @PostMapping
    public Object addBranch(@RequestBody BranchDto branchDto) {
        instituitionService.addBranch(branchDto);

        Object object = new Object() {
            public String response = "Branch Added";
        };
        return object;

    }

    @GetMapping
    public List<Branch> getBranches(@PathVariable int relTenantInstitutionId) {

        return instituitionService.getBranch(relTenantInstitutionId);
    }
}
