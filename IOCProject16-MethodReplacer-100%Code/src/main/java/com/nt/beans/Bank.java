//Dependency class
package com.nt.beans;

import org.springframework.stereotype.Component;

@Component
public class Bank {
    public double intrest(double pAmount,double rate,double time) {
	System.out.println("Bank.compundIntrest(-,-,-)");
	//writen b. logics
	return  (pAmount*Math.pow(1+rate/100, time))-pAmount;
    }// intrest 

}//bank
