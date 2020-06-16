package com.at2t.blip.dao;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId")
	private int postId;

	@Column(name = "Title")
	private String title;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SectionId", referencedColumnName = "SectionId")
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

	public Post(String title, String postText) {
		this.title = title;
		this.postText = postText;
	}

	public Post(byte[] attachmentStreamId) {
		AttachmentStreamId = attachmentStreamId;
	}


}
