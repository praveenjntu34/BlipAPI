package com.at2t.blip.dao;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId")
	private int postId;

	@Column(name = "Title")
	private String title;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SectionId", referencedColumnName = "SectionId")
	@JsonIgnore
	private Section section;

	@Column(name = "PostText")
	private String postText;

	@Column(name = "RelTenantInstitutionId")
	private int relTenantInstitutionId;

	@Lob
	@Column(name = "AttachmentStreamId")
	private byte[] AttachmentStreamId;


	@Column(name = "AuditCreatedBy")
	private int auditCreatedBy;


	public Post() {
	}

	public byte[] getAttachmentStreamId() {
		return AttachmentStreamId;
	}

	public void setAttachmentStreamId(byte[] attachmentStreamId) {
		AttachmentStreamId = attachmentStreamId;
	}

	@Column(name = "AuditCreatedDate")
	private Timestamp auditCreatedDate;

	@Column(name = "AuditModifiedBy")
	int auditModifiedBy;

	@Column(name = "AuditModifiedDate")
	Timestamp auditModifiedDate;

	public Post(String title, Section section, String postText, int relTenantInstitutionId) {
		this.title = title;
		this.section = section;
		this.postText = postText;
		this.relTenantInstitutionId = relTenantInstitutionId;
	}

	public Post(byte[] attachmentStreamId) {
		AttachmentStreamId = attachmentStreamId;
	}

	public int getPostId() {
		return postId;
	}

	public Section getSection() {
		return section;
	}

	public String getPostText() {
		return postText;
	}


	public int getAuditCreatedBy() {
		return auditCreatedBy;
	}

	public Timestamp getAuditCreatedDate() {
		return auditCreatedDate;
	}

	public int getAuditModifiedBy() {
		return auditModifiedBy;
	}

	public Timestamp getAuditModifiedDate() {
		return auditModifiedDate;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}


	public void setSection(Section section) {
		this.section = section;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}


	public void setAuditCreatedBy(int auditCreatedBy) {
		this.auditCreatedBy = auditCreatedBy;
	}

	public void setAuditCreatedDate(Timestamp auditCreatedDate) {
		this.auditCreatedDate = auditCreatedDate;
	}

	public void setAuditModifiedBy(int auditModifiedBy) {
		this.auditModifiedBy = auditModifiedBy;
	}

	public void setAuditModifiedDate(Timestamp auditModifiedDate) {
		this.auditModifiedDate = auditModifiedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
