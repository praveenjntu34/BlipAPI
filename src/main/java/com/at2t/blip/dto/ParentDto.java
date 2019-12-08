package com.at2t.blip.dto;

public class ParentDto {

	private int parentId;

	private int personId;

	private String secondaryPhoneNumber;

	private int relTenantInstitutionId;

	public int getParentId() {
		return parentId;
	}

	public int getPersonId() {
		return personId;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

}
