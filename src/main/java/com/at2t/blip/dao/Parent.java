package com.at2t.blip.dao;

import javax.persistence.*;

import com.at2t.blip.dto.ParentResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Parent")
@SqlResultSetMapping(
		name="childMapping",
		classes={
				@ConstructorResult(
						targetClass= ParentResponseDto.class,
						columns={
								@ColumnResult(name="firstName"),
								@ColumnResult(name="lastName"),
								@ColumnResult(name="email"),
								@ColumnResult(name="PhoneNumber"),
								@ColumnResult(name="SecondaryParentname"),
								@ColumnResult(name="AdmissionId"),
								@ColumnResult(name="SecondaryPhoneNumber"),
								@ColumnResult(name="childrenName"),
								@ColumnResult(name="SectionId"),
								@ColumnResult(name="BranchId"),
								@ColumnResult(name="personId"),
								@ColumnResult(name="LoginCredentialId"),
								@ColumnResult(name="ParentId"),
								@ColumnResult(name="ChildId"),
						}
				)
		}
)
@NamedNativeQuery(name="Parent.getSingleParent", query="SELECT PR.firstName, PR.lastName, LC.email, LC.PhoneNumber, P.SecondaryParentname, C.AdmissionId, P.SecondaryPhoneNumber, C.childrenName, S.SectionId, S.BranchId,\n" +
		"PR.personId, LC.LoginCredentialId, P.ParentId, C.ChildId FROM Child C\n" +
		"JOIN Parent P ON P.parentId  = C.parentId\n" +
		"JOIN Person PR ON P.personId = PR.personId \n" +
		"JOIN LoginCredential LC ON LC.PersonId = PR.PersonId \n" +
		"JOIN Section S ON S.sectionId = C.sectionId\n" +
		"WHERE C.childId = :childId", resultSetMapping="childMapping")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParentId")
	private int parentId;

	@OneToOne
	@JoinColumn(name = "personId", referencedColumnName = "PersonId")
	private Person personId;

	@Column(name = "SecondaryPhoneNumber")
	private String secondaryPhoneNumber;

	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;

	@Column(name = "SecondaryParentName")
	private String secondaryParentName;

	public String getSecondaryParentName() {
		return secondaryParentName;
	}

	public void setSecondaryParentName(String secondaryParentName) {
		this.secondaryParentName = secondaryParentName;
	}

	public Parent() {
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}
}
