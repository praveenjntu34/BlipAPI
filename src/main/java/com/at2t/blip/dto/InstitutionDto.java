package com.at2t.blip.dto;

import com.at2t.blip.dao.Address;
import com.at2t.blip.dao.InstitutionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InstitutionDto {
    @ApiModelProperty(position = 1)
    private String institutionName;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    private String website;
    @ApiModelProperty(position = 4)
    private int institutionTypeId;
    @ApiModelProperty(position = 5)
    private String address1;
    @ApiModelProperty(position = 6)
    private String address2;
    @ApiModelProperty(position = 7)
    private int cityId;
    @ApiModelProperty(position = 8)
    private int stateId;
    @ApiModelProperty(position = 9)
    private int countryId;
    @ApiModelProperty(position = 10)
    private String remark1;
    @ApiModelProperty(position = 11)
    private String remark2;
    @ApiModelProperty(position = 12)
    private String remark3;
    @ApiModelProperty(position = 13)
    private String remark4;
    @ApiModelProperty(position = 14)
    private Boolean status;
    @ApiModelProperty(position = 15)
    private int institutionId;
    @ApiModelProperty(position = 16)
    private int addressId;
    @ApiModelProperty(position = 17)
    private String pincode;
    @ApiModelProperty(position = 18)
    private int pictureId;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getInstitutionTypeId() {
        return institutionTypeId;
    }

    public void setInstitutionTypeId(int institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
