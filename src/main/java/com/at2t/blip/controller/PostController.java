package com.at2t.blip.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.at2t.blip.dto.PostDto;
import com.at2t.blip.service.PostService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "blip")
public class PostController {

	@Autowired
	PostService postService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(@RequestBody PostDto postDto) {
		postService.addPost(postDto);
		return "Add Post";
	}

	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	public String deletePost(@RequestBody int postId) {
		postService.deletePost(postId);
		return "Delete Post";
	}

	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public String updatePost(@RequestBody PostDto postDto) {
		postService.updatePost(postDto);
		return "Updated Post";
	}

}
