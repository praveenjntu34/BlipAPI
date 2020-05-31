package com.at2t.blip.service;

import com.at2t.blip.dao.InstitutionDisplayPicture;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.PostDto;
import com.at2t.blip.dto.PostRequestDto;
import com.at2t.blip.exception.FileStorageException;
import com.at2t.blip.repository.PostRepository;
import com.at2t.blip.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PostFileService {

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    PostRepository postRepository;

    public Post storePostFile(MultipartFile file) {
        //Normalizing file
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Optional<Section> section = sectionRepository.findById(2);

            Post post = new Post(file.getBytes());


            postRepository.save(post);
            return post;

        } catch(IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }

    public Post storePost(PostRequestDto postDto) {

        try {
            Optional<Section> section = sectionRepository.findById(postDto.getSectionId());

            Post post = new Post(postDto.getTitle(), section.get(), postDto.getMessage(), postDto.getRelTenantInstitutionId());

            if(postDto.getPostId() == 0) {
                postRepository.save(post);
            } else {
                postRepository.updatePostDetails(postDto.getMessage(), postDto.getTitle(), postDto.getSectionId(),postDto.getRelTenantInstitutionId(), postDto.getPostId());

            }
            return post;

        } catch(Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    @Transactional
    public List<Post> getPosts(int relTenantInstitutionId) {

        try {
            return postRepository.getPosts(relTenantInstitutionId);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }

    }

    @Transactional
    public List<Post> getPostsMobile(int sectionId) {

        try {
            return postRepository.getPostsMobile(sectionId);
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }

    }
}
