package com.at2t.blip.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RelTenantInstitution")
public class RelTenantInstitution {

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;

	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="InstitutionId", referencedColumnName="InstitutionId")
    private Institution institution;

	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="TenantId", referencedColumnName="TenantId")
    private Tenant tenant;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="InstitutionTypeId", referencedColumnName="InstitutionTypeId")
    private InstitutionType institutionType;

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

	public InstitutionType getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}
	

}
