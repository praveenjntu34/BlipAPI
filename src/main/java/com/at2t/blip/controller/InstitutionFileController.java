package com.at2t.blip.controller;

import com.at2t.blip.dao.InstitutionDisplayPicture;
import com.at2t.blip.util.DBfileUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/institution/upload-file")
@Api(value = "blip")
public class InstitutionFileController {

    @Autowired
    DBfileUtils dBfileUtils;

    @PostMapping
    public InstitutionDisplayPicture uploadFile(@RequestParam("file") MultipartFile file) {
        InstitutionDisplayPicture displayPicture = dBfileUtils.storeFile(file);
        return displayPicture;
    }

}
