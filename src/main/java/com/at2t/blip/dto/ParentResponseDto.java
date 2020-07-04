package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ColumnResult;
import javax.persistence.NamedNativeQuery;

@Getter
@Setter
public class ParentResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String  childrenName;
    private int  sectionId;
    private int branchId;
    private String secondaryParentName;
    private String AdmissionId;
    private String secondaryPhoneNUmber;
    private int childId;
    private int personId;
    private int loginCredentialId;
    private int parentId;
//
//    @NamedNativeQuery(name="Parent.getSingleParent", query="SELECT PR.firstName, PR.lastName, LC.email, LC.PhoneNumber, " +
//            "P.SecondaryParentname, C.AdmissionId, P.SecondaryPhoneNumber, C.childrenName, S.SectionId, S.BranchId,\n" +
//            "S.sectionId, PR.personId, LC.LoginCredentialId, P.ParentId, C.ChildId FROM Child C\n" +

    public ParentResponseDto(String firstName, String lastName, String email, String phoneNumber, String secondaryParentName, String AdmissionId, String SecondaryPhoneNUmber,
                             String childrenName, int sectionId, int BranchId, int personId, int loginCredentialId, int parentId, int childId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.secondaryParentName = secondaryParentName;
        this.AdmissionId = AdmissionId;
        this.branchId = BranchId;
        this.secondaryPhoneNUmber = SecondaryPhoneNUmber;
        this.sectionId = sectionId;
        this.childrenName = childrenName;
        this.personId = personId;
        this.loginCredentialId = loginCredentialId;
        this.parentId = parentId;
        this.childId = childId;
    }

    public ParentResponseDto(int childId, String firstName, String lastName, String email, String phoneNumber, int personId, int loginCredentialId, int parentId) {
        this.firstName = firstName;
        this.childId = childId;
        this.personId = personId;
        this.loginCredentialId =loginCredentialId;
        this.parentId =parentId;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ParentResponseDto(int childId, String firstName, String lastName, String email, String phoneNumber, int personId, int loginCredentialId, int parentId, String secondaryParentName, String secondaryPhoneNumber, String AdmissionId) {
        this.firstName = firstName;
        this.childId = childId;
        this.personId = personId;
        this.loginCredentialId =loginCredentialId;
        this.parentId =parentId;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.secondaryParentName = secondaryParentName;
        this.secondaryPhoneNUmber = secondaryPhoneNumber;
        this.email = email;
        this.AdmissionId = AdmissionId;
    }
}
