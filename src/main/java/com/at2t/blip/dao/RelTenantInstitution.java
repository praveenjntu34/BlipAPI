package com.at2t.blip.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RelTenantInstitution")
public class RelTenantInstitution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "InstitutionId", referencedColumnName = "InstitutionId")
	private Institution institution;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TenantId", referencedColumnName = "TenantId")
	private Tenant tenant;

	@Column(name = "InstitutionTypeId")
	private int institutionTypeId;

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public int getInstitutionTypeId() {
		return institutionTypeId;
	}

	public void setInstitutionTypeId(int institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}
}
