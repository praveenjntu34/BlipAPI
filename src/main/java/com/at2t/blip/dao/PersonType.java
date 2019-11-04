package com.at2t.blip.dao;

import javax.persistence.*;

public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PersonTypeId")
    private int personTypeId;

    @Column(name="PersonTypeName")
    private String personTypeName;

//    @OneToOne(mappedBy = "personType")
//    private Person person;

    public int getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(int personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getPersonTypeName() {
        return personTypeName;
    }

    public void setPersonTypeName(String personTypeName) {
        this.personTypeName = personTypeName;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
