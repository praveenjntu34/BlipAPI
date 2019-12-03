package com.at2t.blip.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchId", referencedColumnName = "BranchId")
	@MapsId
	@JsonIgnore
	private Branch branch;
	
	@Column(name = "SectionName")
	private String sectionName;

	public int getSectionId() {
		return sectionId;
	}

	public Branch getBranch() {
		return branch;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
