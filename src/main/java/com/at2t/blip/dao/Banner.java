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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Banner")
@Getter
@Setter
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

	@Column(name = "AuditCreatedBy")
	private Integer auditCreatedBy;

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


}
