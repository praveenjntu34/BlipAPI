package com.at2t.blip.dao;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BranchId")
	private int branchsId;

	@OneToOne
	@JoinColumn(name = "relTenantInstitutionId", referencedColumnName = "RelTenantInstitutionId")
	@MapsId
	private RelTenantInstitution relTenantInstitution;

	private String branchName;

	public int getBranchsId() {
		return branchsId;
	}

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchsId(int branchsId) {
		this.branchsId = branchsId;
	}

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
