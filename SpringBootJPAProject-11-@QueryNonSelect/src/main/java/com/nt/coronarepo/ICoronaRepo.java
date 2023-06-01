
//This is the marker Interface
package com.nt.coronarepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.CoronaVacine;

public interface ICoronaRepo extends JpaRepository<CoronaVacine, Long> {
	
	//"SELECT country,name,price FROM CORONA_VACINE WHERE name=:name1"
	@Query("FROM CoronaVacine WHERE name=:name1")
	public List<CoronaVacine> searchByName(String name1);
	@Query("From CoronaVacine Where price>=?1 And price<=?2 Order by price desc")
	public List<CoronaVacine> searchByPriceRange(double min, double max);
	//select operation for static-Projections/sclar projection
	@Query("Select name,company,price from CoronaVacine where company In(:comp1,:comp2) order by price")
	public List<Object[]> searchVacineByCompany(String comp1, String comp2);
	//Dynamic Scalar Projections
	@Query("SELECT name,company,price from CoronaVacine WHERE price BETWEEN :min and :max")
	public List<String> searchVacineByPriceRange(double min, double max);
	
	//Query for single column operation
	@Query("FROM CoronaVacine WHERE name=:name1")
	public CoronaVacine searcVacineByname(String name1);
	
	//Select Multiple column Value from given data
	@Query("SELECT regNo,country,name,price FROM CoronaVacine WHERE country=:country1")
	public Object serchByCountry(String country1);
	
	//non select query
	@Modifying
	@Query("UPDATE CoronaVacine SET price=?1 WHERE name=?2") // both ?1 and :name1 not allowed
	@Transactional
	public int updateByPrice(double price1,String name1);
}//class
