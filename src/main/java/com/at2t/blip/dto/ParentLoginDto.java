package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentLoginDto {
    private int parentId;
    private int sectionId;
    private int relTenantInstitutionId;
    private String firstName;
    private String lastName;
    private String role;

    public ParentLoginDto(int parentId, int sectionId, int relTenantInstitutionId, String firstName, String lastName, String role) {
        this.parentId = parentId;
        this.sectionId = sectionId;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
