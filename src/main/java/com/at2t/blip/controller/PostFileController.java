package com.at2t.blip.controller;

import com.at2t.blip.dao.Post;
import com.at2t.blip.service.PostFileService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "blip")
public class PostFileController {

    @Autowired
    PostFileService postService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/post-file", method = RequestMethod.POST)
    public Post addPost(@RequestParam("file") MultipartFile file) {


        Post post = postService.storePostFile(file);
        return  post;
    }
}