package com.at2t.blip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionResponseDto {
    private int relTenantInstitutionId;
    private int institutionId;
    private int institutionTypeId;
    private String institutionTypeName;
    private String institutionName;
    private String email;
    private String website;
    private String address1;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private  int stateId;
    private int pictureId;
    private int addressId;
    private String pincode;
    private int cityId;
    private String address2;
    private String stateName;
    private String cityName;
    private byte[] pictureStream;


    public InstitutionResponseDto( int institutionId,int institutionTypeId,int relTenantInstitutionId, String institutionName, String email,
                                   String website, String address1, String address2,int cityId,int stateId, String remark1,  byte[] pictureStream, int pictureId, int addressId
                                 ) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.institutionTypeId = institutionTypeId;
        this.email = email;
        this.website = website;
        this.address1 = address1;
        this.address2 = address2;
        this.cityId = cityId;
        this.stateId = stateId;
        this.remark1 = remark1;
        this.pictureStream = pictureStream;
        this.pictureId = pictureId;
        this.addressId = addressId;
    }


    public InstitutionResponseDto( int institutionId,int institutionTypeId,int relTenantInstitutionId, String institutionName, String email,
                                   String website, String address1, String address2,int cityId,int stateId, String remark1,  byte[] pictureStream,
                                   int pictureId, int addressId, String pincode
    ) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.institutionTypeId = institutionTypeId;
        this.email = email;
        this.website = website;
        this.address1 = address1;
        this.address2 = address2;
        this.cityId = cityId;
        this.stateId = stateId;
        this.remark1 = remark1;
        this.pictureStream = pictureStream;
        this.pictureId = pictureId;
        this.addressId = addressId;
        this.pincode = pincode;
    }

    public InstitutionResponseDto(
                                  int institutionId, int institutionTypeId,
                                  int relTenantInstitutionId,
                                  String institutionName,
                                  String email, String website,
                                  String address1, String address2, int cityId,
                                  int stateId,
                                  String remark1, String remark2, String remark3,
                                  String remark4,
                                   byte[] pictureStream, int pictureId, int addressId
                                  ) {
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.institutionId = institutionId;
        this.institutionTypeId = institutionTypeId;
        this.institutionName = institutionName;
        this.email = email;
        this.website = website;
        this.address1 = address1;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.stateId = stateId;
        this.pictureId = pictureId;
        this.addressId = addressId;
        this.cityId = cityId;
        this.address2 = address2;
        this.pictureStream = pictureStream;
    }

    public InstitutionResponseDto(
            int institutionId, int institutionTypeId,
            int relTenantInstitutionId,
            String institutionName,
            String email, String website,
            String address1, String address2, int cityId,
            int stateId,
            String remark1, String remark2, String remark3,
            String remark4,
            byte[] pictureStream, int pictureId, int addressId, String pincode
    ) {
        this.relTenantInstitutionId = relTenantInstitutionId;
        this.institutionId = institutionId;
        this.institutionTypeId = institutionTypeId;
        this.institutionName = institutionName;
        this.email = email;
        this.website = website;
        this.address1 = address1;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.stateId = stateId;
        this.pictureId = pictureId;
        this.addressId = addressId;
        this.cityId = cityId;
        this.address2 = address2;
        this.pictureStream = pictureStream;
        this.pincode = pincode;
    }
}
