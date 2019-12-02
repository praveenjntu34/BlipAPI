package com.at2t.blip.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	

}
