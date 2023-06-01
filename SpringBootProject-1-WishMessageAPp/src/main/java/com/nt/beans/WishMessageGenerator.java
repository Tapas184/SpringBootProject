//wish message ganerator
package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	LocalDateTime ldt = LocalDateTime.now();

	public WishMessageGenerator() {
System.out.println("WishMessageGenerator.WishMessageGenerator()::0 param constructor");
	}
	public String ganeratorMessage(String user) {
		//invok hour
		int hour = ldt.getHour();
		//writen b.logic
		if(hour<12)
			return "GoodMorning"+user;
		else if(hour<16)
			return "Good Afternoon"+user;
		else if(hour<20)
			return "Good Evening"+user;
		else
			return "Good Night"+user;
	}//ganeratorMessage

}//class
