package com.at2t.blip.dto;

public class BranchResponseDto {
    private int branchId;
    private String branchName;
    private int relTenantInstitutionId;

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

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public BranchResponseDto(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }
}
