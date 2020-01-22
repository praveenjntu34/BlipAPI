package com.at2t.blip.controller;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dao.Institution;
import com.at2t.blip.dao.RelTenantInstitution;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.BranchDto;
import com.at2t.blip.dto.BranchResponseDto;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.service.InstituitionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "blip")
public class BranchController {
    @Autowired
    InstituitionService instituitionService;


    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/institution/branch")
    public Object addBranch(@RequestBody BranchDto branchDto) {


        int response = instituitionService.addBranch(branchDto);
        Object object = new Object() {
            public int branchId = response;
            public String branchName = branchDto.getBranchName();
        };
        return object;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/institution/branch/{relTenantInstitutionId}")
    public List<BranchResponseDto> getBranches(@PathVariable int relTenantInstitutionId) {

        List<Branch> branches = instituitionService.getBranch(relTenantInstitutionId);
        List<BranchResponseDto> responseDto = new ArrayList<BranchResponseDto>();

        for(Branch branch : branches) {
            List<Section> sections = instituitionService.getSections(branch.getBranchId());
            BranchResponseDto dto = new BranchResponseDto(branch.getBranchId(), branch.getBranchName(), sections);
            responseDto.add(dto);
        }

        return responseDto;

    }

    private Branch convertToBranchEntity(BranchDto branchDto) {

//        Branch branch = modelMapper.map(branchDto, Branch.class);
        Branch branch = new Branch();
        branch.setBranchName(branchDto.getBranchName());
        return branch;
    }
}
