package com.at2t.blip.repository;


import javax.persistence.EntityManager;

import com.at2t.blip.dao.RelTenantInstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Person;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
