package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.coronarepo.ICoronaRepo;
import com.nt.entity.CoronaVacine;

@Service("coronaService")
public class CoronaMgmtService implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaRepo repo;

	@Override
	public List<CoronaVacine> serchVacineByGivenData(CoronaVacine vaccine, boolean asc, String... properties) {
		//prepare example object
		Example example = Example.of(vaccine);
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		List<CoronaVacine> listEntities = repo.findAll(example,sort);
		return listEntities;
	}

	@Override
	public CoronaVacine getVacineByRegNo(Long regNo) {
		
		return repo.getReferenceById(regNo);
	}

	@Override
	public String removeVaccineByRegNo(Iterable<Long> ids) {
		Iterable<CoronaVacine> listEntity = repo.findAllById(ids);
		if(((List)listEntity).size()!=0) {
			repo.deleteAllByIdInBatch(ids);
		return ((List)listEntity).size()+" no of records are deleted";
		}
		else
			return "No record found for delete";
	}

}
