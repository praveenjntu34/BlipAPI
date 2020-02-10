package com.at2t.blip.dao;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId")
	private int postId;

	@Column(name = "PostTypeId")
	private int postTypeId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SectionId", referencedColumnName = "SectionId")
	@MapsId
	@JsonIgnore
	private Section section;

	@Column(name = "PostText")
	private String postText;


	@Lob
	@Column(name = "AttachmentStreamId")
	private byte[] AttachmentStreamId;


	@Column(name = "AuditCreatedBy")
	private int auditCreatedBy;



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

	public Post(int postTypeId, Section section, String postText, byte[] attachmentStreamId) {
		this.postTypeId = postTypeId;
		this.section = section;
		this.postText = postText;
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

}
