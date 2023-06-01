package com.nt.service;

import java.util.*;

public interface IPersonService {
	
	public Set<String> getAllCountry();
	//method for all languaged
	public Set<String> getAllLanguages();
	//get Hobbies from DataBase
	public Set<String> getAllHobbies();

}//end of interface IPersonService
