package com.at2t.blip.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PersonId")
    private int personId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Gender")
    private char gender;

    @Column(name = "PhotoStreamId")
    private String photoStreamId;

    @Column(name = "AuditCreatedBy")
    private int auditCreatedBy;

    @Column(name = "AuditCreatedDate")
    private Timestamp auditCreatedDate;

    @Column(name = "AuditModifiedBy")
    private int auditModifiedBy;

    @Column(name = "AuditModifiedDate")
    private Timestamp auditModifiedDate;

//    @OneToOne
//    @JoinColumn(name = "personTypeId")
//    @MapsId
//    private PersonType personType;

    @OneToOne(mappedBy = "person")
    private LoginCredential loginCredential;


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

//    public int getPersonTypeId() {
//        return personTypeId;
//    }
//
//    public void setPersonTypeId(int personTypeId) {
//        this.personTypeId = personTypeId;
//    }

    public String getPhotoStreamId() {
        return photoStreamId;
    }

    public void setPhotoStreamId(String photoStreamId) {
        this.photoStreamId = photoStreamId;
    }

    public int getAuditCreatedBy() {
        return auditCreatedBy;
    }

    public void setAuditCreatedBy(int auditCreatedBy) {
        this.auditCreatedBy = auditCreatedBy;
    }

    public Timestamp getAuditCreatedDate() {
        return auditCreatedDate;
    }

    public void setAuditCreatedDate(Timestamp auditCreatedDate) {
        this.auditCreatedDate = auditCreatedDate;
    }

    public int getAuditModifiedBy() {
        return auditModifiedBy;
    }

    public void setAuditModifiedBy(int auditModifiedBy) {
        this.auditModifiedBy = auditModifiedBy;
    }

    public Timestamp getAuditModifiedDate() {
        return auditModifiedDate;
    }

    public void setAuditModifiedDate(Timestamp auditModifiedDate) {
        this.auditModifiedDate = auditModifiedDate;
    }

//    public PersonType getPersonType() {
//        return personType;
//    }
//
//    public void setPersonType(PersonType personType) {
//        this.personType = personType;
//    }

    public LoginCredential getLoginCredential() {
        return loginCredential;
    }

    public void setLoginCredential(LoginCredential loginCredential) {
        this.loginCredential = loginCredential;
    }
}
