package com.at2t.blip.dto;

public class LoginDetailsDto {
    private String email;

    private String phoneNumber;

    private int personId;

    private String firstName;

    private String lastName;

    private int personTypeId;

    private String PersonTypeName;

    public LoginDetailsDto(String email, String phoneNumber, int personId, String firstName, String lastName, int personTypeId, String personTypeName) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personTypeId = personTypeId;
        PersonTypeName = personTypeName;
    }

    public LoginDetailsDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(int personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getPersonTypeName() {
        return PersonTypeName;
    }

    public void setPersonTypeName(String personTypeName) {
        PersonTypeName = personTypeName;
    }
}
