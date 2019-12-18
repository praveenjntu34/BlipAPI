package com.at2t.blip.dto;

public class  BranchDto {

	private String branchName;

	private int relTenantInstitutionId;

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
