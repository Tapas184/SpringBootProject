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
	public List<CoronaVacine> fatchByCompany(String company) {
		return repo.findByCompany(company);
	}

}
