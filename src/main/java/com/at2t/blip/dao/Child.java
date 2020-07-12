package com.at2t.blip.dao;

import javax.persistence.*;

import com.at2t.blip.dto.ParentResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Child")
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChildId")
    private int childId;


    @OneToOne
    @JoinColumn(name = "parentId", referencedColumnName = "ParentId")
    private Parent parent;


    @Column(name="ChildrenName")
    private String childrenName;


    @Column(name="AdmissionId")
    private String admissionId;

    @Column(name="SectionId")
    private int sectionId;

    @Column(name="Enabled")
    private Boolean enabled;

    public Child() {
    }
}
