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


	private int relTenantInstitutionId;

	public Branch() {
	}

	private String branchName;

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public String getBranchName() {
		return branchName;
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
