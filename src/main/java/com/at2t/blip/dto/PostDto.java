package com.at2t.blip.dto;

import java.sql.Timestamp;

public class PostDto {

	private int postId;

	private int postType;

	private int sectionId;

	private String postText;

	private String attachmentStreamId;

	private int auditCreatedBy;

	private Timestamp auditCreatedDate;

	int auditModifiedBy;

	Timestamp auditModifiedDate;

	public int getPostId() {
		return postId;
	}

	public int getPostType() {
		return postType;
	}

	public int getSectionId() {
		return sectionId;
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

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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
