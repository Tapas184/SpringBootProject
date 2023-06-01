package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
@Service("service")
public class WishMessageService implements IWishMsgService {
	
	@Override
	public String getWishMessage() {
		LocalDateTime ldt = LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<12)
			return "Good Morning ";
		else if(hour<16)
			return "Good afternoon";
		else if(hour<20)
			return "Good evening";
		else
		return "Good night";
	}

}
