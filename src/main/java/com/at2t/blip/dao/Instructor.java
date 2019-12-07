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
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	private Person personId;

	@JoinColumn(name = "sectionId", referencedColumnName = "SectionId")
	@MapsId
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	private Section sectionId;

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

}
