package com.at2t.blip.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentRequestDto {
    private int parentId;
    private int childId;
    private int personId;
    private int loginCredentialId;
    @JsonProperty("parentOneFirstName")
    private String parentOneFirstName;
    @JsonProperty("parentOneLastName")
    private String parentOneLastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("admissionNumber")
    private String admissionNumber;
    @JsonProperty("secondaryPhoneNumber")
    private String secondaryPhoneNumber;
    @JsonProperty("sectionId")
    private int sectionId;
    @JsonProperty("relTenantInstitutionId")
    private int relTenantInstitutionId;
    @JsonProperty("childrenName")
    private String childrenName;
    @JsonProperty("secondaryParentName")
    private String secondaryParentName;
    @JsonProperty("DOB")
    private String DOB;

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSecondaryParentName() {
        return secondaryParentName;
    }

    public void setSecondaryParentName(String secondaryParentName) {
        this.secondaryParentName = secondaryParentName;
    }

    public ParentRequestDto() {
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getLoginCredentialId() {
        return loginCredentialId;
    }

    public void setLoginCredentialId(int loginCredentialId) {
        this.loginCredentialId = loginCredentialId;
    }

    public String getParentOneFirstName() {
        return parentOneFirstName;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public void setParentOneFirstName(String parentOneFirstName) {
        this.parentOneFirstName = parentOneFirstName;
    }

    public String getParentOneLastName() {
        return parentOneLastName;
    }

    public void setParentOneLastName(String parentOneLastName) {
        this.parentOneLastName = parentOneLastName;
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

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
}