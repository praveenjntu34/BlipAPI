package com.at2t.blip.dao;

import javax.persistence.*;

@Entity
public class LoginCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int LoginCredentialId;

    private String email;

    private String PhoneNumber;

    private String Passcode;

    private String PasswordHash;

    private String PasswordSalt;


    @OneToOne
    @JoinColumn(name = "personId")
    @MapsId
    private Person person;

//    public LoginCredential(String email, String phoneNumber, String passcode, String passwordHash, String passwordSalt, Person person) {
//        this.email = email;
//        PhoneNumber = phoneNumber;
//        Passcode = passcode;
//        PasswordHash = passwordHash;
//        PasswordSalt = passwordSalt;
//        this.person = person;
//    }

    public int getLoginCredentialId() {
        return LoginCredentialId;
    }

    public void setLoginCredentialId(int loginCredentialId) {
        LoginCredentialId = loginCredentialId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPasscode() {
        return Passcode;
    }

    public void setPasscode(String passcode) {
        Passcode = passcode;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return PasswordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        PasswordSalt = passwordSalt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
