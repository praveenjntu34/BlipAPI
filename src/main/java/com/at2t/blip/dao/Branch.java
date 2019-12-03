package com.at2t.blip.dao;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Branch")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BranchId")
	private int branchId;

	@OneToOne
	@JoinColumn(name = "relTenantInstitutionId", referencedColumnName = "RelTenantInstitutionId")
	@MapsId
	@JsonIgnore
	private RelTenantInstitution relTenantInstitution;

	private String branchName;

	

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public String getBranchName() {
		return branchName;
	}

	

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

}
