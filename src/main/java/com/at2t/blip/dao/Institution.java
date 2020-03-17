package com.at2t.blip.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "Institution")
public class Institution {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "InstitutionId")
	private int institutionId;

	@Column(name = "InstitutionName")
	private String institutionName;

	@Column(name = "Email")
	private String email;

	public InstitutionDisplayPicture getInstitutionDisplayPicture() {
		return institutionDisplayPicture;
	}

	public void setInstitutionDisplayPicture(InstitutionDisplayPicture institutionDisplayPicture) {
		this.institutionDisplayPicture = institutionDisplayPicture;
	}

	@Column(name = "Website")
	private String website;

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}

	@OneToOne(mappedBy="institution")
	@JsonBackReference
	private RelTenantInstitution relTenantInstitution;

	@OneToOne
	@JoinColumn(name = "PictureId")
	@JsonManagedReference
	private InstitutionDisplayPicture institutionDisplayPicture;

	@Column(name = "Status")
	private Boolean status;

	@Column(name = "Remarks")
	private String remarks;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Institution() {
	}
}
