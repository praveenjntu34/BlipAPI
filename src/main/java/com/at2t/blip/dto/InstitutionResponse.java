package com.at2t.blip.dto;

public class InstitutionResponse {
    private int institutionId;
    private String institutionName;

    public InstitutionResponse(int institutionId, String institutionName, byte[] pictureStream) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.pictureStream = pictureStream;
    }

    private byte[] pictureStream;
    private String cityName;
    private String stateName;

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public byte[] getPictureStream() {
        return pictureStream;
    }

    public void setPictureStream(byte[] pictureStream) {
        this.pictureStream = pictureStream;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRecentStatus() {
        return recentStatus;
    }

    public void setRecentStatus(String recentStatus) {
        this.recentStatus = recentStatus;
    }

    private String countryName;
    private String recentStatus;


    public InstitutionResponse(int institutionId, byte[] pictureStream, String cityName, String stateName, String countryName) {
        this.institutionId = institutionId;
        this.pictureStream = pictureStream;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
    }
}
