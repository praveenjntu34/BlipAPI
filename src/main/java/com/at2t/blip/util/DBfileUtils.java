package com.at2t.blip.util;

import com.at2t.blip.dao.InstitutionDisplayPicture;
import com.at2t.blip.exception.FileStorageException;
import com.at2t.blip.repository.InstitutionDisplayPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBfileUtils {

    @Autowired
    InstitutionDisplayPictureRepository displayPictureRepository;

    public InstitutionDisplayPicture storeFile(MultipartFile file) {
        //Normalizing file
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            InstitutionDisplayPicture displayPicture  = new InstitutionDisplayPicture(file.getContentType(),file.getBytes());
            return displayPictureRepository.save(displayPicture);
        } catch(IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }

    public InstitutionDisplayPicture getFile(int fileId) {
        return displayPictureRepository.findById(fileId)
                .orElseThrow(() -> new FileStorageException("File not found with id " + fileId));
    }
}
