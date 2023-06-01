//WishMessageGenerator.java(target class)
package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component("wmg")
public class WishMessageGenerator implements ApplicationContextAware {
@Autowired
     private LocalDateTime ldt;
private ApplicationContext ctx;
     //business method
@Override
public void setApplicationContext(ApplicationContext ctx) throws BeansException {
         System.out.println("WishMessageGenerator.setApplicationContext(-)");
         this.ctx=ctx;
}
public WishMessageGenerator() {
    System.out.println("WishMessageGenerator.WishMessageGenerator():-0-param Constructor");
}
     public String generatorWishMessage(String user) throws Exception {
	 //get hour of the day
	 int hours=ldt.getHour();  // 24 Hours Format
	 if(hours<12)
	     return "Goodmornig : "+user;
	 else if(hours<16)
	     return "Good afterNoon : "+user;
	 else if(hours<20)
	     return "Good evening : "+user;
	 else
	return "Good Night : "+user;
	 
     }

}
