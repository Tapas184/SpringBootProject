//
package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVacine;
import com.nt.type.CustomeView;

public interface ICoronaVaccineMgmtService {
	// Vacine By price
	public List<CoronaVacine> fetchByPrice(double price);

	// Fetch Vacine ByCountry,Company,Price
	public List<CoronaVacine> fetchByCounty(List<String> country);

	public List<CustomeView> fetchByPriceRange(double price);
}// CLASS
