package io.apsteer.dao;

import io.apsteer.model.UserAccount;

public interface IDaoService {
	
	public int updateAccount(UserAccount acc) throws IllegalAccessException;

}
