package com.at2t.blip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int LoginCredentialId;

    private int PersonId;

    private String Email;

    private String PhoneNumber;

    private String Passcode;

    private String PasswordHash;

    private String PasswordSalt;
}
