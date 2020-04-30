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
