//
package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVacine;

public interface ICoronaVaccineMgmtService {
	public String registerVaccine(CoronaVacine vaccine);
	
	//method-2 (For batch processing)-->Common supper class for all Collection
	public Iterable<CoronaVacine> batchProcessing(Iterable<CoronaVacine> vacine);
	
	//for vaccines count
	public long getCount();
	
	//check vaccine availability by regNo
	public boolean checkAval(long regNo);
	
	//fatchAllDetails
	public Iterable<CoronaVacine> fatchAllDetails();
	
	//find by id's
	public Iterable<CoronaVacine> fatchAllDetailsByIds(List<Long> ids);
	
	//working with optional method
	public Optional<CoronaVacine> fatchAllDetailsById(Long ids);
	
	//working with delete Method
	public String deleteAllById(Long id);

}
