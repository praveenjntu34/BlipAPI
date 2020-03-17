package com.at2t.blip.dto;

public class ParentRequestDto {
    private String parentOneFirstName;
    private String parentOneLastName;
    private String email;
    private String phoneNumber;
    private String parentTwoName;
    private String admissionNumber;
    private String secondaryPhoneNumber;
    private int sectionId;
    private int relTenantInstitutionId;
    private String childrenName;

    public ParentRequestDto() {
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

    public String getParentTwoName() {
        return parentTwoName;
    }

    public void setParentTwoName(String parentTwoName) {
        this.parentTwoName = parentTwoName;
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