package com.at2t.blip.repository;

import com.at2t.blip.dao.Child;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Parent;


public interface ChildRepository extends CrudRepository<Child, Integer> {


}
