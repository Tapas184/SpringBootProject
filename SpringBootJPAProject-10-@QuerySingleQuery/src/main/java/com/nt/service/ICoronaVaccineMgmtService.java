//
package com.nt.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nt.entity.CoronaVacine;

public interface ICoronaVaccineMgmtService {
	//Select vaccine by name
	public List<CoronaVacine> fetchByName(String name1);
	
	public List<CoronaVacine> fetchByPrice(double min, double max);
	
	public List<Object[]> fetchByCompany(String comp1, String comp2);
	
	public List<String> fetchByPriceRange(double min,double max);
	
	public CoronaVacine fetchVacineByName(String name);
	
	public Object fetchDetailsByCountry(String country);
}//CLASS
