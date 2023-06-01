package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.coronarepo.ICoronaRepo;
import com.nt.entity.CoronaVacine;

@Service("coronaService")
public class CoronaMgmtService implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaRepo repo;

	@Override
	public List<CoronaVacine> fetchByName(String name1) {
		return repo.searchByName(name1);
	}

	@Override
	public List<CoronaVacine> fetchByPrice(double min, double max) {
		return repo.searchByPriceRange(min, max);
	}

	@Override
	public List<Object[]> fetchByCompany(String comp1, String comp2) {
		return repo.searchVacineByCompany(comp1, comp2);
	}

	@Override
	public List<String> fetchByPriceRange(double min, double max) {
		return repo.searchVacineByPriceRange(min, max);
	}

	@Override
	public CoronaVacine fetchVacineByName(String name) {
		return repo.searcVacineByname(name);
	}
	@Override
	public Object fetchDetailsByCountry(String country) {
		return repo.serchByCountry(country);
	}
}
