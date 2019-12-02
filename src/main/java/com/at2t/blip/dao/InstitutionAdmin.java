package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InstitutionAdmin")
public class InstitutionAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstitutionAdminId")
	int institutionAdminId;

	@ManyToOne
	@JoinColumn(name = "personId", referencedColumnName = "PersonId")
	@MapsId
	private Person person;

	@Column(name = "SecondaryPOCName")
	private String secondaryPOCName;

	@Column(name = "SecondaryPOCEmail")
	private String secondaryPOCEmail;

	@Column(name = "SecondaryPOCPhoneNumber")
	private String SecondaryPOCPhoneNumber;

	@OneToOne
	@JoinColumn(name = "relTenantInstitutionId", referencedColumnName = "RelTenantInstitutionId")
	@MapsId
	private RelTenantInstitution  relTenantInstitution;

	public int getInstitutionAdminId() {
		return institutionAdminId;
	}

	public Person getPerson() {
		return person;
	}

	public String getSecondaryPOCName() {
		return secondaryPOCName;
	}

	public String getSecondaryPOCEmail() {
		return secondaryPOCEmail;
	}

	public String getSecondaryPOCPhoneNumber() {
		return SecondaryPOCPhoneNumber;
	}

	
	public void setInstitutionAdminId(int institutionAdminId) {
		this.institutionAdminId = institutionAdminId;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setSecondaryPOCName(String secondaryPOCName) {
		this.secondaryPOCName = secondaryPOCName;
	}

	public void setSecondaryPOCEmail(String secondaryPOCEmail) {
		this.secondaryPOCEmail = secondaryPOCEmail;
	}

	public void setSecondaryPOCPhoneNumber(String secondaryPOCPhoneNumber) {
		SecondaryPOCPhoneNumber = secondaryPOCPhoneNumber;
	}

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}


}
