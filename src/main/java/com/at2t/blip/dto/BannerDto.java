package com.at2t.blip.dto;

public class BannerDto {

	private int bannerId;
	
	private int relTenantInstitutionId;

	private String BannerName;

	private String bannerStreamId;

	public int getRelTenantInstitutionId() {
		return relTenantInstitutionId;
	}

	public String getBannerName() {
		return BannerName;
	}

	public String getBannerStreamId() {
		return bannerStreamId;
	}

	public void setRelTenantInstitutionId(int relTenantInstitutionId) {
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public void setBannerName(String bannerName) {
		BannerName = bannerName;
	}

	public void setBannerStreamId(String bannerStreamId) {
		this.bannerStreamId = bannerStreamId;
	}

	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

}
