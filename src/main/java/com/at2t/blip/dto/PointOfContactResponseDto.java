package com.at2t.blip.dto;

public class PointOfContactResponseDto {
    private String primaryPOCLastName;
    private String primaryPOCEmail;
    private String primaryPOCPhoneNumber;
    private String primaryPOCFirstName;
    private String email;
    private int personId;
    private int institutionAdminId;
    private int loginCredentialId;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryPOCFirstName() {
        return primaryPOCFirstName;
    }

    public void setPrimaryPOCFirstName(String primaryPOCFirstName) {
        this.primaryPOCFirstName = primaryPOCFirstName;
    }

    private String secondaryPOCName;

    public PointOfContactResponseDto(String primaryPOCLastName, String primaryPOCEmail, String primaryPOCPhoneNumber, String primaryPOCFirstName, String email, String secondaryPOCName, String secondaryPOCEmail, String secondaryPOCPhoneNumber) {
        this.primaryPOCLastName = primaryPOCLastName;
        this.primaryPOCEmail = primaryPOCEmail;
        this.primaryPOCPhoneNumber = primaryPOCPhoneNumber;
        this.primaryPOCFirstName = primaryPOCFirstName;
        this.email = email;
        this.secondaryPOCName = secondaryPOCName;
        this.secondaryPOCEmail = secondaryPOCEmail;
        this.secondaryPOCPhoneNumber = secondaryPOCPhoneNumber;
    }

    public PointOfContactResponseDto() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getPrimaryPOCLastName() {
        return primaryPOCLastName;
    }

    public void setPrimaryPOCLastName(String primaryPOCLastName) {
        this.primaryPOCLastName = primaryPOCLastName;
    }

    public String getPrimaryPOCEmail() {
        return primaryPOCEmail;
    }

    public void setPrimaryPOCEmail(String primaryPOCEmail) {
        this.primaryPOCEmail = primaryPOCEmail;
    }

    public String getPrimaryPOCPhoneNumber() {
        return primaryPOCPhoneNumber;
    }

    public void setPrimaryPOCPhoneNumber(String primaryPOCPhoneNumber) {
        this.primaryPOCPhoneNumber = primaryPOCPhoneNumber;
    }

    public String getSecondaryPOCName() {
        return secondaryPOCName;
    }

    public void setSecondaryPOCName(String secondaryPOCName) {
        this.secondaryPOCName = secondaryPOCName;
    }

    public String getSecondaryPOCEmail() {
        return secondaryPOCEmail;
    }

    public void setSecondaryPOCEmail(String secondaryPOCEmail) {
        this.secondaryPOCEmail = secondaryPOCEmail;
    }

    public String getSecondaryPOCPhoneNumber() {
        return secondaryPOCPhoneNumber;
    }

    public void setSecondaryPOCPhoneNumber(String secondaryPOCPhoneNumber) {
        this.secondaryPOCPhoneNumber = secondaryPOCPhoneNumber;
    }

    private String secondaryPOCEmail;
    private String secondaryPOCPhoneNumber;

}
