package com.at2t.blip.dto;

import java.sql.Timestamp;
import java.util.Date;

public class PersonDto {

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private char gender;

	private String photoStreamId;

	private int personTypeId;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public String getPhotoStreamId() {
		return photoStreamId;
	}



	public int getPersonTypeId() {
		return personTypeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setPhotoStreamId(String photoStreamId) {
		this.photoStreamId = photoStreamId;
	}


	public void setPersonTypeId(int personTypeId) {
		this.personTypeId = personTypeId;
	}

}
