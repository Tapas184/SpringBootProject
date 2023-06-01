//client site 
package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Bank;

public class BankIntrestTest {

    public static void main(String[] args) {
	System.out.println("BankIntrestTest.main()");

	//create  IOC container
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
	// create Bank object
	Bank bank = ctx.getBean("bank",Bank.class);
	//invok Business Method and display to the consol
	System.out.println("Intrest Amount is ::"+bank.intrest(10000, 2, 10));
	//closing IOC container
	ctx.close();
    }

}
