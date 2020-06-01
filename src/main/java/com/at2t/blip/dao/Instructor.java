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
	@OneToOne
	private Person person;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;

	@JoinColumn(name = "sectionId", referencedColumnName = "SectionId")
	@OneToOne
	private Section section;

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}
	public int getInstructorId() {
		return instructorId;
	}

	public Person getPerson() {
		return person;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
