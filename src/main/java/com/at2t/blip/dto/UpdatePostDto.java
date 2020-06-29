package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostDto {
    private int postId;
    private String title;
    private String message;
    private byte[] attachmentStreamId;
    private int sectionId;
    private int relTenantInstitutionId;
}
