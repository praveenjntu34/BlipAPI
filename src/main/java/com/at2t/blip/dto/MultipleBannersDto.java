package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleBannersDto {
    private String title;
    private String shortDescription;
    private int[] relTenantInstitutionId;
    private Integer AuditCreatedBy;
}
