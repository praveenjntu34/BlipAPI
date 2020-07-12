package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleListDto {
    private int relTenantInstitutionId;
    private String institutionName;

    public SimpleListDto(int relTenantInstitutionId, String institutionName) {
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.institutionName = institutionName;
    }
}
