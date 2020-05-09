package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String  childrenName;
    public ParentResponseDto(String childrenName, String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.childrenName = childrenName;
        this.phoneNumber = phoneNumber;
    }
}
