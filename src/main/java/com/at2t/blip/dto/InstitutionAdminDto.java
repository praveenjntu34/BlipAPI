package com.at2t.blip.dto;

import com.at2t.blip.dao.Person;

public class InstitutionAdminDto {

	private String secondaryPOCName;
	private int relInstitutionId;
	private int personId;
	private int institutionAdminId;
	private int loginCredentialId;
	private String secondaryPOCEmail;

	private String SecondaryPOCPhoneNumber;
	
	private PersonDto personDto;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getSecondaryPOCName() {
		return secondaryPOCName;
	}

	public int getRelInstitutionId() {
		return relInstitutionId;
	}

	public void setSecondaryPOCName(String secondaryPOCName) {
		this.secondaryPOCName = secondaryPOCName;
	}

	public void setRelInstitutionId(int relInstitutionId) {
		this.relInstitutionId = relInstitutionId;
	}

	public String getSecondaryPOCEmail() {
		return secondaryPOCEmail;
	}

	public String getSecondaryPOCPhoneNumber() {
		return SecondaryPOCPhoneNumber;
	}

	public void setSecondaryPOCEmail(String secondaryPOCEmail) {
		this.secondaryPOCEmail = secondaryPOCEmail;
	}

	public void setSecondaryPOCPhoneNumber(String secondaryPOCPhoneNumber) {
		SecondaryPOCPhoneNumber = secondaryPOCPhoneNumber;
	}

	public int getInstitutionAdminId() {
		return institutionAdminId;
	}

	public void setInstitutionAdminId(int institutionAdminId) {
		this.institutionAdminId = institutionAdminId;
	}

	public int getLoginCredentialId() {
		return loginCredentialId;
	}

	public void setLoginCredentialId(int loginCredentialId) {
		this.loginCredentialId = loginCredentialId;
	}

	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	@Override
	public String toString() {
		return "InstitutionAdminDto{" +
				"secondaryPOCName='" + secondaryPOCName + '\'' +
				", relInstitutionId=" + relInstitutionId +
				", personId=" + personId +
				", secondaryPOCEmail='" + secondaryPOCEmail + '\'' +
				", SecondaryPOCPhoneNumber='" + SecondaryPOCPhoneNumber + '\'' +
				", personDto=" + personDto +
				'}';
	}
}
