package com.spring.bean;

import java.util.Date;

public class WishMessageGenerator {

	private Date date ;

	//setter method
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String generateWishMessage(String user) {
		
		int hour = date.getHours();//24 hours
		if(hour<12)
			return "GoodMorning :"+user;
		else if(hour>12 && hour<=17)
			return "GoodAfterNoon :"+user;
		else if(hour>17 && hour<=20)
			return "GoodEvening :"+user;
		else
			return "GoodNight:"+user;
		
	}
}
