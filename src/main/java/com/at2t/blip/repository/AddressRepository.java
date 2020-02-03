package com.at2t.blip.repository;

import com.at2t.blip.dao.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Integer> {
    @Query(value = "SELECT S.Statename,C.CityName FROM Address AD\n" +
            "JOIN State S ON S.StateId = AD.StateId\n" +
            "JOIN City C ON C.CityId = AD.CityId\n" +
            "WHERE AD.AddressId = :addressId",nativeQuery = true)
    List<Object[]> getAddressDetails(@Param("addressId") int addressId);
}
