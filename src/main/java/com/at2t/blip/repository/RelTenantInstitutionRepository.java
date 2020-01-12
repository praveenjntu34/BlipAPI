package com.at2t.blip.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.RelTenantInstitution;
import org.springframework.data.repository.query.Param;

public interface RelTenantInstitutionRepository extends JpaRepository<RelTenantInstitution, Integer> {

    @Modifying
    @Query(value = "INSERT INTO ReltenantInstitution VALUES(:TenantId, :InstitutionId,:InstitutionTypeId, :AddressId)", nativeQuery = true)
    public void insertData(@Param("TenantId") int tenantId, @Param("InstitutionTypeId") int institutionTypeId, @Param("AddressId") int addressId, @Param("InstitutionId") int institutionId);

    @Query(value = "SELECT * FROM ReltenantInstitution WHERE InstitutionId=:id", nativeQuery = true)
    public RelTenantInstitution findByTenantId(@Param("id") int id);


//    public void getAllInstitutions();
}
