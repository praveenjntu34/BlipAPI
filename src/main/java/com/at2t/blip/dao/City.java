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
@Table(name = "City")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CityId")
	private int cityId;
	@Column(name = "CityName")
	private String cityName;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "StateId", referencedColumnName = "StateId")
	private State state;

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public State getState() {
		return state;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setState(State state) {
		this.state = state;
	}

}
