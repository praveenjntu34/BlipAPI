package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstructorId")
	private int instructorId;

	@JoinColumn(name = "personId", referencedColumnName = "PersonId")
	@MapsId
	@OneToOne(fetch = FetchType.EAGER)
	private Person personId;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;


	@JoinColumn(name = "sectionId", referencedColumnName = "SectionId")
	@MapsId
	@OneToOne(fetch = FetchType.EAGER)
	private Section sectionId;



	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}
	public int getInstructorId() {
		return instructorId;
	}

	public Person getPersonId() {
		return personId;
	}

	public Section getSectionId() {
		return sectionId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	public void setSectionId(Section sectionId) {
		this.sectionId = sectionId;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
