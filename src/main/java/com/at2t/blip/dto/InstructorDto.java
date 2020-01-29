package com.at2t.blip.dto;

public class InstructorDto {

	private int instructorId;
	private String firstname;
	private String lastname;
	private String email;
	private int personId;
	private String designation;
	private String phoneNumber;
	private int sectionId;
	private int relTenantInstitutionId;



	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getInstructorId() {
		return instructorId;
	}

	public int getSectionId() {
		return sectionId;
	}
	public int getPersonId() {
		return personId;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

}
