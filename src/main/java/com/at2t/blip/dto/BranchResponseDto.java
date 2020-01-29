package com.at2t.blip.dto;

import com.at2t.blip.dao.Section;

import java.util.List;

public class BranchResponseDto {
    private int branchId;
    private String branchName;
    private int relTenantInstitutionId;
    private List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public BranchResponseDto() {
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public BranchResponseDto(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public BranchResponseDto(int branchId,int relTenantInstitutionId, String branchName, List<Section> sections) {
        this.branchId = branchId;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.branchName = branchName;
        this.sections = sections;
    }
}
