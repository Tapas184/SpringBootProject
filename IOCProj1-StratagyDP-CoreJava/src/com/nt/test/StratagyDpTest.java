package com.nt.test;

import com.nt.component.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StratagyDpTest {

    public static void main(String[] args) {
	//get Target class object having dependency object
	Flipkart fpt = FlipkartFactory.getInstance("bDart");
	//invok b-method
	String result = fpt.shoping(new String[] {"Tshirt","Trouser"}, new float[] {1000.0f,5000.0f});
	System.out.println(result);

    }

}
