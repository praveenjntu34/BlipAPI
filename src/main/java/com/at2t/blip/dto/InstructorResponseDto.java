package com.at2t.blip.dto;

import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.Section;

import javax.persistence.*;

public class InstructorResponseDto {


    private int instructorId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String designation;
    private int relTenantInstitutionId;
    private int sectionId;

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public InstructorResponseDto(int instructorId, String designation, String firstName, String lastName, String email, String phoneNumber, int relTenantInstitutionId, int sectionId) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.sectionId = sectionId;
    }
}
