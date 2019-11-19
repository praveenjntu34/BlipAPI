package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CountryId")
	private int countryId;
	@Column(name = "CountryName")
	private String countryName;
	@Column(name = "CountryCode")
	private String countryCode;
	@Column(name = "CountryAlphaCode")
	private String countryAlphaCode;

	public int getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryAlphaCode() {
		return countryAlphaCode;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCountryAlphaCode(String countryAlphaCode) {
		this.countryAlphaCode = countryAlphaCode;
	}

}
