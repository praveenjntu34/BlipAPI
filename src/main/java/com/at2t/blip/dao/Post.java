package com.at2t.blip.dao;

import java.sql.Timestamp;

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
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId")
	private int postId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PostTypeId", referencedColumnName = "PostTypeId")
	@MapsId
	@JsonIgnore
	private PostType postType;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SectionId", referencedColumnName = "SectionId")
	@MapsId
	@JsonIgnore
	private Section section;

	@Column(name = "PostText")
	private String postText;

	@Column(name = "AttachmentStreamId")
	private String attachmentStreamId;

	@Column(name = "AuditCreatedBy")
	private int auditCreatedBy;

	@Column(name = "AuditCreatedDate")
	private Timestamp auditCreatedDate;

	@Column(name = "AuditModifiedBy")
	int auditModifiedBy;

	@Column(name = "AuditModifiedDate")
	Timestamp auditModifiedDate;

	public int getPostId() {
		return postId;
	}

	public PostType getPostType() {
		return postType;
	}

	public Section getSection() {
		return section;
	}

	public String getPostText() {
		return postText;
	}

	public String getAttachmentStreamId() {
		return attachmentStreamId;
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

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public void setAttachmentStreamId(String attachmentStreamId) {
		this.attachmentStreamId = attachmentStreamId;
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
