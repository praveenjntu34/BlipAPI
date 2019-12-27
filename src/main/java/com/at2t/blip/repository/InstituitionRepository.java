package com.at2t.blip.repository;


import com.at2t.blip.dto.InstitutionResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Institution;

import java.util.List;

public interface InstituitionRepository extends CrudRepository<Institution, Integer> {

    @Query(value = "\n" +
            "SELECT new com.at2t.blip.dto.InstitutionResponse(I.institutionName, IDP.pictureStream) FROM Institution I\n" +
            "JOIN I.relTenantInstitution RI\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "JOIN RI.address AD")
    List<InstitutionResponse> getAllInstitutions();
}
