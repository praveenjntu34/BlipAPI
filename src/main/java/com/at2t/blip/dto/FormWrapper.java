package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FormWrapper {
    private MultipartFile file;
    private String title;
    private String message;
    private int sectionId;
    private  int relTenantInstitutionId;
}