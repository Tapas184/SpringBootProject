package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class VoterEligbility implements InitializingBean, DisposableBean {
    private String name;
    private int age;
    private Date validateDate;

    // setter Method will call autometically

              public void setName(String name) {
      this.name = name;
      }
      public void setAge(int age) {
      this.age = age;
      }
      public VoterEligbility() {
	  System.out.println("VoterEligbility.VoterEligbility()::-0- Param Constructor");
      }
      
    @Override
    public void afterPropertiesSet() throws Exception {
	System.out.println("VoterEligbility.afterProperties(-)");
	validateDate = new Date();
	if (name == null || age <= 0)
	    throw new IllegalArgumentException("Illegal input kindly enter correct name and age");
    }

    @Override
    public void destroy() throws Exception {
	System.out.println("VoterEligbility.Destroy(-)");
	name = null;
	age = 0;
	validateDate = null;
    }

    public String voterElegbilityCheck() {
	if (age < 18)
	    return "Mr/Miss/Mrs " + name + " You are not eligble for vote " + name + " wait " + (18 - age)
		    + " years to Eligble for Vote check on " + validateDate;
	else
	    return "Mr/Miss/Mrs " + name + " You are Eligble for the vote. Check on " + validateDate;
    }

}
