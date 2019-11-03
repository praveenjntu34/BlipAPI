package com.at2t.blip.model;

import javax.persistence.*;

@Entity
public class InstitutionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InstitutionTypeId;

    private String InstitutionTypeName;
}
