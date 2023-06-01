package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<CoronaVacine> fatchDetailsBy(boolean asc, String... props) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		Iterable<CoronaVacine> listEntity = repo.findAll(sort);

		return listEntity;
	}

	@Override
	public Iterable<CoronaVacine> fatchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC, properties);
		Page<CoronaVacine> page = repo.findAll(pageable);
		return page.getContent();
	}

}
