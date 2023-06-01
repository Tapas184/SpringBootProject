package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("java")
public class JavaCourse implements ICourseMaterials {
	
	public JavaCourse() {
		System.out.println("JavaCousrse::0-Param constructor");
	}//

	@Override
	public String content() {
		System.out.println("JavaCousrse.content()");
		return "1. Core-Java, 2. OOPS, 3. Theading, 4. exception, 5. Collection, ";
	}//content

	@Override
	public double price() {
		System.out.println("JavaCousrse.price()");
		return 2000;
	}//price

}//class
