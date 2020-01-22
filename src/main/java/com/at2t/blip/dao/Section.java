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
@Table(name = "Section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SectionId")
	private int sectionId;

	@Column(name = "BranchId")
	private int branchId;
	
	@Column(name = "SectionName")
	private String sectionName;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
