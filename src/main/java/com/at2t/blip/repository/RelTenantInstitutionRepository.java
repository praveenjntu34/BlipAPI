package com.at2t.blip.repository;


import com.at2t.blip.dto.InstitutionDetailsResponse;
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

    @Query(value = "SELECT ReltenantInstitutionId FROM ReltenantInstitution WHERE InstitutionId=:id", nativeQuery = true)
    public int findByTenantId(@Param("id") int id);

    @Query(value = "SELECT * FROM ReltenantInstitution", nativeQuery = true)
    public List<RelTenantInstitution> findAllInstitutions();


//    public void getAllInstitutions();
}
