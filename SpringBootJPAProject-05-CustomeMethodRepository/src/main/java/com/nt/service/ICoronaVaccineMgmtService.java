//
package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVacine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVacine> fatchByCompany(String company);
}
