package com.at2t.blip.controller;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dao.Institution;
import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution/branch")
@Api(value = "blip")
public class BranchController {
    @Autowired
    InstituitionService instituitionService;


    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public Object addBranch(@RequestBody BranchDto branchDto) {


        int response = instituitionService.addBranch(branchDto);
        Object object = new Object() {
            public int branchId = response;
            public String branchName = branchDto.getBranchName();
        };
        return object;

    }

    @GetMapping
    public List<Branch> getBranches(@PathVariable int relTenantInstitutionId) {

        return instituitionService.getBranch(relTenantInstitutionId);

    }

    private Branch convertToBranchEntity(BranchDto branchDto) {

//        Branch branch = modelMapper.map(branchDto, Branch.class);
        Branch branch = new Branch();
        branch.setBranchName(branchDto.getBranchName());
        return branch;
    }
}
