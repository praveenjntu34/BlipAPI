package com.at2t.blip.dto;

public class AuthenticationResponse {
    private final String jwt;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int personId;
    private int relTenantInstitutionId;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(String jwt, String email, String firstName, String lastName, String phoneNumber, String personTypeName, int personId) {
        this.jwt = jwt;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
        this.role = personTypeName;
    }

    public int getRelTenantInstitutionId() {
        return relTenantInstitutionId;
    }

    public void setRelTenantInstitutionId(int relTenantInstitutionId) {
        this.relTenantInstitutionId = relTenantInstitutionId;
    }

    public String getJwt() {
        return jwt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
