package com.at2t.blip.dto;

import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.Section;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class InstructorResponseDto {


    private int instructorId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String designation;
    private int relTenantInstitutionId;
    private int sectionId;
    private int personId;
    private int loginCredentialId;
    private int branchId;
    private Boolean enabled;
    private String image;


    public InstructorResponseDto(int instructorId, String designation, String firstName,
                                 String lastName, String email, String phoneNumber,
                                 int relTenantInstitutionId, int sectionId,
                                 int loginCredentialId, int personId, int branchId, Boolean enabled, String image) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.sectionId = sectionId;
        this.loginCredentialId = loginCredentialId;
        this.personId = personId;
        this.branchId = branchId;
        this.enabled = enabled;
        this.image = image;
    }

    public InstructorResponseDto(int instructorId, String designation, String firstName,
                                 String lastName, String email, String phoneNumber,
                                 int relTenantInstitutionId, int sectionId,
                                 int loginCredentialId, int personId, int branchId, Boolean enabled) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.sectionId = sectionId;
        this.loginCredentialId = loginCredentialId;
        this.personId = personId;
        this.branchId = branchId;
        this.enabled = enabled;
    }
}
