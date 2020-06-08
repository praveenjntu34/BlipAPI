package com.at2t.blip.dto;

import com.at2t.blip.dao.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostsDto {

    List<Post> postList;
    int pages;

}
