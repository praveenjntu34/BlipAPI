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
@Table(name = "State")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StateId")
	private int stateId;
	@Column(name = "StateName")
	private String stateName;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "countryId", referencedColumnName = "countryId")
	private Country country;

	public int getStateId() {
		return stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
