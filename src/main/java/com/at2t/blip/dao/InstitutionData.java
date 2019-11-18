package com.at2t.blip.dao;

public class InstitutionData {

	RelTenantInstitution relTenantInstitution;
	Address address;
	public RelTenantInstitution getRelTenantInstitution() {
		return relTenantInstitution;
	}
	public Address getAddress() {
		return address;
	}
	public void setRelTenantInstitution(RelTenantInstitution relTenantInstitution) {
		this.relTenantInstitution = relTenantInstitution;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
