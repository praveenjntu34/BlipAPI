package com.at2t.blip.repository;

import java.sql.Timestamp;
import java.util.List;

import com.at2t.blip.dao.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Post;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends CrudRepository<Post, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Post(PostText,PostTypeId,SectionId,AttachmentStreamId,AuditCreatedBy,AuditCreatedDate) VALUES(:postText,:postTypeId,:sectionId,:attachmentStreamId,:auditCreatedBy,:auditCreatedDate)", nativeQuery = true)
	public void addPost(@Param("postText") String postText, @Param("postTypeId") int PostTypeId, @Param("sectionId") int sectionId,
			@Param("attachmentStreamId") String attachmentStreamId, @Param("auditCreatedBy") int auditCreatedBy,
			@Param("auditCreatedDate") Timestamp auditCreatedDate);

	@Modifying
	@Query(value = "Delete from Post where PostId=:postId", nativeQuery = true)
	public void deletePost(@Param("postId") int postId);

	@Query("SELECT p FROM Post p WHERE relTenantInstitutionId= :relTenantInstitutionId")
	Page<Post> getPosts(int relTenantInstitutionId, Pageable pageable);

	@Query("SELECT p FROM Post p WHERE SectionId= :sectionId")
	List<Post> getPostsMobile(int sectionId);

	@Modifying
	@Transactional
	@Query(value = "update Post set PostText=:postText,Title=:title,SectionId=:sectionId,RelTenantInstitutionId=:relTenantInstitutionId where PostId=:postId", nativeQuery = true)
	public void updatePostDetails(@Param("postText") String postText, @Param("title") String title,
						   @Param("sectionId") int sectionId,@Param("relTenantInstitutionId") int relTenantInstitutionId, @Param("postId") int postId);

	@Modifying
	@Query(value = "update Post set PostText=:postText,PostTypeId=:postTypeId,SectionId=:sectionId,AttachmentStreamId=:attachmentStreamId,AuditCreatedBy=:auditCreatedBy,AuditCreatedDate=:auditCreatedDate where PostId=:postId", nativeQuery = true)
	public void updatePost(@Param("postText") String postText, @Param("postTypeId") int PostTypeId,
			@Param("sectionId") int sectionId, @Param("attachmentStreamId") String attachmentStreamId,
			@Param("auditCreatedBy") int auditCreatedBy, @Param("auditCreatedDate") Timestamp auditCreatedDate,
			@Param("postId") int postId);

}
