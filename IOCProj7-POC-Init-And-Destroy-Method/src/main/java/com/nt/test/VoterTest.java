package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterEligbility;

public class VoterTest {

    public static void main(String[] args) {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
	 VoterEligbility voter=  ctx.getBean("voter",VoterEligbility.class);
	try {
	System.out.println(voter.voterElegbilityCheck());
	}//try
	catch(Exception e) {
	    e.printStackTrace();
	}//catch
	ctx.close();
    }

}
