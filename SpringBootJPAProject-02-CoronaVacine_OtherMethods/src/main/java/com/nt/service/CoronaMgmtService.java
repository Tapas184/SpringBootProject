package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.coronarepo.ICoronaRepo;
import com.nt.entity.CoronaVacine;
@Service("coronaService")
public class CoronaMgmtService implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaRepo repo;
	@Override
	public String registerVaccine(CoronaVacine vaccine) {
		System.out.println("In memory proxy class"+repo.getClass());
		CoronaVacine corona= null;
		//use repo
		if(vaccine!=null)
			 corona=repo.save(vaccine);
		return corona!=null?"Vaccine Registered/Update Sucessfully"+corona.getRegNo():"Registration Failed";
	}
	//For Batch insertion
	@Override
	public Iterable<CoronaVacine> batchProcessing(
			Iterable<CoronaVacine> vacine) {
		if(vacine!=null)
		return repo.saveAll(vacine);
		else
			throw new IllegalArgumentException("Batch updation failed");
	}
	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}
	@Override
	public boolean checkAval(long regNo) {
		
		return repo.existsById(regNo);
	}
	@Override
	public Iterable<CoronaVacine> fatchAllDetails() {
		return repo.findAll();
	}
	@Override
	public Iterable<CoronaVacine> fatchAllDetailsByIds(List<Long> ids) {
		return repo.findAllById(ids);
	}
	@Override
	public Optional<CoronaVacine> fatchAllDetailsById(Long ids) {
		return repo.findById(ids);
	}
	@Override
	public String deleteAllById(Long id) {
		Optional<CoronaVacine> opt = repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);
		return id+"Record deleted";
		}
		return "Record not found";
	}

}
