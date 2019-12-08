package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParentId")
	private int parentId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personId", referencedColumnName = "PersonId")
	@MapsId
	@JsonIgnore
	private Person personId;

	@Column(name = "SecondaryPhoneNumber")
	private String secondaryPhoneNumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "relTenantInstitutionId", referencedColumnName = "RelTenantInstitutionId")
	@MapsId
	@JsonIgnore
	private RelTenantInstitution relTenantInstitutionId;

	public int getParentId() {
		return parentId;
	}

	public Person getPersonId() {
		return personId;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public RelTenantInstitution getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}

	public void setRelTenantInstitutionId(RelTenantInstitution relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

}
