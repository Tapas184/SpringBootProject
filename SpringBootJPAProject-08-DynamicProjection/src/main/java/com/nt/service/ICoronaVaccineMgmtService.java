//
package com.nt.service;

import java.util.List;

import com.nt.type.View;

public interface ICoronaVaccineMgmtService {
	//Vacine By price
	public <T extends View> List<T> searchVacineByCountry(String country,Class<T> clazz);
}//CLASS
