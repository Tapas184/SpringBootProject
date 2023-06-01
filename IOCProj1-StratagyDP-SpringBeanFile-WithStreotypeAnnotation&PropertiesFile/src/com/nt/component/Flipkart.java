package com.nt.component;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component("fkt")
@PropertySource({"com/nt/pro/prop.properties","com/nt/pro/pro1.properties"})

public final class Flipkart {
    @Autowired
    @Qualifier("dt")
    private Courior courior ; 	
    @Value("${pro.com.url}")
    private String url;
    @Value("${pro.com.age}")
    private int age;
    
    public Flipkart() {
	System.out.println("Flipkart :: 0-Param constructor");
    }//constructor

    /*    public void setCourior(Courior courior) {
    	System.out.println("Flipkart::setCourior(-)");
        this.courior = courior;
    }//setCourior(-)
     */
    public String shoping(String[] items,float[] price) {
	float billAmount =0.0f;
	for(float f:price) 
	    billAmount +=f; //billamount
	    //generate ramdom ID
	    int oid = new Random().nextInt(1000);
	    //use courior
	    System.out.println("OID Generated");
	    String msg = courior.deliver(oid);
	    return Arrays.toString(items)+" With Price "+Arrays.toString(price)+" Having BillAmount is "+billAmount+" ::"+msg+" with  "+url+"age ="+age ;
    }

}//class
