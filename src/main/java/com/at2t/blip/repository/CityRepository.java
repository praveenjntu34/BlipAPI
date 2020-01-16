package com.at2t.blip.repository;

import com.at2t.blip.dao.City;
import com.at2t.blip.dto.InstitutionResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<City,Integer> {
    @Query(value = "SELECT * FROM City  WHERE StateId = :stateId", nativeQuery = true)
    List<City> getAllCitiesByState(@Param("stateId") int stateId);

    @Query(value = "select CT from City CT\n" +
            "JOIN CT.state ST\n" +
            "WHERE CityId =125")
    List<City> findCityAndState(@Param("cityId") int cityId);



}

