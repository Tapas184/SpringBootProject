
//This is the marker Interface
package com.nt.coronarepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVacine;
import com.nt.type.View;

public interface ICoronaRepo extends JpaRepository<CoronaVacine, Long> {
	//Dynamic Projection Implementation
	public <T extends View> List<T> findByCountryOrderByCountry(String country, Class<T> clazz);
}//class
