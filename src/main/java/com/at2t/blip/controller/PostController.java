package com.at2t.blip.controller;

import com.at2t.blip.dto.PostRequestDto;
import com.at2t.blip.service.PostFileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.at2t.blip.dto.PostDto;
import com.at2t.blip.service.PostService;

import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "blip")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	PostFileService postService;

	@Autowired
	ModelMapper modelMapper;

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addPost(@RequestPart("data") PostRequestDto postDto, @RequestPart("file") MultipartFile file) {
		postService.storePostFile(postDto, file);
		return "Add Post";
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
