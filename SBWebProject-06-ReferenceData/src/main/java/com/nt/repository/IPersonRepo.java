package com.nt.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
	
	@Query("SELECT HOBBI FROM PERSONHOBY")
	public Set<String> getAllHobies();

}
