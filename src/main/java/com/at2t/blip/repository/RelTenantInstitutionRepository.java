package com.at2t.blip.repository;


import com.at2t.blip.dto.InstitutionResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.RelTenantInstitution;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelTenantInstitutionRepository extends JpaRepository<RelTenantInstitution, Integer> {

    @Modifying
    @Query(value = "INSERT INTO ReltenantInstitution VALUES(:TenantId, :InstitutionId,:InstitutionTypeId, :AddressId)", nativeQuery = true)
    public void insertData(@Param("TenantId") int tenantId, @Param("InstitutionTypeId") int institutionTypeId, @Param("AddressId") int addressId, @Param("InstitutionId") int institutionId);

    @Query(value = "SELECT relTenantInstitutionId FROM ReltenantInstitution WHERE InstitutionId=:id", nativeQuery = true)
    public int findByRelTenantId(@Param("id") int id);

    @Query(value = "SELECT * FROM ReltenantInstitution", nativeQuery = true)
    public List<RelTenantInstitution> findAllInstitutions();

    @Query("SELECT new com.at2t.blip.dto." +
            "InstitutionResponseDto(I.institutionId,RI.institutionTypeID," +
            "RI.relTenantInstitutionId, I.institutionName,  I.email, I.website,  " +
            "AD.address1,  AD.address2,AD.cityId,AD.stateId, I.remark1, " +
            "I.remark2, I.remark3, I.remark4,  IDP.pictureStream, " +
            "IDP.pictureId, AD.addressId) \n" +
            "FROM RelTenantInstitution RI\n" +
            "JOIN RI.institution I\n" +
            "JOIN RI.address AD\n" +
            "JOIN I.institutionDisplayPicture IDP\n" +
            "WHERE RI.relTenantInstitutionId = :relTenantInstitutionId")
    InstitutionResponseDto getInstitutionalDetails(@Param("relTenantInstitutionId") int id);



//    public void getAllInstitutions();
}
