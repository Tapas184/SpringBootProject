package io.apsteer.service;

import org.springframework.stereotype.Service;

import io.apsteer.dao.IDaoService;
import io.apsteer.model.UserAccount;

@Service("captchService")
public class CaptchaService {

	private IDaoService dao;

	public CaptchaService(IDaoService dao) {
		this.dao = dao;
	}
	
	
	public String captchaValidation(int count, UserAccount acc) throws IllegalAccessException {
		
		if(count>3) {
			int updateAccount = dao.updateAccount(acc);
			if(updateAccount!=0)
				return "Account Has been locked kindly contact to admin for account unlock";
			else
				return "Account not availabe kindly create new Account";
		}
		return null;
	}
	
}
