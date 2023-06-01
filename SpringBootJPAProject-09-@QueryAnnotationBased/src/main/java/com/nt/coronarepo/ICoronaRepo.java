
//This is the marker Interface
package com.nt.coronarepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}//class
