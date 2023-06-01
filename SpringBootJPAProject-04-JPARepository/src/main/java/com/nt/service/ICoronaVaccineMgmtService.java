//
package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVacine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVacine> serchVacineByGivenData(CoronaVacine vaccine,boolean asc,String... properties);
	
	//find br regNo
	public CoronaVacine getVacineByRegNo(Long regNo);
	
	//remove operations
	public String removeVaccineByRegNo(Iterable<Long> ids);
}
