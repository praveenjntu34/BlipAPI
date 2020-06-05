package com.at2t.blip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateParentDto {
    private int personId;
    private String parentOneFirstName;
    private String parentOneLastName;

    private int loginCredentialId;
    private String email;
    private String phoneNumber;


    private int parentId;
    private String secondaryPhoneNumber;
    private String secondaryParentName;




}
