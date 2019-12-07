package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Banner")
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BannerId")
	private int bannerId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "relTenantInstitutionId", referencedColumnName = "RelTenantInstitutionId")
	@MapsId
	@JsonIgnore
	private RelTenantInstitution relTenantInstitutionId;

	@Column(name = "BannerName")
	private String BannerName;

	@Column(name = "BannerStreamId")
	private String bannerStreamId;

	public int getBannerId() {
		return bannerId;
	}

	public RelTenantInstitution getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public String getBannerName() {
		return BannerName;
	}

	public String getBannerStreamId() {
		return bannerStreamId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public void setRelTenantInstitutionId(RelTenantInstitution relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public void setBannerName(String bannerName) {
		BannerName = bannerName;
	}

	public void setBannerStreamId(String bannerStreamId) {
		this.bannerStreamId = bannerStreamId;
	}

}
