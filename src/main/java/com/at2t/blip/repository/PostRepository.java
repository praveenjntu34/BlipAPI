package com.at2t.blip.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Post(PostText,PostTypeId,SectionId,AttachmentStreamId,AuditCreatedBy,AuditCreatedDate) VALUES(:postText,:postTypeId,:sectionId,:attachmentStreamId,:auditCreatedBy,:auditCreatedDate)", nativeQuery = true)
	public void addPost(@Param("postText") String postText, @Param("postTypeId") int PostTypeId, @Param("sectionId") int sectionId,
			@Param("attachmentStreamId") String attachmentStreamId, @Param("auditCreatedBy") int auditCreatedBy,
			@Param("auditCreatedDate") Timestamp auditCreatedDate);

	@Modifying
	@Query(value = "Delete from Post where PostId=:postId", nativeQuery = true)
	public void deletePost(@Param("postId") int postId);

	@Modifying
	@Query(value = "update Post set PostText=:postText,PostTypeId=:postTypeId,SectionId=:sectionId,AttachmentStreamId=:attachmentStreamId,AuditCreatedBy=:auditCreatedBy,AuditCreatedDate=:auditCreatedDate where PostId=:postId", nativeQuery = true)
	public void updatePost(@Param("postText") String postText, @Param("postTypeId") int PostTypeId,
			@Param("sectionId") int sectionId, @Param("attachmentStreamId") String attachmentStreamId,
			@Param("auditCreatedBy") int auditCreatedBy, @Param("auditCreatedDate") Timestamp auditCreatedDate,
			@Param("postId") int postId);

}
