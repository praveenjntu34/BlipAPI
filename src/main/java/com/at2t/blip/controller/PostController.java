package com.at2t.blip.controller;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.BranchResponseDto;
import com.at2t.blip.dto.InstitutionDto;
import com.at2t.blip.dto.PostRequestDto;
import com.at2t.blip.service.PostFileService;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.dto.PostDto;
import com.at2t.blip.service.PostService;

import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "blip")
public class PostController {

	@Autowired
	PostFileService postService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Post addPost(@RequestBody PostRequestDto postDto) {

		Post post = postService.storePost(postDto);
		return  post;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/post/{relTenantInstitutionId}")
	public List<Post> getPosts(@PathVariable int relTenantInstitutionId) {

		List<Post> posts = postService.getPosts(relTenantInstitutionId);

		return posts;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/all-post/{sectionId}")
	public List<Post> getPosytsMobile(@PathVariable int sectionId) {

		List<Post> posts = postService.getPostsMobile(sectionId);

		return posts;

	}

//	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
//	public String deletePost(@RequestBody int postId) {
//		postService.deletePost(postId);
//		return "Delete Post";
//	}
//
//	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
//	public String updatePost(@RequestBody PostDto postDto) {
//		postService.updatePost(postDto);
//		return "Updated Post";
//	}

}
