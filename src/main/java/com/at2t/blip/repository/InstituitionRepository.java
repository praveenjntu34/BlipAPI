package com.at2t.blip.repository;


import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.dto.InstitutionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Institution;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InstituitionRepository extends CrudRepository<Institution, Integer> {

    @Query(value = "\n" +
            "SELECT new com.at2t.blip.dto.InstitutionResponse(I.institutionId, I.institutionName, IDP.pictureStream, AD.addressId) FROM Institution I\n" +
            "JOIN I.relTenantInstitution RI\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "JOIN RI.address AD")
    Page<InstitutionResponse> getAllInstitutions(Pageable pageable);

    @Query(value = "SELECT COUNT(I) FROM Institution I")
    int getCount();

    @Query(value = "\n" +
            "SELECT new com.at2t.blip.dto.InstitutionResponse(I.institutionId, I.institutionName, IDP.pictureStream, AD.addressId) FROM Institution I\n" +
            "JOIN I.relTenantInstitution RI\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "JOIN RI.address AD\n" +
            "WHERE AD.cityId = :cityId")
    Page<InstitutionResponse> getAllInstitutionsByCity(Pageable pageable, @Param("cityId") Integer cityId);

    @Query("SELECT new com.at2t.blip.dto.InstitutionResponseDto(I.institutionId,RI.institutionTypeID,RI.relTenantInstitutionId, I.institutionName,  I.email, I.website,  AD.address1,  AD.address2,AD.cityId,AD.stateId,I.remarks,  IDP.pictureStream, IDP.pictureId, AD.addressId) \n" +
            "FROM RelTenantInstitution RI\n" +
            "JOIN RI.institution I\n" +
            "JOIN RI.address AD\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "WHERE RI.relTenantInstitutionId = :relTenantInstitutionId")
    InstitutionResponseDto getInstitutionalDetails(@Param("relTenantInstitutionId") int id);

    @Query(value = "\n" +
            "SELECT new com.at2t.blip.dto.InstitutionResponse(I.institutionId, I.institutionName, IDP.pictureStream) FROM Institution I\n" +
            "JOIN I.relTenantInstitution RI\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "JOIN RI.address AD")
    List<InstitutionResponse> getAllInstitutionsDetails();
}
