package com.at2t.blip.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
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

	@Column(name = "Website")
	private String website;

	@OneToOne(mappedBy="institution")
	private RelTenantInstitution relTenantInstitution;

	@OneToOne
	@JoinColumn(name = "PictureId")
	@JsonManagedReference
	private InstitutionDisplayPicture institutionDisplayPicture;

	@Column(name = "Status")
	private Boolean status;

	@Column(name = "Remark1")
	private String remark1;

	@Column(name = "Remark2")
	private String remark2;

	@Column(name = "Remark3")
	private String remark3;

	@Column(name = "Remark4")
	private String remark4;

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}

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

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public InstitutionDisplayPicture getInstitutionDisplayPicture() {
		return institutionDisplayPicture;
	}

	public void setInstitutionDisplayPicture(InstitutionDisplayPicture institutionDisplayPicture) {
		this.institutionDisplayPicture = institutionDisplayPicture;
	}
	public Institution() {
	}
}
