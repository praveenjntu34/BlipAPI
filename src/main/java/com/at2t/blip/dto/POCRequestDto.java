package com.at2t.blip.dto;

public class POCRequestDto {
    private String primaryPOCFirstName;
    private String primaryPOCLastName;
    private String primaryPOCPhoneNumber;
    private String primaryPOCEmail;
    private String secondaryPOCFirstName;
    private String secondaryPOCLastName;
    private String secondaryPOCPhoneNumber;
    private String secondaryPOCEmail;
    private int personId;
    private int institutionAdminId;
    private int loginCredentialId;

    public String getPrimaryPOCFirstName() {
        return primaryPOCFirstName;
    }

    public void setPrimaryPOCFirstName(String primaryPOCFirstName) {
        this.primaryPOCFirstName = primaryPOCFirstName;
    }

    public String getPrimaryPOCLastName() {
        return primaryPOCLastName;
    }

    public void setPrimaryPOCLastName(String primaryPOCLastName) {
        this.primaryPOCLastName = primaryPOCLastName;
    }

    public String getPrimaryPOCPhoneNumber() {
        return primaryPOCPhoneNumber;
    }

    public void setPrimaryPOCPhoneNumber(String primaryPOCPhoneNumber) {
        this.primaryPOCPhoneNumber = primaryPOCPhoneNumber;
    }

    public String getPrimaryPOCEmail() {
        return primaryPOCEmail;
    }

    public void setPrimaryPOCEmail(String primaryPOCEmail) {
        this.primaryPOCEmail = primaryPOCEmail;
    }

    public String getSecondaryPOCFirstName() {
        return secondaryPOCFirstName;
    }

    public void setSecondaryPOCFirstName(String secondaryPOCFirstName) {
        this.secondaryPOCFirstName = secondaryPOCFirstName;
    }

    public String getSecondaryPOCLastName() {
        return secondaryPOCLastName;
    }

    public void setSecondaryPOCLastName(String secondaryPOCLastName) {
        this.secondaryPOCLastName = secondaryPOCLastName;
    }

    public String getSecondaryPOCPhoneNumber() {
        return secondaryPOCPhoneNumber;
    }

    public void setSecondaryPOCPhoneNumber(String secondaryPOCPhoneNumber) {
        this.secondaryPOCPhoneNumber = secondaryPOCPhoneNumber;
    }

    public String getSecondaryPOCEmail() {
        return secondaryPOCEmail;
    }

    public void setSecondaryPOCEmail(String secondaryPOCEmail) {
        this.secondaryPOCEmail = secondaryPOCEmail;
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
}
