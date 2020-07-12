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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Instructor")
@Getter
@Setter
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

	@Column(name="Enabled")
	private Boolean enabled;

	@Column(name="Image")
	private String image;


}
