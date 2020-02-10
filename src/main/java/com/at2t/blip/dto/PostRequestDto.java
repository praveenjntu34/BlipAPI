package com.at2t.blip.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostRequestDto {
    private String title;
    private String message;
    private MultipartFile attachmentStream;
    private int sectionId;

    public PostRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getAttachmentStream() {
        return attachmentStream;
    }

    public void setAttachmentStream(MultipartFile attachmentStream) {
        this.attachmentStream = attachmentStream;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
}
