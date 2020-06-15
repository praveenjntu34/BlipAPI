package com.at2t.blip.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "TenantId")
	private int tenantId;

	@Column(name = "TenantName")
	private String tenantName;

	public Tenant(String tenantName) {
		this.tenantName = tenantName;
	}

	public Tenant() {
	}

	@OneToOne(mappedBy = "tenant")
	private RelTenantInstitution relTenantInstitution;

	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}

	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}

	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	
}
