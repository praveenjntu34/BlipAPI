package com.at2t.blip.dao;

import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Entity
public class InstitutionDisplayPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PictureId")
    private int pictureId;

    @Column(name = "FileType")
    private String fileType;

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getPictureStream() {
        return pictureStream;
    }

    public void setPictureStream(byte[] pictureStream) {
        this.pictureStream = pictureStream;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public InstitutionDisplayPicture() {
    }

    @Lob
    @Column(name = "PictureStream")
    private byte[] pictureStream;

    @OneToOne(mappedBy="institutionDisplayPicture")
    private Institution institution;

    public InstitutionDisplayPicture(String fileType, byte[] pictureStream) {
        this.fileType = fileType;
        this.pictureStream = pictureStream;
    }
}
