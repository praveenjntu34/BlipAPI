package com.at2t.blip.dao;

import javax.persistence.*;

@Entity
@Table(name = "InstitutionType")
public class InstitutionType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstitutionTypeId")
	private int institutionTypeId;
	@Column(name = "InstitutionTypeName")
	private String institutionTypeName;
	
	public int getInstitutionTypeId() {
		return institutionTypeId;
	}

	public String getInstitutionTypeName() {
		return institutionTypeName;
	}

	public void setInstitutionTypeId(int institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}

	public void setInstitutionTypeName(String institutionTypeName) {
		this.institutionTypeName = institutionTypeName;
	}

	

}
