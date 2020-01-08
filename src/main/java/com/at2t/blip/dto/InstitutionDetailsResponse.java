package com.at2t.blip.dto;

public class InstitutionDetailsResponse {
    private int institutionId;
    private int relTenantInstitutionId;

    public InstitutionDetailsResponse(int institutionId, int relTenantInstitutionId, Boolean status, String institutionName) {
        this.institutionId = institutionId;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.status = status;
        this.institutionName = institutionName;
    }

    private Boolean status;
    private String institutionName;

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
