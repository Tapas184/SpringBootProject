package com.nt.factory;

import com.nt.component.BlueDart;
import com.nt.component.Courior;
import com.nt.component.DTDC;
import com.nt.component.Flipkart;

public class FlipkartFactory {
    
    //static factory method having static factory method logic
    public static Flipkart getInstance(String couriorType) {
	Courior courior = null;
	if(couriorType.equalsIgnoreCase("dtdc")) 
	    courior = new DTDC();
	else if(couriorType.equalsIgnoreCase("bDart"))
	    courior = new BlueDart();
	else
	    throw new IllegalStateException("Invalid Courier Type");
	Flipkart fpt = new Flipkart();
	fpt.setCourior(courior);
	return fpt;
    }

}
