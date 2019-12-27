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
