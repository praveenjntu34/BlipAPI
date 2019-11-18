package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressId")
	private int addressId;
	
	@Column(name = "Address1")
	private String address1;
	
	@Column(name = "Address2")
	private String address2;

	@Column(name = "CityId")
	private int cityId;

	@Column(name = "StateId")
	private int stateId;

	@Column(name = "CountryId")
	private int countryId;

	@Column(name = "Pincode")
	private String pincode;

	public int getAddressId() {
		return addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public int getCityId() {
		return cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
