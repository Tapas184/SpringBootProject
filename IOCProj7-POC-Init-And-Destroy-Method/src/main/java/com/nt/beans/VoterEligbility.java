package com.nt.beans;

import java.util.Date;

public class VoterEligbility {
    private String name;
    private int age;
    private Date validateDate;
    
  //setter injection
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void myInit() {
	System.out.println("VoterEligbility.myInit(-)");
	validateDate = new Date();
	if(name==null || age<=0)
	    throw  new IllegalArgumentException("Illegal input kindly enter correct name and age");
    }// myInit Method
    
    public void myDestroy() {
	System.out.println("VoterEligbility.myDestroy(-)");
	name=null;
	age=0;
	validateDate=null;
    }//
    
public String voterElegbilityCheck() {
       if(age<18)
	   return "Mr/Miss/Mrs "+name+" You are not eligble for vote "+name+" wait "+(18-age)+" years to Eligble for Vote check on "+validateDate;
       else
    return "Mr/Miss/Mrs "+name+" You are Eligble for the vote. Check on "+validateDate;
   }

}
