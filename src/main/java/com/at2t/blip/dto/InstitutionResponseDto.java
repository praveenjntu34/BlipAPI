package com.at2t.blip.dto;

public class InstitutionResponseDto {
    private int relTenantInstitutionId;
    private int institutionId;
    private int institutionTypeId;
    private String institutionName;
    private String email;
    private String website;
    private String address1;
    private String remarks;
    private  int stateId;
    private int pictureId;
    private int addressId;
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private int cityId;
    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    private String address2;
    private String stateName;
    private String cityName;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    private byte[] pictureStream;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getInstitutionTypeName() {
        return institutionTypeId;
    }

    public int getInstitutionTypeId() {
        return institutionTypeId;
    }

    public void setInstitutionTypeId(int institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
    }

    public void setInstitutionTypeName(int institutionTypeName) {
        this.institutionTypeId = institutionTypeName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public byte[] getPictureStream() {
        return pictureStream;
    }

    public void setPictureStream(byte[] pictureStream) {
        this.pictureStream = pictureStream;
    }




    public InstitutionResponseDto( int institutionId,int institutionTypeId,int relTenantInstitutionId, String institutionName, String email,
                                   String website, String address1, String address2,int cityId,int stateId, String remarks,  byte[] pictureStream, int pictureId, int addressId
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
        this.remarks = remarks;
        this.pictureStream = pictureStream;
        this.pictureId = pictureId;
        this.addressId = addressId;
    }








}
