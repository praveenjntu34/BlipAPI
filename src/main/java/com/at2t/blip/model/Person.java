package com.at2t.blip.model;

import javax.persistence.*;
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

    @Column(name = "PersonTypeId")
    private int personTypeId;

    @Column(name = "PhotoStreamId")
    private String photoStreamId;

    @Column(name = "AuditCreatedBy")
    private String auditCreatedBy;

    @Column(name = "AuditCreatedDate")
    private String auditCreatedDate;

    @Column(name = "AuditModifiedBy")
    private String auditModifiedBy;

    @Column(name = "AuditModifiedDate")
    private String auditModifiedDate;


}
