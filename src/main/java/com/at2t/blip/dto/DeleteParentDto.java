package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteParentDto {
    private int childId;
    private int parentId;
    private int personId;
    private int loginCredentialId;
}
