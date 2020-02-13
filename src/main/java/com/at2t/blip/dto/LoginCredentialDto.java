package com.at2t.blip.dto;

public class LoginCredentialDto {

	private String email;

	private String PhoneNumber;

	private String Passcode;

	private String PasswordHash;

	private String PasswordSalt;

	private int personId;

	private int loginCredentialId;

	public int getLoginCredentialId() {
		return loginCredentialId;
	}

	public void setLoginCredentialId(int loginCredentialId) {
		this.loginCredentialId = loginCredentialId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getPasscode() {
		return Passcode;
	}

	public void setPasscode(String passcode) {
		Passcode = passcode;
	}

	public String getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}

	public String getPasswordSalt() {
		return PasswordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		PasswordSalt = passwordSalt;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

}
