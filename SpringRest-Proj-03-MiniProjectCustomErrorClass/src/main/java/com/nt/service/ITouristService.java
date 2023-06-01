package com.nt.service;

import java.util.List;

import com.nt.customexception.TouristNotFoundException;
import com.nt.entity.Tourist;


public interface ITouristService {
	//insert the tourist details
	public String registerTourist(Tourist tourist) throws Exception;
	//find the tourist by Id
	public Tourist getById(Integer id) throws TouristNotFoundException;
	//find all tourist
	public List<Tourist> fetchAllTourist() throws Exception;
	//update Tourist Details
	public String updateTourist(Tourist tourist) throws TouristNotFoundException;

}//end of the interface class
