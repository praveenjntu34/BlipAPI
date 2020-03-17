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

	@Column
	private int relTenantInstitutionId;

	@Column(name = "Title")
	private String title;

	@Column(name = "BannerStream")
	private byte[] bannerStream;

	@Column(name = "SecondaryBanner")
	private byte[] secondaryBanner;

	@Column(name = "ShortDescription")
	private String shortDescription;

	public Banner() {
	}

	public Banner(byte[] bannerStream) {
		this.bannerStream = bannerStream;
	}

	public Banner(int relTenantInstitutionId, String title, String shortDescription) {
		this.relTenantInstitutionId = relTenantInstitutionId;
		this.title = title;
		this.shortDescription = shortDescription;
	}

	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getBannerStream() {
		return bannerStream;
	}

	public void setBannerStream(byte[] bannerStream) {
		this.bannerStream = bannerStream;
	}

	public byte[] getSecondaryBanner() {
		return secondaryBanner;
	}

	public void setSecondaryBanner(byte[] secondaryBanner) {
		this.secondaryBanner = secondaryBanner;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}
