package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorLoginResponse {
    private int instructorId;
    private int sectionId;
    private String email;
    private String firstName;
    private String lastName;
    private int relTenantInstitutionId;

    public InstructorLoginResponse(int instructorId, int sectionId, String firstName, String lastName, int relTenantInstitutionId) {
        this.instructorId = instructorId;
        this.sectionId = sectionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.relTenantInstitutionId = relTenantInstitutionId;
    }
}
