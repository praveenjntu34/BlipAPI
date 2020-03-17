package com.at2t.blip.dto;

public class InstitutionResponse {
    private int institutionId;
    private String institutionName;
    private double count;
    public InstitutionResponse(int institutionId, String institutionName, byte[] pictureStream) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.pictureStream = pictureStream;
    }

    public InstitutionResponse(int institutionId, String institutionName, byte[] pictureStream, int addressId) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.pictureStream = pictureStream;
        this.addressId = addressId;
    }

    public InstitutionResponse() {
    }

    public void createRes() {

    }
    private byte[] pictureStream;
    private String cityName;
    private String stateName;
    private int addressId;

    public int getInstitutionId() {
        return institutionId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
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

