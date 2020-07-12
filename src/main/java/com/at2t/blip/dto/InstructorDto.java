package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorDto {

	private int instructorId;
	private String firstname;
	private String lastname;
	private String email;
	private int personId;
	private String designation;
	private String phoneNumber;
	private int loginCredentialId;
	private Boolean enabled;
	private int sectionId;
	private String image;
	private int relTenantInstitutionId;

}
