package com.nt.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nt.component.Courior;
import com.nt.component.Flipkart;

public class FlipkartFactory {
    private static Properties props;
    static {
	//locate properties file
	try {
	InputStream is = new FileInputStream("src/com/nt/commons/inputs.properties");
	props = new Properties();
	props.load(is);
	}//try
	catch(FileNotFoundException fnf) {
	    fnf.printStackTrace();
	}//catch
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    //static factory method having static factory method logic
    public static Flipkart getInstance() {
	//get dependent class name(Courior name) from properties file(java.util.Properties obj) 
	try {
	String couriorClassName = props.getProperty("courior.type");
	Class c = Class.forName(couriorClassName);
	//Courior courier =  (Courior)c.newInstance(); //Depricated from java9
	Constructor cons[] = c.getDeclaredConstructors();
	Courior courier = (Courior)cons[0].newInstance();
	Flipkart fpt = new Flipkart();
	fpt.setCourior(courier);
	return fpt;
	}
	catch(ClassNotFoundException cnf) {
	    cnf.printStackTrace();
	    return null;
	}
	catch(Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }


}
