package com.at2t.blip.service;

import com.at2t.blip.dao.InstitutionDisplayPicture;
import com.at2t.blip.dao.Post;
import com.at2t.blip.dao.Section;
import com.at2t.blip.dto.PostRequestDto;
import com.at2t.blip.exception.FileStorageException;
import com.at2t.blip.repository.PostRepository;
import com.at2t.blip.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PostFileService {

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    PostRepository postRepository;

    public Post storePostFile(PostRequestDto postDto, MultipartFile file) {
        //Normalizing file
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Optional<Section> section = sectionRepository.findById(postDto.getSectionId());

            Post post = new Post(1, section.get(), postDto.getMessage(), postDto.getAttachmentStream().getBytes());

            return postRepository.save(post);
        } catch(IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
}
