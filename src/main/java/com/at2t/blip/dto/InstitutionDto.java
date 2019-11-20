package com.at2t.blip.dto;

import com.at2t.blip.dao.Address;
import com.at2t.blip.dao.InstitutionType;

public class InstitutionDto {
    private String institutionName;
    private String email;
    private String website;
    private int institutionTypeId;
    private Address address;
    private String remarks;
    private Boolean status;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
