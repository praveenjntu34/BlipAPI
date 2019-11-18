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
@Table(name = "RelTenantInstitutionAddress")
public class RelTenantInstitutionAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RelTenantInstitutionAddress")
	private int relTenantInstitutionAddress;

	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="AddressId", referencedColumnName="AddressId")
    private Address address;

	public int getRelTenantInstitutionAddress() {
		return relTenantInstitutionAddress;
	}

	public void setRelTenantInstitutionAddress(int relTenantInstitutionAddress) {
		this.relTenantInstitutionAddress = relTenantInstitutionAddress;
	}

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
