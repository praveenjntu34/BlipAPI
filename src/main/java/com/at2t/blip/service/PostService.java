package com.at2t.blip.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at2t.blip.dto.PostDto;
import com.at2t.blip.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	@Transactional
	public void addPost(PostDto postDto) {
		postRepository.addPost(postDto.getPostText(), postDto.getPostType(),postDto.getSectionId(), postDto.getAttachmentStreamId(),
				postDto.getAuditCreatedBy(), postDto.getAuditCreatedDate());
	}

	@Transactional
	public void deletePost(Integer postId) {
		postRepository.deletePost(postId);
	}

	@Transactional
	public void updatePost(PostDto postDto) {
		postRepository.updatePost(postDto.getPostText(), postDto.getPostType(), postDto.getSectionId(),
				postDto.getAttachmentStreamId(), postDto.getAuditCreatedBy(), postDto.getAuditCreatedDate(),
				postDto.getPostId());

	}

}
