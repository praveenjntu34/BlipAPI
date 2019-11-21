package com.at2t.blip.dao;

import javax.persistence.*;

@Entity
@Table(name = "RelTenantInstitution")
public class RelTenantInstitution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;


	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@OneToOne
	@JoinColumn(name = "InstitutionId", referencedColumnName = "InstitutionId")
	@MapsId
	private Institution institution;

	@OneToOne
	@JoinColumn(name = "TenantId")
	@MapsId
	private Tenant tenant;

	@OneToOne
	@JoinColumn(name = "AddressId")
	@MapsId
	private Address address;

	@Column(name = "InstitutionTypeId")
	private int institutionTypeID;

	public int getInstitutionTypeID() {
		return institutionTypeID;
	}

	public void setInstitutionTypeID(int institutionTypeID) {
		this.institutionTypeID = institutionTypeID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public RelTenantInstitution() {
	}

	public RelTenantInstitution(Institution institution, Tenant tenant, int institutionTypeID, Address address) {
		this.institution = institution;
		this.tenant = tenant;
		this.institutionTypeID = institutionTypeID;
		this.address = address;
	}

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}


	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}


}
