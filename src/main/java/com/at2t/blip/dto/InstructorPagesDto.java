package com.at2t.blip.dto;

import com.at2t.blip.dao.Instructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InstructorPagesDto {
    List<InstructorResponseDto> instructors;
    int pages;
}
