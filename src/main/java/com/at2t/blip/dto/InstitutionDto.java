package com.at2t.blip.dto;

import com.at2t.blip.dao.Address;
import com.at2t.blip.dao.InstitutionType;
import io.swagger.annotations.ApiModelProperty;

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
    private String remarks;
    @ApiModelProperty(position = 11)
    private Boolean status;
    @ApiModelProperty(position = 12)
    private int pictureId;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
