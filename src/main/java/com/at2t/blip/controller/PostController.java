package com.at2t.blip.controller;

import com.at2t.blip.dao.Branch;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.*;
import com.at2t.blip.service.PostFileService;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public PostsDto getPosts(@PathVariable int relTenantInstitutionId, @RequestParam(value = "pageNumber", required = false) Integer pageNumber , @RequestParam(value = "size", required = false) Integer size) {

		PostsDto posts = postService.getPosts(relTenantInstitutionId, pageNumber, size);

		return posts;

	}


	@RequestMapping(method = RequestMethod.GET, value = "/all-post/{sectionId}")
	public List<Post> getPosytsMobile(@PathVariable int sectionId) {

		List<Post> posts = postService.getPostsMobile(sectionId);

		return posts;

	}

	@RequestMapping(value = "/deletePost/{postId}", method = RequestMethod.DELETE)
	public Object deletePost(@PathVariable("postId") int postId) {
		return postService.delete(postId);

	}


	@RequestMapping(value = "/updatePost", method = RequestMethod.PUT)
	public Object updatePost(@RequestBody UpdatePostDto postDto) {


		return postService.update(postDto);
	}

}
