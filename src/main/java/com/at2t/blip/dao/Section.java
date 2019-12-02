package com.at2t.blip.dao;

import javax.persistence.*;

@Entity
@Table(name = "Section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SectionId")
	private int sectionId;

	@OneToOne
	@JoinColumn(name = "BranchId", referencedColumnName = "BranchId")
	@MapsId
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
