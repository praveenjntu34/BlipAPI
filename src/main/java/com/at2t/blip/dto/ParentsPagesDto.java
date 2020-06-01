package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParentsPagesDto {
    List<ParentResponseDto> parents;
    int pages;
}
