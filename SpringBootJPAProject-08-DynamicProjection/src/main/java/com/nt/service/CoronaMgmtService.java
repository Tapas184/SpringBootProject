package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.coronarepo.ICoronaRepo;
import com.nt.type.View;

@Service("coronaService")
public class CoronaMgmtService implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaRepo repo;

	@Override
	public <T extends View> List<T> searchVacineByCountry(String country, Class<T> clazz) {
		return repo.findByCountryOrderByCountry(country, clazz);
	}

}
