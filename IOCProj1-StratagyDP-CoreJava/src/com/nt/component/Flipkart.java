package com.nt.component;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
    
    private Courior courior ; 	
    
    public Flipkart() {
	System.out.println("Flipkart :: 0-Param constructor");
    }//constructor

    public void setCourior(Courior courior) {
	System.out.println("Flipkart::setCourior(-)");
        this.courior = courior;
    }//setCourior(-)
     
    public String shoping(String[] items,float[] price) {
	float billAmount =0.0f;
	for(float f:price) 
	    billAmount +=f; //billamount
	    //generate ramdom ID
	    int oid = new Random().nextInt(1000);
	    //use courior
	    String msg = courior.deliver(oid);
	    return Arrays.toString(items)+" With Price "+Arrays.toString(price)+" Having BillAmount"+billAmount+" ::"+msg ;
    }

}//class
