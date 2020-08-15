package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentProfileDto {
    private int parentId;
    private int sectionId;
    private int relTenantInstitutionId;
    private String firstName;
    private String lastName;
    private String SecondaryPhoneNumber;
    private String SecondaryParentName;
    private String ChildrenName;
    private String AdmissionId;
    private String email;
    private String phoneNumber;
    private int childId;
    private int personId;

    public ParentProfileDto() {
    }

    public ParentProfileDto(int parentId, int sectionId, int relTenantInstitutionId, String firstName,
                            String lastName, String secondaryPhoneNumber, String secondaryParentName,
                            String childrenName, String admissionId, String email, String phoneNumber, int childId, int personId) {
        this.parentId = parentId;
        this.sectionId = sectionId;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.firstName = firstName;
        this.lastName = lastName;
        SecondaryPhoneNumber = secondaryPhoneNumber;
        SecondaryParentName = secondaryParentName;
        ChildrenName = childrenName;
        AdmissionId = admissionId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.childId = childId;
        this.personId = personId;

    }
}
