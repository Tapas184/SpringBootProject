//
package com.nt.service;


import com.nt.entity.CoronaVacine;

public interface ICoronaVaccineMgmtService {
	public Iterable<CoronaVacine> fatchDetailsBy(boolean asc,String... props);
	
	//by page
	public Iterable<CoronaVacine> fatchDetailsByPageNo(int pageNo,int pageSize,boolean asc,String...properties);
	
	
	//page by page(PageNation)
	//public void fatchByPageNation(int pageSize);
}
